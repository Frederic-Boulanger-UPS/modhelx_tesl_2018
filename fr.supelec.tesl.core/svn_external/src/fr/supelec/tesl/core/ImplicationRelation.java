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

import java.util.Arrays;

/*@
 * A causal relation between a master clock and a slave clock
 */
public abstract class ImplicationRelation {
    private Clock<?> masters_[];
    private Clock<?> slave_;
    private ClockSet solver_;
    protected boolean applied_now_;

    public ImplicationRelation(Clock<?> slave, Clock<?>... masters) {
        this.masters_ = masters;
        this.slave_ = slave;
        this.applied_now_ = false;
    }

    //@ Build an implication relation with an extra master clock. The value of the "extra" boolean parameter is ignored.
    public ImplicationRelation(boolean extra, Clock<?> slave, Clock<?> master1, Clock<?>... masters) {
        if (master1 != null) {
            this.masters_ = Arrays.copyOf(masters, masters.length + 1);
            this.masters_[masters.length] = master1;
        } else {
            this.masters_ = masters;
        }
        this.slave_ = slave;
        this.applied_now_ = false;
    }

    //@ Is this implication instantaneous ?
    public boolean isInstantaneous() {
    	// Only deleyed and time delayed implication may not be instantaneous
    	return true;
    }
    
    //@ Set the solver of this relation
    public void setSolver(ClockSet cs) {
        this.solver_ = cs;
    }

    //@ Get the solver of this relation
    public ClockSet getSolver() {
        return this.solver_;
    }

    //@ Get the master clocks of the relation
    public Clock<?>[] getMasterClocks() {
        return this.masters_;
    }

    //@ Get the slave clock of the relation
    public Clock<?> getSlaveClock() {
        return this.slave_;
    }

    //@ Start a new solving phase
    public void startSolving() {
        this.applied_now_ = false;
    }

    //@ Signal the end of the solving phase
    public void endSolving() {
        // Override in order to check some condition at the end of the solving phase
    }

    //@ Apply this relation if it has not already been applied in the current phase
    //public final boolean apply() throws CustomException{
    public boolean apply() {
        if (this.applied_now_) {
            return false;
        }
        //		this.applied_now_ = induceTicks();
        return induceTicks();
    }

    //@ Mark this implication relation as applied at this instant
    protected void appliedNow() {
        this.applied_now_ = true;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.slave_.toString());

        buf.append(" <= ");
        for (Clock<?> clk : this.masters_) {
            buf.append(clk != null ? clk.toString()+" " : "null ");
        }

        return buf.toString();
    }

    //@ Create the ticks induced by this relation
    protected abstract boolean induceTicks();

    public abstract ImplicationBackupInterface backup();

    public abstract void restore(ImplicationBackupInterface bck);
}
