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

import fr.supelec.modhelx.core.abstractsemantics.Model;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.Tag;
import fr.supelec.tesl.core.TagCalculus;

/** An implementation of the ManagedInterfaceBlock for timed IB. */
public abstract class TimedManagedInterfaceBlock<T extends Comparable<T>, I extends Comparable<I>> extends ManagedInterfaceBlock {
    /** The type of the time for the observation clock. */
    Class<T> clockType_;
    /** The observation clock of the block. */
    private Clock<T> my_clock_;
    /** Time of the next observation. */
    private Attribute<T> next_obs_time;

    /** The type of the time for the observation clock of the internal model. */
    Class<I> internalClockType_;
    /** The observation clock of the internal model. */
    private Clock<I> my_internal_clock_;
    /** Time of the next observation of the internal model. */
    private Attribute<I> next_internal_obs_time;

    /** Return the name of the Attribute that contains the next observation time. */
    public static String nextObsTimeAttribute() {
        return "next_obs_time";
    }
    /** Return the name of the Attribute that contains the next observation time of the internal model. */
    public static String nextInternalObsTimeAttribute() {
        return "next_internal_obs_time";
    }

    /** Create a TimedManagedInterfaceBlock with of clock of type T. */
    public TimedManagedInterfaceBlock(Class<T> clockType, TagCalculus<T> tcalc, Class<I> internalClockType, TagCalculus<I> itcalc, String name, Model<?> model, Object... properties) {
        super(name, model, properties);
        this.clockType_ = clockType;
        this.my_clock_ = Clock.createClock(clockType, name+" obsclock", tcalc);
        this.internalClockType_ = internalClockType;
        this.my_internal_clock_ = Clock.createClock(internalClockType, name+" internclock", itcalc);
    }

    /** Return the observation clock of the block. */
    public Clock<T> observationClock() {
        return this.my_clock_;
    }

    /** Return the observation clock of the block. */
    public Clock<I> internalObservationClock() {
        return this.my_internal_clock_;
    }

    /** Return the next observation date of the block. */
    public T getNextObservationTime() {
        return this.next_obs_time.getValue();
    }

    /** Return the next observation date of the block. */
    public I getNextInternalObservationTime() {
        return this.next_internal_obs_time.getValue();
    }

    /** Set the next observation date of the block. */
    public T setNextObservationTime(T date) {
        this.next_obs_time.setValue(date);
        return date;
    }

    /** Add a duration to the next observation date of the block. */
    public T advanceNextObservationTime(T duration) {
        return setNextObservationTime(
                this.my_clock_.tagSum(getNextObservationTime(), duration));
    }

    /** Add a duration to the next observation date of the block. */
    public T advanceNextObservationTime(Value<T> duration) {
        return setNextObservationTime(
                this.my_clock_.tagSum(getNextObservationTime(), duration.getValue()));
    }

    /** Set the next observation date of the block. */
    public I setNextInternalObservationTime(I date) {
        this.next_internal_obs_time.setValue(date);
        return date;
    }

    /** Add a duration to the next observation date of the block. */
    public I advanceNextInternalObservationTime(I duration) {
        return setNextInternalObservationTime(
                this.my_internal_clock_.tagSum(getNextInternalObservationTime(), duration));
    }

    /** Add a duration to the next observation date of the block. */
    public I advanceNextInternalObservationTime(Value<I> duration) {
        return setNextInternalObservationTime(
                this.my_internal_clock_.tagSum(getNextInternalObservationTime(), duration.getValue()));
    }

    @Override
    public void doPreSetup() {
        // Add the observation clock to the solver
        getSolver().addClock(this.my_clock_);
        // Create the attribute for storing the next observation time 
        this.next_obs_time = new Attribute<T>(this.clockType_, false);
        // Add the internal observation clock to the solver
        getSolver().addClock(this.my_internal_clock_);
        // Create the attribute for storing the next observation time of the internal model
        this.next_internal_obs_time = new Attribute<I>(this.internalClockType_, false);

        // My internal update clock implies the clock of my internal model 
        this.my_internal_clock_.implies(getInternalModel().getMoC().getClock());
        // Observing the internal model implies observing the block
        this.my_internal_clock_.implies(this.my_clock_);
        // Observing the interface block implies observing the embedding model
        this.my_clock_.implies(getMoC().getClock());
    }

    @Override
    public void doStartOfSnapshot() {
        // Nothing to do by default
    }

    @Override
    public void doReset() {
        // Nothing to do by default
    }

    @Override
    public boolean shouldUpdateModel() {
        // Update internal model when its observation clock has a tick
        return this.my_internal_clock_.hasTickNow();
    }

    @Override
    public final void emitObservationRequests() {
        T next_time = getNextObservationTime();
        I next_internal_time = getNextInternalObservationTime();
        // Emit an observation request on each clock if the corresponding next observation time is not null
        if (next_time != null) {
            this.my_clock_.newTick(next_time);
        }
        if (next_internal_time != null) {
            this.my_internal_clock_.newTick(next_internal_time);
        }
    }

    @Override
    public final boolean hasObservationRequest() {
        // Checking my_clock is enough since the internal observation clock implies my_clock
        return this.my_clock_.hasTickNow();
    }

    @Override
    public final Tag<T> getTimeOfRequest() {
        return this.my_clock_.getNowTick().getTag();
    }
}
