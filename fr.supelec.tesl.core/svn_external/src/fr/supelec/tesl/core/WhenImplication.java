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
public class WhenImplication<M extends Comparable<? super M>,
                             W extends Comparable<? super W>,
                             S extends Comparable<? super S>> extends ImplicationRelation {
    /**
     * Constructor
     * @param master (sub clock)
     * @param slave
     */
    public WhenImplication(Clock<M> master, Clock<W> when, Clock<S> slave) {
        super(slave, master, when);
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
    public boolean induceTicks() {
        if (getMasterClock().hasRealTickNow() && getWhenClock().hasRealTickNow()) { // if both clocks have a 'now' tick
            appliedNow();
            if(getSlaveClock().hasTickNow()) { // if the slave clock has already a 'now' tick, do nothing
                return false;
            } else { // Put a now tick on the slave
                return getSlaveClock().newNowTick();
            }					
        }
        return false;
    }

    @Override
    public String toString() {
        return "WhenImplication: "+super.toString();
    }

    private class ImplicationBackup implements ImplicationBackupInterface {
        public ImplicationBackup() {
        }

        @Override
        public void restore() {
            // Implications are stateless
        }
    }

    @Override
    public ImplicationBackupInterface backup() {
        return new ImplicationBackup();
    }


    @Override
    public void restore(ImplicationBackupInterface bck) {
        // WhenImplications are stateless		
    }
}