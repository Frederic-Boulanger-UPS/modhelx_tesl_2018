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


/*@
 * A clock implication which puts a tick on the slave clock each time some duration has elapsed 
 * on a time measuring clock after a tick on the reference clock.
 * The implication can be reset by a reset clock.
 */
public class TimeDelayedImplication<M1 extends Comparable<? super M1>,
                                    M2 extends Comparable<? super M2>,
                                    R  extends Comparable<? super R>,
                                    S  extends Comparable<? super S>> extends ImplicationRelation {
    //@ Do I have to post a tick on the counting clock?
    private boolean should_post_tick_;
    //@ Did I already post a future tick on the measuring clock?
    private Tick<M2> future_tick_created_;
    //@ Did I already created a tick on the slave clock?
    private boolean slave_tick_created_;
    //@ Duration of the delay
    private final M2 time_delay_;
    //@ Ruler clock used to create ticks without modifying the measuring clock
    private final Clock<M2> ruler_clock_;
    //@ Reset clock to cancel delayed ticks
    private final Clock<R> reset_clock_;
    //@ Is the reset immediate
    private boolean immediate_reset_;
    //@ Is the reset strong
    private boolean strong_reset_;
    //@ Should I do a reset at this instant
    private boolean do_reset_;

    /**
     * Generate tick on slave by delaying ticks on reference by duration d on measuring
     * @param reference clock to delay
     * @param measuring clock for timing the delay
     * @param slave delayed clock
     * @param d duration of the delay
     */
    public TimeDelayedImplication(Clock<M1> reference, Clock<M2> measuring, Clock<S> slave, M2 d) {
        this(reference, measuring, null, slave, d, true);
    }

    /**
     * Generate tick on slave by delaying ticks on reference by duration d on measuring
     * @param reference clock to delay
     * @param measuring clock for timing the delay
     * @param reset clock for the implication
     * @param slave delayed clock
     * @param d duration of the delay
     * @param use_ruler use another ruler clock to create the delayed ticks
     */
    public TimeDelayedImplication(Clock<M1> reference, Clock<M2> measuring, Clock<R> reset, Clock<S> slave, M2 d, boolean use_ruler) {
        super(true, slave, reset, reference, measuring);
        this.reset_clock_ = reset;
        this.immediate_reset_ = false;
        this.strong_reset_ = false;
        if (use_ruler) {
            this.ruler_clock_ = measuring.getSolver().addClock(measuring.getCopy("__" + measuring.getName() + "_ruler__"));
            this.ruler_clock_.getSolver().hideClock(this.ruler_clock_);
            try {
				this.ruler_clock_.sameTags(measuring);
			} catch (Exception e) {
				// Can be safely ignored because this relation cannot close a cycle in the tag relations graph
				e.printStackTrace();
			}
        } else {
            this.ruler_clock_ = measuring;
        }
        this.time_delay_ = d;
        this.should_post_tick_ = false;
        this.future_tick_created_ = null;
        this.slave_tick_created_ = false;
    }

    public TimeDelayedImplication<M1, M2, R, S> setImmediateReset(boolean immediate) {
    	this.immediate_reset_ = immediate;
    	return this;
    }

    public TimeDelayedImplication<M1, M2, R, S> setStrongReset(boolean strong) {
    	this.strong_reset_ = strong;
    	return this;
    }

    @Override
    public boolean isInstantaneous() {
    	return TagCalculusFactory.getCalculus(this.time_delay_).isZero(this.time_delay_);
    }

    /**
     * Return the reference clock, for the TimeDelayedBy constraint
     */
    @SuppressWarnings("unchecked")
	public Clock<M1> getReferenceClock() {
        return (Clock<M1>) getMasterClocks()[0];
    }

    /**
     * Return the measuring clock, for the TimeDelayedBy constraint
     */
    @SuppressWarnings("unchecked")
	public Clock<M2> getMeasuringClock() {
        return (Clock<M2>) getMasterClocks()[1];
    }

    @Override
    public void startSolving() {
        super.startSolving();
        this.slave_tick_created_ = false;
        this.should_post_tick_ = false;
        this.future_tick_created_ = null;
        this.do_reset_ = false;
        if (this.immediate_reset_ && getSolver().dependsOn(this.reset_clock_, getReferenceClock())) {
            throw new Error("# Unsupported dependency of reset clock on master clock in immediately reset time delayed implication. " + this);
        }
        if (this.strong_reset_ && getSolver().dependsOn(this.reset_clock_, getSlaveClock())) {
            throw new Error("# Unsupported dependency of reset clock on slave clock in strongly reset time delayed implication. " + this);
        }
    }

    @Override
    public void endSolving() {
        if (this.should_post_tick_) {
            throw new Error("# Error: " + this + " could not find current tag on " + getMeasuringClock());
        }
        if (this.do_reset_) {
        	if (this.immediate_reset_ && (this.future_tick_created_ != null)) {
        		throw new Error("# Inconsistency: time delay started while reset clock ticks in an immediately reset time delayed implication. " + this);
        	}
        	if (this.strong_reset_ && (this.slave_tick_created_)) {
        		throw new Error("# Inconsistency: tick created on slave while reset clock ticks in a strongly reset time delayed implication. " + this);
        	}
        }
    }

    private void removeTicksFromRuler(Tick<M2> keep) {
		for (Tick<M2> t : this.ruler_clock_.getTicks()) {
			if (t != keep && (t.getUserData(this) != null)) {
				if ((!t.isNow()) || this.strong_reset_) {
					t.remove();
				}
			}
		}
    }

    /**
     * Determine whether a tick should be set as "now" on the slave clock.
     */
    @Override
    public boolean induceTicks() {
        boolean new_tick = false;
        
        this.do_reset_ = (this.reset_clock_ != null) && this.reset_clock_.hasRealTickNow();
        
        // If we do not already know that we should post a tick on the measuring clock,
        // and we didn't already post a tick on it, check if there is a now tick on the master clock.
        if ((! this.should_post_tick_) && (this.future_tick_created_ == null)) {
        	if (this.do_reset_ && this.immediate_reset_) { // immediate reset => don't post
        		this.should_post_tick_ = false;
        	} else {
        		this.should_post_tick_ = this.getReferenceClock().hasRealTickNow();
        	}
        }

        // If we haven't already created a tick on the slave at this instant and there is no strong reset
        if (!this.slave_tick_created_ && !(this.do_reset_ && this.strong_reset_)) {
            Tick<M2> tick = this.ruler_clock_.getNowTick();
            if ((tick != null) && (tick.getUserData(this) != null)) {
                // If the measuring clock has a now tick that this relation has created
                // create the implied tick on the slave clock
                new_tick = getSlaveClock().newNowTick();
                this.slave_tick_created_ = true;
            }
        }
        
        // Check if we should and could post a tick on the measuring clock
        Clock<M2> measuringClock = getMeasuringClock();
        // Get the current time on the measuring clock
        Tag<M2> tag = measuringClock.getCurrentTag();
        if ((this.should_post_tick_) && (tag != null) && (tag.getValue() != null)) {
            // If we know the current time on the measuring clock, compute the tag of the next implication
            M2 nexttag = this.ruler_clock_.tagSum((tag.getValue()), this.time_delay_);
            this.future_tick_created_ = this.ruler_clock_.newTick(nexttag);
            this.future_tick_created_.setUserData(this, true);
            this.should_post_tick_ = false;
            new_tick = true;
        }
        if (((this.future_tick_created_ != null) || (this.do_reset_ && this.immediate_reset_))
         && (this.slave_tick_created_ || (this.do_reset_ && this.strong_reset_))) {
            // If I posted a future tick and created a tick on the slave,
        	// or if I know I should not do so, I am done for now
            appliedNow();
        }
        if (this.do_reset_) {
        	// If we have a reset, remove all future ticks on the ruler
        	if (this.immediate_reset_) {
        		removeTicksFromRuler(null);
        	} else {
        		// Do not remove the one we just created if the reset is not immediate
        		removeTicksFromRuler(this.future_tick_created_);
        	}
        }
        return new_tick;
    }

    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder("TimeDelayedImplication");
    	boolean props_written = false;
    	if (this.immediate_reset_) {
    		if (!props_written) {
    			builder.append(" (");
    			props_written = true;
    		}
    		builder.append("immediate");
    	}
    	if (this.strong_reset_) {
    		if (!props_written) {
    			builder.append(" (");
    			props_written = true;
    		} else {
    			builder.append(", ");
    		}
    		builder.append("strong");
    	}
    	if (props_written) {
    		builder.append(" reset)");
    	}
    	builder.append(": ");
    	builder.append(this.time_delay_);
    	builder.append(", ");
    	builder.append(super.toString());
        return builder.toString();
    }

    private class DelayedImplicationBackup implements ImplicationBackupInterface {
        @SuppressWarnings("hiding")
		public boolean should_post_tick_;
        @SuppressWarnings("hiding")
		public boolean slave_tick_created_;
        @SuppressWarnings("hiding")
		public Tick<M2> future_tick_created_;
        @SuppressWarnings("hiding")
		public boolean do_reset_;

        @SuppressWarnings("synthetic-access")
        public DelayedImplicationBackup() {
            this.should_post_tick_ = TimeDelayedImplication.this.should_post_tick_;
            this.slave_tick_created_ = TimeDelayedImplication.this.slave_tick_created_;
            this.future_tick_created_ = TimeDelayedImplication.this.future_tick_created_;
            this.do_reset_ = TimeDelayedImplication.this.do_reset_;
        }

        @Override
        public void restore() {
            TimeDelayedImplication.this.restore(this);
        }
    }
    @Override
    public ImplicationBackupInterface backup() {
        return new DelayedImplicationBackup();
    }

    @Override
    public void restore(ImplicationBackupInterface bck) {
        @SuppressWarnings("unchecked")
        DelayedImplicationBackup backup = (DelayedImplicationBackup)bck;
        this.should_post_tick_ = backup.should_post_tick_;
        this.slave_tick_created_ = backup.slave_tick_created_;
        this.future_tick_created_ = backup.future_tick_created_;
        this.do_reset_ = backup.do_reset_;
    }
}
