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

package fr.supelec.modhelx.core.state_management;

import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.Tag;
import fr.supelec.tesl.core.TagCalculus;

/** A ManagedBlock with timed behavior. */
public abstract class TimedManagedBlock<T extends Comparable<? super T>> extends ManagedBlock {
    /** The type of the time for the observation clock. */
    Class<T> clockType_;
    /** The observation clock of the block. */
    private Clock<T> my_clock_;
    /** Time of the next observation. */
    private Attribute<T> next_obs_time;

    public static String nextObsTimeAttribute() {
        return "next_obs_time";
    }

    public TimedManagedBlock(Class<T> clockType, TagCalculus<T> tcalc, String name, Object... properties) {
        super(name, properties);
        this.clockType_ = clockType;
        this.my_clock_ = Clock.createClock(clockType, name+" obsclock", tcalc);
    }

    /** Return the observation clock of the block. */
    public Clock<T> observationClock() {
        return this.my_clock_;
    }

    /** Return the next observation date of the block. */
    public T getNextObservationTime() {
        return this.next_obs_time.getValue();
    }

    /** Set the next observation date of the block. */
    public T setNextObservationTime(T date) {
        this.next_obs_time.setValue(date);
        return date;
    }

    /** Initialize the next observation date of the block (during setup). */
    public T initNextObservationTime(T date) {
        this.next_obs_time.init(date);
        return date;
    }

    @Override
    public void doStartOfSnapshot() {
        // Nothing to do in the default implementation
    }

    @Override
    public void doReset() {
        // Nothing to do in the default implementation
    }

    @Override
    public void doPreSetup() {
        // Create the observation clock
        getSolver().addClock(this.my_clock_);
        this.my_clock_.implies(getMoC().getClock());
        this.next_obs_time = new Attribute<T>(this.clockType_, false);
    }

    @Override
    public final void emitObservationRequests() {
        T next_time = getNextObservationTime();
        if (next_time != null) {
            this.my_clock_.newTick(next_time);
        }
    }

    @Override
    public final boolean hasObservationRequest() {
        return this.my_clock_.hasTickNow();
    }

    @Override
    public final Tag<T> getTimeOfRequest() {
        return this.my_clock_.getNowTick().getTag();
    }

    public T tagSum(T a, T b) {
        return this.my_clock_.tagSum(a, b);
    }

    public T tagDifference(T a, T b) {
        return this.my_clock_.tagDifference(a, b);
    }

    public T tagProduct(T a, T b) {
        return this.my_clock_.tagProduct(a, b);
    }

    public T tagQuotient(T a, T b) {
        return this.my_clock_.tagQuotient(a, b);
    }

}
