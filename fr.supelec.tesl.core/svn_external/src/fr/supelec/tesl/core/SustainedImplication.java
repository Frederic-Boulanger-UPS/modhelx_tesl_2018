/*
 * This file is part of TESL.
 *
 * TESL is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * TESL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with TESL. If not, see <http://opensource.org/licenses/EPL-1.0>.
 *
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 *
 */

package fr.supelec.tesl.core;


/**
 * A clock implication which creates ticks on the slave at each tick of the master between a tick of start and a tick of stop.
 */
public class SustainedImplication<M1 extends Comparable<? super M1>,
                                  M2 extends Comparable<? super M2>,
                                  M3 extends Comparable<? super M3>,
                                  S  extends Comparable<? super S>> extends ImplicationRelation {
    //@ Is the implication on (between start and stop)?
    private boolean on_;
    private boolean starting_;
    private boolean stopping_;
    private boolean tick_created_;
    //@ Is the implication immediate (slave gets a tick if start and master have a tick at the same time)?
    private final boolean immediate_;
    //@ Is the sustain weak (slave does not get a tick if stop and master have a tick at the same time)?
    private final boolean weak_;

    /**
     * Constructor
     * @param master reference clock
     * @param start start events clock
     * @param stop stop events clock
     * @param slave slave clock
     * @param immediate start implication immediately, at the very instant when start occurs
     * @param weak the implication is weak, stop at the very instant when stop occurs
     */
    public SustainedImplication(Clock<M1> master, Clock<M2> start, Clock<M3> stop, Clock<S> slave, boolean immediate, boolean weak) {
        super(slave, master, start, stop);
        this.on_ = false;
        this.starting_ = false;
        this.stopping_ = false;
        this.tick_created_ = false;
        this.immediate_ = immediate;
        this.weak_ = weak;
    }

    /**
     * Constructor for a not immediate and strong sustained implication
     * @param master clock
     * @param start master clock
     * @param stop master clock
     * @param slave
     */
    public SustainedImplication(Clock<M1> master, Clock<M2> start, Clock<M3> stop, Clock<S> slave) {
        this(master, start, stop, slave, false, false);
    }

    /**
     * Return the master clock, or reference clock, for the sustained implication
     */
    @SuppressWarnings("unchecked")
    public Clock<M1> getMasterClock() {
        return (Clock<M1>) getMasterClocks()[0];
    }

    /**
     * Return the start clock, for the sustained implication
     */
    @SuppressWarnings("unchecked")
    public Clock<M2> getStartClock() {
        return (Clock<M2>) getMasterClocks()[1];
    }

    /**
     * Return the stop clock, for the sustained implication
     */
    @SuppressWarnings("unchecked")
    public Clock<M3> getStopClock() {
        return (Clock<M3>) getMasterClocks()[2];
    }

    @Override
    /**
     * Impose the slave clock to tick synchronously with the reference clock (master1 clock) ticks
     * starting from the tick of the start clock (master2 clock) up until the tick of the stop clock
     * (master3 clock)
     */
    public boolean induceTicks() {
        // We never call appliedNow() because we have to check for now ticks very late in the solving process
        if (getStartClock().hasRealTickNow()) {
            this.starting_ = true;
        }
        if (getStopClock().hasRealTickNow()) {
            this.stopping_ = true;
            if (this.weak_ && this.tick_created_) {
                // Oops! This is a weak sustain, we already created a tick on the slave clock
                // and we discover now that the stop clock ticks => there is some dependency hidden in the tag relations
                throw new Error("# Weak sustain aborted after having implied a tick => dependency through tag relations? " + this);
            }
        }
        if ( (! this.tick_created_) && getMasterClock().hasRealTickNow() // If we didn't already create a slave tick and there is a master tick
                && (                                        //   and
                        (this.starting_ && this.immediate_)          //     we are starting in immediate mode
                        || this.on_                              //     or we are on
                        ) && ( (!this.stopping_) || (!this.weak_) )    //   and we are not stopping (unless we are not in weak sustain mode)
                ) {
            this.tick_created_ = true;                  // Remember we created a tick in case we are stopped later in the same instant
            return getSlaveClock().newNowTick();
        }
        // No new tick created
        return false;
    }

    @Override
    public void startSolving() {
        super.startSolving();
        // We can't have a dependency of our stop clock on our slave clock if the sustain is weak (strong preemption)
        if (this.weak_ && getSolver().dependsOn(getStopClock(), getSlaveClock())) {
            throw new Error("# Unsupported dependency of stop clock on slave clock in weak sustain. " + this);
        }
        // We can't have a dependency of our start clock on our slave clock if the sustain is immediate
        if (this.immediate_ && getSolver().dependsOn(getStartClock(), getSlaveClock())) {
            throw new Error("# Unsupported dependency of start clock on slave clock in immediate sustain. " + this);
        }
        this.starting_ = false;
        this.stopping_ = false;
        this.tick_created_ = false;
    }

    @Override
    public void endSolving() {
        super.endSolving();
        if (getStartClock().hasRealTickNow() && (! this.starting_)) {
            throw new Error("# Inconsistency: start clock has tick now and I am not starting. " + this);
        }
        if (getStopClock().hasRealTickNow() && (! this.stopping_)) {
            throw new Error("# Inconsistency: stop clock has tick now and I am not stopping. " + this);
        }
        if (this.starting_) {
            this.on_ = true;
        }
        if (this.stopping_) {
            this.on_ = false;
        }
    }

    @Override
    public String toString() {
        return "SustainedImplication "
                + (this.immediate_ ? "immediate" : "delayed")
                + " and "
                + (this.weak_ ? "weak" : "strong")
                + " (" + (this.on_ ? "on" : "off") + "): " + super.toString();
    }

    private class SustainedImplicationBackup implements ImplicationBackupInterface {
        public boolean backup_on_;

        @SuppressWarnings("synthetic-access")
        public SustainedImplicationBackup() {
            this.backup_on_ = SustainedImplication.this.on_;
        }

        @Override
        public void restore() {
            SustainedImplication.this.restore(this);
        }
    }
    @Override
    public ImplicationBackupInterface backup() {
        return new SustainedImplicationBackup();
    }

    @Override
    public void restore(ImplicationBackupInterface bck) {
        @SuppressWarnings("unchecked")
        SustainedImplicationBackup backup = (SustainedImplicationBackup)bck;
        this.on_ = backup.backup_on_;
    }
}