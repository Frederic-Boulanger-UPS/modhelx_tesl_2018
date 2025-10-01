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

/** A TransientValue is an Attribute that never changes its permanent value.
 */
public class TransientValue<T> extends Attribute<T> {
    /** Create a TransientValue for storing a value of type <code>type</code>. */
    public TransientValue(Class<T> type) {
        super(type, false);
    }

    /** Commit the transient value into the permanent value. */
    @Override
    public void commit() {
        // Do nothing, this is a transient value!
    }
}
