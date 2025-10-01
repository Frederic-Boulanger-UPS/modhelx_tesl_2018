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
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a Named entity for the abstract semantics of ModHel'X.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */

public abstract class NamedEntity implements fr.supelec.modhelx.core.ecore.NamedEntity {
    /** Name of the entity. */
    private String name_;
    /** Properties of the entity. */
    private Map<String, Object> properties_;

    public NamedEntity(String name, Object ... properties) {
        this.name_ = name;
        this.properties_ = new HashMap<String, Object>();
        setProperties(properties);
    }

    @Override
    public String getName() {
        return this.name_;
    }

    @Override
    public void setName(String name) {
        this.name_ = name;
    }

    @Override
    public Collection<String> getProperties() {
        return this.properties_.keySet();
    }

    /** Tell if the entity has property <code>name</code>. */
    public boolean hasProperty(String name) {
        return this.properties_.containsKey(name);
    }

    /** Get property <code>name</code> of the entity as a <code>Class@lt;T@gt;</code>. */
    public <T>  T getProperty(String name, Class<T> type) {
        Object propval = this.properties_.get(name);
        try {
            return type.cast(propval);
        } catch (ClassCastException cce) {
            System.err.println("## Could not cast " + propval + " into " + type);
            throw cce;
        }
    }

    /** Set property <code>name</code> of the entity to <code>value</code>. */
    public <T> void setProperty(String name, T value) {
        this.properties_.put(name, value);
    }

    /** Set properties of the entity using a <code>String</code>/<code>value</code> list. */
    public void setProperties(Object ... pairs) {
        if (pairs.length % 2 != 0) {
            throw new Error("## Invalid property setting list");
        }
        for (int i = 0; i < pairs.length; i++) {
            String propName;
            try {
                propName = (String)pairs[i];
            } catch (ClassCastException cce) {
                throw new Error("## First item of a property setting pair must be a string");
            }
            i++;
            setProperty(propName, pairs[i]);
        }
    }

    /** Remove property <code>name</code> of the entity. */
    public void removeProperty(String name) {
        this.properties_.remove(name);
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + " " + this.getName();
    }
}
