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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import fr.supelec.modhelx.core.abstractsemantics.InterfaceBlock;
import fr.supelec.modhelx.core.abstractsemantics.Model;

/**
 * An InterfaceBlock with default management for state changes.
 */
public abstract class ManagedInterfaceBlock extends InterfaceBlock {
    /** Transient value telling whether the block was updated during this snapshot. */
    private TransientValue<Boolean> was_updated_;
    /** Transient value telling whether the internal model was updated during this snapshot. */
    private TransientValue<Boolean> internal_was_updated_;
    /** The state of the block, managing the revert and commit operations on its state values. */
    private State myState_;

    public ManagedInterfaceBlock(String name, Model<?> model, Object ... properties) {
        super(name, model, properties);
        checkNotManagedFields();
    }

    /** Check for fields that are not final and are not manageable by a State object. */ 
    private boolean checkNotManagedFields() {
        Class<?> myClass = this.getClass();
        boolean not_managed_fields = false;
        for (Field field : myClass.getDeclaredFields()) {
            if (StateValue.class.isAssignableFrom(field.getType())) {
                // OK, this is a state value
            } else if (Parameter.class.isAssignableFrom(field.getType())){
                // OK, this is a parameter
            } else if ((field.getModifiers() & Modifier.FINAL) != 0) {
                // OK, raw field, but final, so cannot be modified
            } else {
                // This field may be modified out of state control!
                System.err.println("## Warning: field \"" + field.getName()
                        + "\" of managed block " + myClass.getName()
                        + " \"" + this.getName() + "\" is not managed");
                not_managed_fields = true;
            }
        }
        return not_managed_fields;
    }

    /** Tell whether the block was updated during this snapshot. */
    public boolean wasUpdated() {
        return this.was_updated_.getValue();
    }

    /** Tell whether the internal model was updated during this snapshot. */
    public boolean internalWasUpdated() {
        return this.internal_was_updated_.getValue();
    }

    /** Initialize the state values and parameters of the block from its properties. */
    public void initFromProperties(String ... assignments) {
        this.myState_.initFromProperties(assignments);
    }

    /** The start of snapshot behavior of the block. */
    public abstract void doStartOfSnapshot();

    /** Some pre-setup behavior necessary for subclasses. */
    public abstract void doPreSetup();

    /** The setup behavior of the block. */
    public abstract void doSetup();

    @Override
    public final void startOfSnapshot() {
        this.myState_.revertSnap();
        super.startOfSnapshot();
        doStartOfSnapshot();
    }

    /** The setup behavior of the ManagedInterfaceBlock, which manages the state values and calls doSetup(). */
    @Override
    public final void setup() {
        getInternalModel().setup();
        doPreSetup();
        this.was_updated_ = new TransientValue<Boolean>(Boolean.class);
        this.was_updated_.init(false);
        this.internal_was_updated_ = new TransientValue<Boolean>(Boolean.class);
        this.internal_was_updated_ .init(false);
        this.myState_ = new State(this);
        doSetup();
        emitObservationRequests();
    }

    /** The reset behavior of the interface block. */
    public abstract void doReset();

    /** The reset behavior of the ManagedInterfaceBlock, which manages the state values and calls doReset(). */
    @Override
    public final void reset() {
        this.getInternalModel().reset();
        this.myState_.revert();
        this.doReset();
    }

    @Override
    public void startOfUpdate() {
        this.getInternalModel().getMoC().startOfUpdate(this.getInternalModel().getStructure());
    }

    @Override
    public void endOfUpdate() {
        this.getInternalModel().getMoC().endOfUpdate(this.getInternalModel().getStructure());
    }

    /** The update behavior of the interface block before updating the internal model. */
    public abstract void doPreUpdate();

    /** Should the internal model be updated. */
    public abstract boolean shouldUpdateModel();

    /** The update behavior of the interface block after updating the internal model. */
    public abstract void doPostUpdate();

    /** The update behavior of the interface block when the internal model is not updated. */
    public abstract void doGhostUpdate();

    /** The update behavior of the ManagedInterfaceBlock, which calls doPreUpdate(), doPostUpdate() and manages the state values. */
    @Override
    public final void update() {
        adaptIn();
        if (shouldUpdateModel()) {
            doPreUpdate();
            this.getInternalModel().startOfUpdate();
            this.getInternalModel().update();
            this.getInternalModel().endOfUpdate();
            doPostUpdate();
            this.internal_was_updated_.setValue(true);
        } else {
            doGhostUpdate();
        }
        adaptOut();
        this.was_updated_.setValue(true);
    }

    /** The endOfSnapshot behavior of the interface block. */
    public abstract void doEndOfSnapshot();

    /** The endOfSnapshot behavior of the ManagedInterfaceBlock, which calls doEndOfSnapshot() and manages the state values. */
    @Override
    public final void endOfSnapshot() {
        super.endOfSnapshot();
        this.doEndOfSnapshot();
        this.myState_.commit();
    }
}
