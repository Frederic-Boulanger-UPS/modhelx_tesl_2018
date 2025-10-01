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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*@
 * A clock implication which puts a tick on the slave clock each time n ticks have been counted on a counting clock after a tick on the reference clock.
 */
public class DelayedImplication<M1 extends Comparable<? super M1>,
                                M2 extends Comparable<? super M2>,
                                S  extends Comparable<? super S>> extends ImplicationRelation {
    private final boolean immediate_;
    //@ List of number of ticks remaining to count
    private List<Integer> delays_;
    //@ Did we already add a delay in this instant?
    private boolean delay_added_;
    //@ Did we already count the delays in this instant?
    private boolean delay_counted_;
    //@ Total number of ticks of the delay
    private final int total_delay_;
    //@ Should we reset any counting delay when the master clock ticks?
    private final boolean reset_;

    /**
     * Get slave by delaying reference (immediately or not) by n on counting
     * @param reference clock to delay
     * @param counting clock for counting the delay
     * @param slave delayed clock
     * @param n length of the delay
     * @param immediate does the delay start immediately (if 'counting' tick at the same time as 'reference')
     * @param reset does a tick on the master clock reset any pending delay
     */
    public DelayedImplication(Clock<M1> reference, Clock<M2> counting, Clock<S> slave, int n, boolean immediate, boolean reset) {
        super(slave, reference, counting);
        this.total_delay_ = n;
        this.delays_ = new LinkedList<Integer>();
        this.delay_added_ = false;
        this.immediate_ = immediate;
        this.reset_ = reset;
    }

    /**
     * Get slave by delaying reference (not immediately) without reset, by n on counting
     * @param reference clock to delay
     * @param counting clock for counting the delay
     * @param slave delayed clock
     * @param n length of the delay
     */
    public DelayedImplication(Clock<M1> reference, Clock<M2> counting, Clock<S> slave, int n, boolean immediate) {
        this(reference, counting, slave, n, immediate, false);
    }

    /**
     * Get slave by delaying reference (not immediately) without reset, by n on counting
     * @param reference clock to delay
     * @param counting clock for counting the delay
     * @param slave delayed clock
     * @param n length of the delay
     */
    public DelayedImplication(Clock<M1> reference, Clock<M2> counting, Clock<S> slave, int n) {
        this(reference, counting, slave, n, false);
    }
    
    @Override
    public boolean isInstantaneous() {
    	return this.total_delay_ == 0;
    }

    /**
     * Return the reference clock, for the DelayedFor constraint
     */
    @SuppressWarnings("unchecked")
	public Clock<M1> getReferenceClock() {
        return (Clock<M1>) getMasterClocks()[0];
    }

    /**
     * Return the counter clock, for the DelayedFor constraint
     */
    @SuppressWarnings("unchecked")
	public Clock<M2> getCountingClock() {
        return (Clock<M2>) getMasterClocks()[1];
    }

    @Override
    public void endSolving() {
        this.delay_added_ = false;
        this.delay_counted_ = false;
    }
    /**
     * Determine whether a tick should be set as "now" on the slave clock
     * Impose the slave clock to tick synchronously with the n-th tick of 
     * the counter clock (master2 clock) following a tick of the reference 
     * clock (master1 clock) 
     */
    @Override
    public boolean induceTicks() {
        // Did we start a new delay?
        boolean start = false;
        // Did we induce a new tick?
        boolean new_tick = false;

        // If the master clock has a tick now, start counting total_delay_ ticks on the counting clock
        if (!this.delay_added_ && getReferenceClock().hasRealTickNow()) {
            start = true;
            // If a new tick on the master clock resets any pending delay, clear the delay list
            if (this.reset_) {
                this.delays_.clear();
            }
            this.delays_.add(this.total_delay_);
            this.delay_added_ = true;
        }
        // If we have delays to count and the counting clock has a tick now, decrement the remaining delays
        if (!this.delay_counted_ && this.getCountingClock().hasRealTickNow()) {
            // Decrement count for delays that were not started at this instant
            for (int i = 0; i < this.delays_.size() - 1; i++) {
                this.delays_.set(i, this.delays_.get(i) - 1);
            }
            // Decrement count of last delay if it didn't start at this instant or the delay is immediate
            if (this.immediate_ || ! start) {
                int last = this.delays_.size() - 1;
                if (last >= 0) {
                    this.delays_.set(last, this.delays_.get(last) - 1);
                }
            }
            this.delay_counted_ = true;

            // If we have delays to count and the remaining delay is 0, put a now tick on the slave clock 
            // This test is not done inside the previous test because total_delay_ can be 0
            for (int i = 0; i < this.delays_.size(); i++) {
                if (this.delays_.get(i) == 0) {
                    this.delays_.remove(i);
                    new_tick |= getSlaveClock().newNowTick();
                }
            }
        }
        // If we have done everything we can do in this instant, mark this implication as applied
        if (this.delay_added_ && this.delay_counted_) {
        	this.appliedNow();
        }
        return new_tick;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("DelayedImplication: by ");
        builder.append(this.total_delay_);
        builder.append(this.immediate_ ? ", immediate, " : ", delayed, [");
        for (int d : this.delays_) {
            builder.append(d);
            builder.append(" ");
        }
        builder.append("]. ");
        builder.append(super.toString());
        return builder.toString();
    }

    private class DelayedImplicationBackup implements ImplicationBackupInterface {
        public ArrayList<Integer> backup_delay_;
        public boolean backup_delay_added_;

        @SuppressWarnings("synthetic-access")
        public DelayedImplicationBackup() {
            this.backup_delay_ = new ArrayList<Integer>(DelayedImplication.this.delays_);
            this.backup_delay_added_ = DelayedImplication.this.delay_added_;
        }

        @Override
        public void restore() {
            DelayedImplication.this.restore(this);
        }
    }

    @Override
    public ImplicationBackupInterface backup() {
        return new DelayedImplicationBackup();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void restore(ImplicationBackupInterface bck) {
        this.delays_ = new LinkedList<Integer>(((DelayedImplicationBackup)bck).backup_delay_);
        this.delay_added_ = ((DelayedImplicationBackup)bck).backup_delay_added_;
    }
}
