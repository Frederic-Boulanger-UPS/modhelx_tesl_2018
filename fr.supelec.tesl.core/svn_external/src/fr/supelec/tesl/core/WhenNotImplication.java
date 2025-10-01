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
 * A clock relation which creates a tick on the slave (super) clock 
 * each time there is a tick on the master (sub) clock.
 * (master is a SubClock of the slave)
 */
public class WhenNotImplication<M extends Comparable<? super M>,
                                W extends Comparable<? super W>,
                                S extends Comparable<? super S>> extends ImplicationRelation {
    private boolean tick_created_;
    /**
     * Constructor
     * @param master (sub clock)
     * @param slave
     */
    public WhenNotImplication(Clock<M> master, Clock<W> when, Clock<S> slave) {
        super(slave, master, when);
        this.tick_created_ = false;
    }

    /**
     * Return the master clock for the when implication
     */
    @SuppressWarnings("unchecked")
    public Clock<M> getMasterClock() {
        return (Clock<M>) getMasterClocks()[0];
    }

    /**
     * Return the when clock for the when implication
     */
    @SuppressWarnings("unchecked")
    public Clock<W> getWhenClock() {
        return (Clock<W>) getMasterClocks()[1];
    }

    @Override
    public void startSolving() {
        super.startSolving();
        this.tick_created_ = false;
//        if (getSolver().dependsOn(getWhenClock(), getSlaveClock())) {
//            throw new Error("# Unsupported dependency of when clock on slave clock in WhenNot implication. " + this);
//        }
        if (getSolver().dependsInstantaneouslyOn(getWhenClock(), getSlaveClock())) {
            throw new Error("# Unsupported instantaneous dependency of when clock on slave clock in WhenNot implication. " + this);
        }
    }

    @Override
    public void endSolving() {
        super.endSolving();
        if (getMasterClock().hasRealTickNow() && getWhenClock().hasRealTickNow() && this.tick_created_) {
            throw new Error("# Inconsistency: when clock has tick now and I created a tick on slave. " + this);
        }
    }

    @Override
    public boolean induceTicks() {
        if (getMasterClock().hasRealTickNow()) { // If the master clock has a tick now
            if (getWhenClock().hasRealTickNow()) { // If the when clock has a tick now, we are done
                appliedNow();
                if (this.tick_created_) { // Check that we didn't create a tick on the slave before knowing that the when clock had a ticks
                    // Oops! This is a "when not" implication, we already created a tick on the slave clock
                    // and we discover now that the when clock ticks => there is some dependency hidden in the tag relations
                    throw new Error("# When not implication aborted after having implied a tick => dependency through tag relations? " + this);
                }
                return false;
            } else { // No tick now on when clock => induce a tick on slave
                this.tick_created_ = true;
                return getSlaveClock().newNowTick();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "WhenNotImplication: "+super.toString();
    }

    private class ImplicationBackup implements ImplicationBackupInterface {
        public ImplicationBackup() {
        }

        @Override
        public void restore() {
            // WhenNotImplications are stateless
        }
    }

    @Override
    public ImplicationBackupInterface backup() {
        return new ImplicationBackup();
    }


    @Override
    public void restore(ImplicationBackupInterface bck) {
        // WhenNotImplications are stateless		
    }
}