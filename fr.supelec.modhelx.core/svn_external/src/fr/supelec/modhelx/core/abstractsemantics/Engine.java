/*
 * This file is part of ModHel'X.
 *
 * ModHel'X is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * ModHel'X is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with ModHel'X. If not, see <http://opensource.org/licenses/EPL-1.0>.
 * 
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 * 
 */

package fr.supelec.modhelx.core.abstractsemantics;

import java.util.LinkedList;
import java.util.List;

import fr.supelec.tesl.logging.Logger;
import fr.supelec.tesl.logging.SysErrHandler;
import fr.supelec.modhelx.core.simulation.DrivingClock;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.ClockOperation;
import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.core.ClockSetMark;
import fr.supelec.tesl.core.IntegerCalc;
import fr.supelec.tesl.core.Unit;
import fr.supelec.tesl.core.UnitCalc;

/**
 * The execution engine of ModHel'X, which drives the abstract semantics of models and blocks. 
 */
public class Engine extends NamedEntity{
    /** The logger used for logging actions related to the execution of models. */
    public final Logger logger_;
    /** The root model of this engine. */
    private Model<?> rootModel_;
    /** The clock solver used by this engine. */
    private ClockSet solver_;
    /** The clock that triggers the snapshots of the root model.
     *  If this clock has no tick, the simulation stops.
     */
    private Clock<Integer> snapshot_clock_;
    /** A clock used to tell the engine to stop.
     *  If this clock has a "now" tick, the simulation stops.
     */
    private Clock<Unit> stop_clock_;
    /** List of clock operations to perform after a non validation. */
    private List<ClockOperation<?>> clockOperations_;

    /** Build a new execution engine, with name <code>name</code>, and root model <code>root</code>. */
    public Engine(String name, Model<?> root) {
        super(name);
        this.logger_ = Logger.getLogger(name);
        this.rootModel_ = root;
        root.setEngine(this);
        // Create a solver for this engine
        this.solver_ = new ClockSet();
        // Create and add the snapshot clock to the solver
        this.snapshot_clock_ = this.solver_.addNewClock(Integer.class, "Snapshot", new IntegerCalc());
        // Create and add the "stop" clock to the solver
        this.stop_clock_ = this.solver_.addNewClock(Unit.class, "Stop", new UnitCalc());
        this.clockOperations_ = new LinkedList<ClockOperation<?>>();
        this.logger_.addInformationKinds("error", "info", "fine", "finer");
        if (this.logger_.getHandlers().size() == 0) {
            this.logger_.addHandler(new SysErrHandler());
        }
    }

    /** Get the logger of this execution engine. */
    public Logger getLogger() {
        return this.logger_;
    }

    /** Get the clock solver of this execution engine. */
    public ClockSet getSolver() {
        return this.solver_;
    }

    /** Get the "stop" clock of this execution engine. */
    public Clock<Unit> getStopClock() {
        return this.stop_clock_;
    }

    /** Get the "snapshot" clock of this execution engine. */
    public Clock<Integer> getSnapshotClock() {
        return this.snapshot_clock_;
    }

    /** Stop simulation after <code>n</code> snapshots. */
    public void stopAfter(int n) {
        this.snapshot_clock_.impliesThroughFilter(this.stop_clock_, n, 1, 0, 0);
    }

    /** Add a clock operation to perform before the next iteration when the snapshot is not validated. */
    public void addClockOperation(ClockOperation<?> op) {
        this.clockOperations_.add(op);
    }

    /** Find which driving clocks can trigger a snapshot, and return whether we are still running or not. */
    private boolean findDrivingClocks() {
        // We don't know if there will be a snapshot yet
        boolean running = false;
        // Store the current state of the clock solver in bck
        ClockSetMark bck = this.solver_.getMark();
        // Set the driving clocks to greedy mode in order to find the ones that may trigger the next snapshot
        for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
            c.foresee();
            c.setGreedy(true);
        }
        this.logger_.log("info", "---- Solving for driving clock");
        try {
            // Solve the clock system to find which driving clocks may trigger a snapshot
            this.solver_.solve();
        } catch (Exception e1) {
            e1.printStackTrace();
            System.exit(1);
        }

        StringBuilder message = new StringBuilder("----> Driving clocks that may trigger a snapshot: ");
        // If the stop clock has a tick "now", the simulation ends
        if (this.stop_clock_.hasTickNow()) {
            running = false;
        } else {
            // Become a listener to all driving clocks that may trigger a snapshot
            for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
                if (c.hasTickNow()) {
                    message.append(c.getName()).append(",  ");
                    c.setListener(this);
                    // A driving clock may trigger a snapshot, so we are running
                    running = true;
                }
            }
        }
        message.append("=> running=").append(running);
        this.logger_.log("info", message);
        for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
            c.backToPresent();
        }
        // Restore the clock system to the state it had before solving for finding the driving clocks 
        this.solver_.setMark(bck);
        return running;
    }

    /** Wait for one of the driving clocks to tick. */
    private void waitForDrivingClocks() {
        this.logger_.log("info", "---- Waiting for driving clocks");
        // If we are running, wait for one of the driving clocks to trigger the next snapshot
        synchronized (this) {
            for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
                // Tell each driving clock that we are waiting for it
                c.activate();
            }
            try {
                // Wait for a tick on any driving clock
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
                // Tell each driving clock that we stopped waiting for it
                c.cancel();
            }
        }		
    }

    /** Compute a snapshot. <code>raw_bck</code> contains the state of the ClockSet before solving for the snapshot. */
    private void computeSnapshot(ClockSetMark raw_bck) {
        this.logger_.log("info", "---- Start of snapshot");
        // Call strtOfSnapshot on the root model => delegated through the hierarchy
        //System.out.println("------------Snapshot at : "+ this.rootModel_.getMoC().getClock().getNowTick().getTagValue()+ " DE-----------------");
        this.rootModel_.startOfSnapshot();
        // This snapshot has not been validated yet
        boolean validated = false;
        // Store the current state of the system clock in case be have to compute the snapshot again (if not validated)
        ClockSetMark bck = this.solver_.getMark();
        // Number of iterations for computing this snapshot
        int iteration = 0;
        do {
            if (iteration > 0) {
                if (this.clockOperations_.isEmpty()) {
                    // If this is NOT the first iteration, restore the clock system to the state it had at the beginning of the snapshot
                    this.solver_.setMark(bck);
                } else {
                    // If there are clock operations to perform, restore the clock system to the sate it had before solving at the beginning of the snapshot
                    this.solver_.setMark(raw_bck);
                    for (ClockOperation<?> op : this.clockOperations_) {
                        op.perform();
                    }
                    // Solve again from the new initial clock state
                    try {
                        this.solver_.solve();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                    if (this.stop_clock_.hasTickNow() || !this.snapshot_clock_.hasTickNow()) {
                        // Weird, the new conditions halt the simulation or don't require a snapshot
                        throw new Error("# Invalid change on clock system during a snapshot: no snapshot required after non validation.");
                    }
                    this.clockOperations_.clear();
                }
            }
            // One more iteration
            iteration++;
            this.logger_.log("info", "---- Reset");
            // Reset the root model
            this.rootModel_.reset();
            // Update the root model
            this.logger_.log("info", "---- Start of update");
            this.rootModel_.startOfUpdate();
            this.logger_.log("info", "---- Update");
            this.rootModel_.update();
            this.logger_.log("info", "---- End of update");
            this.rootModel_.endOfUpdate();

            this.logger_.log("info", "---- Validate");
            // Is this snapshot validated?
            validated = this.rootModel_.validate();
            // If not validated, go for one more iteration
        } while (!validated);
        this.logger_.log("info", "---- End of snapshot");
        // The snapshot has been validated, so call endOfSnapshot so that everybody can update its internal state and produce outputs
        this.rootModel_.endOfSnapshot();
    }

    /** Run the simulation. */
    public void run() {
        // Keep running?
        boolean running = false;
        int snapshot_number = 1;
        this.logger_.log("info", "---- Prep");
        // Initialize the root model
        this.rootModel_.prep();
        this.rootModel_.sanityCheck();

        this.logger_.log("info", "---- Setup");

        // Setup the root model for the simulation
        this.rootModel_.setup();

        // Add an implication relation to make a snapshot each time the root model should be observed
        this.rootModel_.getMoC().getClock().implies(this.snapshot_clock_);

        do {
            this.snapshot_clock_.newTick(snapshot_number);
            running = findDrivingClocks();
            if (running) {
                waitForDrivingClocks();

                this.logger_.log("info", "---- Solving for snapshot");
                // Store the raw state (before solving) of the clocks (used when not validating a snapshot)
                ClockSetMark raw_bck = this.solver_.getMark();
                //				System.err.println("# Before solving for snapshot:");
                //				System.err.println(this.solver_);
                // Solve the clock system to know which clocks have a tick for this snapshot
                try {
                    this.solver_.solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                //                if (this.snapshot_clock_.hasTicks()) {
                //                    this.snapshot_clock_.getTick(0).setTagValue(snapshot_number);
                //                    snapshot_number++;
                //                }
                //				System.err.println("# After solving for snapshot:");
                //				System.err.println(this.solver_);
                // If the snapshot clock has a tick now, compute a snapshot
                if (this.snapshot_clock_.hasTickNow()) {
                    computeSnapshot(raw_bck);
                    // After end of snapshot, clear clocks. New ticks will be created in emitObservationResquests
                    this.solver_.resetClocks();

                    this.logger_.log("info", "---- Observation requests");
                    // The clocks have been reset, it is time to post observation request for future snapshots
                    this.rootModel_.emitObservationRequests();
                } else {
                    // If the snapshot clock has no tick now, the simulation ends
                    running = false;
                }
            }
        } while (running);
        this.logger_.log("info", "---- Wrapup");
        // At the end of the simulation, call wrapup to release resources, close files and so on.
        this.rootModel_.wrapup();
        // Wrapup is also called on driving clocks so that they can release resources, kill threads, close windows...
        for(DrivingClock<?> c : DrivingClock.getDrivingClocks()) {
            c.wrapup();
        }
    }
}
