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
 * A clock implication which creates ticks on the slave by filtering the ticks of the master clock according to a pattern.
 */
public class FilteredImplication<M extends Comparable<? super M>,
                                 S extends Comparable<? super S>> extends ImplicationRelation {
    private final int skip_;
    private final int keep_;
    private final int r_skip_;
    private final int r_keep_;
    private int phase_;

    /**
     * Get subClock by filtering master according to the pattern:
     *    - skip "skip" ticks
     *    - keep the next "keep" ticks
     *    - then, repeatedly skip repSkip ticks and keep repKeep ticks
     *  For instance, FilteredBy(m, s, 5, 1, 3, 2) will skip the first
     *  5 ticks of "m", then keep its next tick for "s", then skip 3 ticks,
     *  keep 2 ticks, skip 3 ticks, keep 2 ticks and so on.
     * @param master
     * @param slave
     * @param skip
     * @param keep
     * @param repSkip
     * @param repKeep
     */
    public FilteredImplication(Clock<M> master, Clock<S> slave, int skip, int keep, int repSkip, int repKeep) {
        super(slave, master);
        this.skip_ = skip;
        this.keep_ = keep;
        this.r_skip_ = repSkip;
        this.r_keep_ = repKeep;
        this.phase_ = 0;
    }

    /**
     * Return the master clock for the FilteredBy constraint
     */
    @SuppressWarnings("unchecked")
    public Clock<M> getMasterClock() {
        return (Clock<M>) getMasterClocks()[0];
    }

    /**
     * Determine whether a tick should be set "now" on the subclock slave clock.
     * Return true if a new tick has been created.
     */
    @Override
    public boolean induceTicks() {
        if (getMasterClock().hasRealTickNow()) {
            this.phase_ ++;
            // We were applied in this instant
            appliedNow();
        } else {
            // No tick on master clock, so we didn't create any tick
            return false;
        }
        int phase = this.phase_ - 1;
        if (phase < this.skip_) {
            // We didn't create any tick
            return false;
        }
        phase -= this.skip_;
        if (phase < this.keep_) {
            return getSlaveClock().newNowTick();
        }
        phase -= this.keep_;
        if ((this.r_keep_ + this.r_skip_) == 0) {
            // No repeating pattern
            return false;
        }
        phase %= (this.r_skip_ + this.r_keep_);
        if (phase < this.r_skip_) {
            return false;
        }
        phase -= this.r_skip_;
        if (phase < this.r_keep_) {
            return getSlaveClock().newNowTick();
        }		
        return false;
    }


    @Override
    public String toString() {
        return "FilteredImplication: "+this.skip_+":"+this.keep_+"("+this.r_skip_+":"+this.r_keep_+") @" + this.phase_ + " " +super.toString();
    }

    private class FilteredImplicationBackup implements ImplicationBackupInterface {
        public int backup_phase_;

        @SuppressWarnings("synthetic-access")
        public FilteredImplicationBackup() {
            this.backup_phase_ = FilteredImplication.this.phase_;
        }

        @Override
        public void restore() {
            FilteredImplication.this.restore(this);
        }

    }
    @Override
    public ImplicationBackupInterface backup() {
        return new FilteredImplicationBackup();
    }

    @Override
    public void restore(ImplicationBackupInterface bck) {
        @SuppressWarnings("unchecked")
        FilteredImplicationBackup backup = (FilteredImplicationBackup)bck;
        this.phase_ = backup.backup_phase_;
    }
}
