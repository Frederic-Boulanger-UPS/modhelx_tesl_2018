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
 * An EventFeederClock is a driving clock that ticks when an external event 
 * should be fed to the simulation.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class EventFeederClock extends DrivingClock<Long> {	
    /**
     * Build a new EventFeederClock
     * @param name the name of the clock
     */
    public EventFeederClock(String name) {
        super(name, new LongCalc());
    }

    /** Called when the external event occurs.
     *  Sets the tag of tick to the current system time in milliseconds, and sets the tick to "now".
     */
    public void eventOccurred() {
        resetClock();
        newTick(System.currentTimeMillis()).setNow(true);
    }

    @Override
    public void foresee() {
        resetClock();
        newTick(System.currentTimeMillis());
    }

    @Override
    public void backToPresent() {
        // Nothing to do, backup restore will do the job
    }

    @Override
    public void activate() {
        // Nothing special to do
    }


    @Override
    public void cancel() {
        // Nothing to do: this clock does not wait for anything
    }

    @Override
    public void wrapup() {
        // Nothing special to do
    }
}
