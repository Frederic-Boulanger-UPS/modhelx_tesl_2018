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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fr.supelec.modhelx.core.abstractsemantics.Engine;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.TagCalculus;
import fr.supelec.tesl.core.Tick;

/**
 * A DrivingClock is a clock used for driving a simulation.
 * Its ticks are created in response to external events.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 * @param <T> The type of the tags for this clock
 */
public abstract class DrivingClock<T extends Comparable<T>> extends Clock<T> {
    /** List of all driving clocks. */
    private static List<DrivingClock<?>> drivingclocks_ = new LinkedList<DrivingClock<?>>();

    /** The execution engine which is waiting on this clock. */
    protected Engine listener_;

    /** Build a new driving clock with name <code>name</code>. */
    public DrivingClock(String name, TagCalculus<T> tcalc) {
        super(name, tcalc, false);  // A driving clock should not be greedy: a tick must be present only when the driving event really occurs
        this.listener_ = null;
        drivingclocks_.add(this);
    }

    /** Set the execution engine which is driven by this clock. */
    public void setListener(Engine e) {
        this.listener_ = e;
    }

    /** Override newTick in order to notify the listener. */
    @Override
    public Tick<T> newTick(T value) {
        Tick<T> tick = super.newTick(value);
        // Tell the engine something happened
        if (this.listener_ != null) {
            synchronized(this.listener_) {
                this.listener_.notify();
            }
        }
        return tick;
    }

    /** Make the clock foresee the future: produce a tick if it will possibly tick in the future. */
    public abstract void foresee();

    /** Stop foreseeing, keep only really produced ticks. */
    public abstract void backToPresent();

    /** Activate the clock: make it ready to produce a tick and notify the engine. */
    public abstract void activate();

    /** Cancel the clock: stop waiting for the driving event. */
    public abstract void cancel();

    /** Release the resources used by the clock, called at the end of the simulation. */
    public abstract void wrapup();

    /** Return the whole collection of driving clocks. */
    public static Collection<DrivingClock<?>> getDrivingClocks() {
        return drivingclocks_;
    }
}
