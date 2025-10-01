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

package fr.supelec.modhelx.core.simulation;

import fr.supelec.tesl.core.LongCalc;

/**
 * A driving clock that ticks periodically on real time.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class PeriodicRTClock extends DrivingClock<Long> {
    /**
     * The thread used to notify the execution engine when a tick is produced on the clock.
     * 
     * @author frederic.boulanger@supelec.fr
     *
     */
    private class PeriodicRTThread extends Thread {
        /** Should the thread keep running? */
        public  boolean run;

        public PeriodicRTThread() {
            this.run = false;
        }

        public void cancel() {
            this.interrupt();
        }

        @SuppressWarnings("synthetic-access")
		@Override
        public void run() {
            this.run = true;
            while (this.run) {
                try {
                    // Wait for the engine to be waiting for us.
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    // Interrupt means check again if we should run
                    continue;
                }
                if (PeriodicRTClock.this.listener_ != null) {
                    // Compute the delay to wait to reach the next tick of the clock
                    long delay = tagDifference(PeriodicRTClock.this.getNextTime(), System.currentTimeMillis());
                    try {
                        // Sleep until this time has come
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        // Interrupt means check again if we should run
                        continue;
                    }
                    synchronized (PeriodicRTClock.this.listener_) {
                        // Produce next RT tick now
                        PeriodicRTClock.this.newTick(tagSum(getNextTime(), PeriodicRTClock.this.offset_)).setNow(true);
                    }
                }
            }
        }
    }

    private PeriodicRTThread mythread_;

    /** The period of the clock, in milliseconds. */
    private long period_;
    /** the offset between the system time and this clock. */
    private long offset_;
    /** The time for the next tick. */
    private long next_tick_time_;

    public PeriodicRTClock(String name, long milliseconds, long initialTag) {
        super(name, new LongCalc());
        this.period_ = milliseconds;
        // Initialize the time for the next tick
        //*** Do not use tag calculus in the constructor since the clock is not yet registered with the solver ***
//        this.next_tick_time_ = tagSum(System.currentTimeMillis(), milliseconds);
//        this.offset_ = tagDifference(initialTag, this.next_tick_time_);
        this.next_tick_time_ = System.currentTimeMillis() + initialTag;
        this.offset_ = initialTag - this.next_tick_time_;
        this.mythread_ = new PeriodicRTThread();
        this.mythread_.start();
    }

    /** Compute the time for the next tick.
     * If this time is is the past, add as many periods as necessary to bring it in the future.
     */
    public long getNextTime() {
        while (this.next_tick_time_ <= System.currentTimeMillis()) {
            // Skip missed ticks
            this.next_tick_time_ = tagSum(this.next_tick_time_, this.period_);
        }
        return this.next_tick_time_;
    }

    @Override
    public void foresee() {
        newTick(tagSum(getNextTime(), this.offset_));
    }

    @Override
    public void backToPresent() {
        // Nothing to do, backup/restore will do the job
    }

    @Override
    public void activate() {
        synchronized (this.mythread_) {
            this.mythread_.notify();
        }
    }

    @Override
    public void cancel() {
        resetClock();
        this.mythread_.cancel();
    }

    @Override
    public void wrapup() {
        this.mythread_.run = false;
        this.mythread_.interrupt();

    }
}
