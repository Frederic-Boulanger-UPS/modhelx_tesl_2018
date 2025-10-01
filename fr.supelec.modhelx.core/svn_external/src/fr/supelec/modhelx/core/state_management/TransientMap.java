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

import java.util.Map;

/** A TransientMap is a MapAttribute that never changes its permanent value.
 */
public class TransientMap<K,V> extends MapAttribute<K,V> {
    /** Create a TransientMap initialized with <code>map</code>. */
    public TransientMap(Map<K,V> map) {
        super(map);
    }

    /** Create an empty TransientMap. */
    public TransientMap() {
        this(null);
    }

    /** Commit the transient value into the permanent value. */
    @Override
    public void commit() {
        // Do nothing, this is a transient value!
    }
}
