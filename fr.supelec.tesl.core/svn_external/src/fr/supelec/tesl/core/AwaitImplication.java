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

import java.util.HashMap;
import java.util.Map;

/**
 * A clock relation which creates a tick on the slave clock
 * each time all the master clocks have ticked.
 * The registered occurrences are reset when the last awaited clock ticks or when the reset clock ticks.
 * The AwaitImplication is reset if it is weak when the reset clock ticks at the same time as the last awaited clock (strong reset).
 */
public class AwaitImplication<S extends Comparable<? super S>, R extends Comparable<? super R>> extends ImplicationRelation {
    private final Clock<R> resetClock_;
    private final boolean weak_;
    private boolean slave_ticked_;
    private Map<Clock<?>, Boolean> awaited_;
    /**
     * Constructor
     * @param slave clock of the implication
     * @param reset reset clock of the implication
     * @param weak if the await is weak, no tick is created when the reset clock ticks
     * @param awaited the list of awaited clocks
     */
    public AwaitImplication(Clock<S> slave, Clock<R> reset, boolean weak, Clock<?>... awaited) {
        super(true, slave, reset, awaited);
        this.resetClock_ = reset;
        if (reset == null) {
            // If no reset clock, we cannot be weak
            this.weak_ = false;
        } else {
            this.weak_ = weak;
        }
        this.awaited_ = new HashMap<Clock<?>, Boolean>();
        for (int i = 0; i < awaited.length; i++) {
            this.awaited_.put(awaited[i], false);
        }
    }

    /**
     * Return the when clock for the when implication
     */
    public Clock<R> getResetClock() {
        return this.resetClock_;
    }

    private void reset() {
        for (Clock<?> c : this.awaited_.keySet()) {
            this.awaited_.put(c, false);
        }
    }

    @Override
    public boolean induceTicks() {
        if (this.weak_ && this.resetClock_.hasRealTickNow()) {
            reset();
            appliedNow();
            return false;
        }
        boolean ok = true;
        for (Clock<?> c : this.awaited_.keySet()) {
            if (! this.awaited_.get(c)) {
                if (c.hasRealTickNow()) {
                    this.awaited_.put(c, true);
                } else {
                    ok = false;
                }
            }
        }
        if (ok) {
            reset();
            this.slave_ticked_ = true;
            appliedNow();
            return getSlaveClock().newNowTick();
        }
        if (this.resetClock_ != null && this.resetClock_.hasRealTickNow()) {
            reset();
            appliedNow();
            return false;
        }
        return false;
    }

    @Override
    public void startSolving() {
        super.startSolving();
        this.slave_ticked_ = false;
        // We can't have a dependency of our rest clock on our slave clock if the await is weak (strong preemption)
        if (this.weak_ && this.resetClock_ != null && getSolver().dependsOn(getResetClock(), getSlaveClock())) {
            throw new Error("# Unsupported dependency of reset clock on slave clock in weak await. " + this);
        }
    }

    @Override
    public void endSolving() {
        super.endSolving();
        if (this.weak_ && this.slave_ticked_ && this.resetClock_.hasRealTickNow()) {
            throw new Error("# Inconsistency: a tick was induced on the slave by a weak await when the reset clock has ticked. " + this);
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("AwaitImplication: ");
        if (this.weak_) {
            b.append("with strong reset on ");
            b.append(this.resetClock_.toString());
        } else if (this.resetClock_ != null) {
            b.append("with weak reset on ");
            b.append(this.resetClock_.toString());
        }
        b.append(" [");
        boolean first = true;
        for (Clock<?> c : this.awaited_.keySet()) {
            if (this.awaited_.get(c)) {
                if (first) {
                    first = false;
                } else {
                    b.append(", ");
                }
                b.append(c.getName());
            }
        }
        b.append("] ");
        b.append(super.toString());
        return b.toString();
    }

    private class ImplicationBackup implements ImplicationBackupInterface {
        public Map<Clock<?>, Boolean> awaited_backup;
        @SuppressWarnings("synthetic-access")
		public ImplicationBackup() {
            this.awaited_backup = new HashMap<Clock<?>, Boolean>(AwaitImplication.this.awaited_);
        }

        @Override
        public void restore() {
            AwaitImplication.this.restore(this);
        }
    }

    @Override
    public ImplicationBackupInterface backup() {
        return new ImplicationBackup();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void restore(ImplicationBackupInterface bck) {
        this.awaited_ = ((ImplicationBackup)bck).awaited_backup;
    }
}