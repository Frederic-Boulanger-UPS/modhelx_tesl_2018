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

package fr.supelec.modhelx.core.abstractsemantics;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of an observable entity for the abstract semantics of ModHel'X.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public abstract class ObservableEntity extends NamedEntity implements fr.supelec.modhelx.core.ecore.ObservableEntity {
    /** Association between names and pins for this entity. */
    private Map<String, Pin> pins_;
    /** The input pins. */
    private Set<Pin> inputpins_ = new HashSet<Pin>();
    /** The output pins. */
    private Set<Pin> outputpins_ = new HashSet<Pin>();


    public ObservableEntity(String name) {
        super(name);
        this.pins_ = new HashMap<String, Pin>();
    }

    public ObservableEntity(String name, Object ... properties) {
        super(name, properties);
        this.pins_ = new HashMap<String, Pin>();
    }

    /** Return the model of computation in which this entity is observed. */
    //	public abstract <T extends Comparable<? super T>> ModelOfComputation<T> getMoC();
    public abstract ModelOfComputation<?> getMoC();

    /** Return the interface of this observable.
     *  The collection of pins is read-only: pins must only be added through
     *  addPin(). This allows the observable entity to enforce the consistency
     *  of its data structures at all times. */
    @Override
    public Collection<Pin> getInterface() {
        return Collections.unmodifiableCollection(this.pins_.values());
    }

    /** Add a pin to this entity. */
    public Pin addPin(Pin pin) {
        this.pins_.put(pin.getName(), pin);
        pin.setOwner(this);
        if(pin.isInputPin()) this.inputpins_.add(pin);
        if(pin.isOutputPin()) this.outputpins_.add(pin);
        return pin;
    }
    
    /** Get the pin named <code>name</code> of this entity. */
    public Pin getPin(String name) {
        return this.pins_.get(name);
    }

    /** Connect one of my pins to another pin. */
    public abstract Relation connect(Pin mine, Pin other);
    /** Connect pin <code>other</code> of Model <code>model</code> to my pin <code>mine</code>.*/
    public abstract Relation connectFromModel(Model<?> model, Pin other, Pin mine);
    /** Connect pin <code>other</code> of regular Block <code>block</code> to my pin <code>mine</code>.*/
    public abstract Relation connectFromRegularBlock(Block block, Pin other, Pin mine);
    /** Connect pin <code>other</code> of InterfaceBlock <code>intfBlock</code> to my pin <code>mine</code>.*/
    public abstract Relation connectFromInterfaceBlock(InterfaceBlock intfBlock, Pin other, Pin mine);

    /** Get the input pins of this entity.
     *  The collection of pins is read-only: pins must only be added through
     *  addPin(). This allows the observable entity to enforce the consistency
     *  of its data structures at all times. */
    public Collection<Pin> getInputPins() {
    	return Collections.unmodifiableCollection(this.inputpins_);
    }

    /** Get the output pins of this entity.
     *  The collection of pins is read-only: pins must only be added through
     *  addPin(). This allows the observable entity to enforce the consistency
     *  of its data structures at all times. */
    public Collection<Pin> getOutputPins() {
    	return Collections.unmodifiableCollection(this.outputpins_);
    }

    /** Initialize the entity. Called after loading the model, before the simulation starts. */
    public abstract void prep();
    /** Perform sanity check before setup. */
    public abstract void sanityCheck();
    /** Prepare for the simulation. Called after prep, before the first step of the simulation. */
    public abstract void setup();
    /** Start a new snapshot (observation round). */
    public abstract void startOfSnapshot();
    /** Reset the computation of the outputs and next state for the current snapshot. */
    public abstract void reset();
    /** Start a partial update (get partial inputs from the outer model). */
    public abstract void startOfUpdate();
    /** Update the interface of the observable: take inputs into account, update outputs. */
    public abstract void update();
    /** End of a partial update (produce partial outputs to the outer model). */
    public abstract void endOfUpdate();
    /** Validate the computation of the observation. Answer true if the observable agrees with the observed values. */
    public abstract boolean validate();
    /** End of the observation round, the observable can update its internal state. */
    public abstract void endOfSnapshot();
    /** Emit observation request for future snapshots by creating ticks on clocks. */
    public abstract void emitObservationRequests();
    /** Cleanup at the end of the simulation. */
    public abstract void wrapup();
}
