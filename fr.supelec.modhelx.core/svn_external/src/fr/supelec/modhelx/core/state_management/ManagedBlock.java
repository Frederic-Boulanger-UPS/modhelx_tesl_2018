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

import fr.supelec.modhelx.core.abstractsemantics.Block;

/** A Block with default management for state changes. */
public abstract class ManagedBlock extends Block {
    /** Transient value telling whether the block was updated during this snapshot. */
    private TransientValue<Boolean> was_updated_;
    /** The state of the block, managing the revert and commit operations on its state values. */
    private State myState_;

    public ManagedBlock(String name, Object... properties) {
        super(name, properties);
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
            } else if (field.getAnnotation(NotManagedAttribute.class) != null) {
                // OK, raw field, but but with an annotation saying it is not managed
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

    /** Initialize the state values and parameters of the block from its properties. */
    public void initFromProperties(String ... assignments) {
        this.myState_.initFromProperties(assignments);
    }

    @Override
    public void prep() {
        // Default implementation does nothing
    }

    /** The start of snapshot behavior of the block. */
    public abstract void doStartOfSnapshot();

    /** Some pre-setup behavior necessary for subclasses. */
    public abstract void doPreSetup();

    /** The setup behavior of the block. */
    public abstract void doSetup();

    /** The setup behavior of the ManagedBlock, which manages the state values and calls doSetup(). */
    @Override
    public final void setup() {
        doPreSetup();
        this.was_updated_ = new TransientValue<Boolean>(Boolean.class);
        this.was_updated_.init(false);
        this.myState_ = new State(this);
        doSetup();
        emitObservationRequests();
    }

    @Override
    public void startOfSnapshot() {
        this.myState_.revertSnap();
        doStartOfSnapshot();
    }

    /** The reset behavior of the block. */
    public abstract void doReset();

    /** The reset behavior of the ManagedBlock, which manages the state values and calls doReset(). */
    @Override
    public final void reset() {
        this.myState_.revert();
        this.doReset();
    }

    @Override
    public void startOfUpdate() {
        // Default implementation does nothing
    }

    /** The update behavior of the block. */
    public abstract void doUpdate();

    /** The update behavior of the ManagedBlock, which calls doUpdate() and manages the state values. */
    @Override
    public final void update() {
        this.doUpdate();
        this.was_updated_.setValue(true);
    }

    @Override
    public void endOfUpdate() {
        // Default implementation does nothing
    }

    @Override
    public boolean validate() {
        // Default implementation accepts all snapshots
        return true;
    }

    /** The endOfSnapshot behavior of the block. */
    public abstract void doEndOfSnapshot();

    /** The endOfSnapshot behavior of the ManagedBlock, which calls doEndOfSnapshot() and manages the state values. */
    @Override
    public final void endOfSnapshot() {
        this.doEndOfSnapshot();
        this.myState_.commit();
    }

    @Override
    public void emitObservationRequests() {
        // Default implementation does nothing
    }

    @Override
    public void wrapup() {
        // Default implementation does nothing
    }
}
