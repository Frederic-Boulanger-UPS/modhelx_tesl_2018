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

import fr.supelec.modhelx.core.abstractsemantics.NamedEntity;

/** A place for storing a value of type T. */
public abstract class Value<T> {
    /** The type of the stored value. */
    private Class<T> type_;
    /** The stored value. */
    private T value_;
    /** Give a warning is the Value is not initialized. */
    private boolean giveInitWarning_;

    /** Create a new storage of type <code>type</code>. */
    public Value(Class<T> type, boolean giveInitWarning) {
        this.type_ = type;
        this.value_ = null;
        this.giveInitWarning_ = giveInitWarning;
    }

    /** Create a new storage of type <code>type</code>. */
    public Value(Class<T> type) {
        this(type, true);
    }

    /** Get the type of this storage. */
    public Class<T> getType() {
        return this.type_;
    }

    /** Get the value stored in this storage. */
    public T getValue() {
        return this.value_;
    }

    /** Set the value stored in this storage. Protected because some storages may be read-only. */
    protected void setValue(T value) {
        this.value_ = value;
    }

    /** Set the value stored in this storage. Protected because some storages may be read-only. */
    protected void setValue(Value<T> value) {
        this.setValue(value.getValue());
    }

    /** Set the initial value of this storage. */
    public void init(T value) {
        if (this.value_== null) {
            this.value_ = value;
        } else {
            throw new Error("## Attempt to initialize already intialized storage");
        }
    }

    /** Set the initial value of this storage from a property of a NamedEntity. */
    public void initFromProperty(NamedEntity entity, String propName) {
        T val = entity.getProperty(propName, this.type_);
        if (val != null) {
            this.init(val);
        } else {
            if (this.giveInitWarning_ && (this.value_ == null)) {
                System.err.println("# Warning: could not find property \""
                        + propName 
                        + "\" in entity \""
                        + entity.getName()
                        + "\" to initialize a value.");
            }
        }
    }

}
