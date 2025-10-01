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
public class Implication<M extends Comparable<? super M>,
                         S extends Comparable<? super S>> extends ImplicationRelation {	
    /**
     * Constructor
     * @param master (sub clock)
     * @param slave
     */
    public Implication(Clock<M> master, Clock<S> slave) {
        super(slave, master);
    }


    /**
     * Return the master clock for the subClock constraint
     */
    @SuppressWarnings("unchecked")
    public Clock<M> getMasterClock() {
        return (Clock<M>) getMasterClocks()[0];
    }

    @Override
    public boolean induceTicks() {
        // Beware: master clock is the sub-clock!
        // When there is a tick on the sub-clock, there must be a tick on the super-clock
        if (getMasterClock().hasRealTickNow()) { // if the master clock has a 'now' tick
            // We are applied
            appliedNow();
            return getSlaveClock().newNowTick();
        } 		
        return false;
    }

    @Override
    public String toString() {
        return "Implication: "+super.toString();
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
        // Implications are stateless		
    }
}