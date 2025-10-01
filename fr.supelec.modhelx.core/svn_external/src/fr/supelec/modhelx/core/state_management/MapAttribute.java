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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/** A state value which stores data in a Map. */
public class MapAttribute<K, V> implements StateValue {
    // Permanent value of the map
    private Map<K,V> value_;
    // Transient value of the map
    private Map<K,V> trans_value_;

    public MapAttribute() {
        this(null);
    }

    public MapAttribute(Map<K,V> initmap) {
        this.value_ = new HashMap<K,V>();
        if (initmap != null) {
            this.value_.putAll(initmap);
        }
        this.trans_value_ = new HashMap<K,V>();
    }

    @Override
    public void revert() {
        this.trans_value_.clear();
    }

    @Override
    public void commit() {
        this.value_.putAll(this.trans_value_);
        this.trans_value_.clear();
    }

    /** Get the value associated to a key. */
    public V get(K key) {
        V result = this.trans_value_.get(key);
        if (result == null) {
            result = this.value_.get(key);
        }
        return result;
    }

    /** Set the transient value associated to a key. */
    public V put(K key, V value) {
        return this.trans_value_.put(key, value);
    }

    /** Return the set of keys of this map. */
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<K>(this.trans_value_.keySet());
        keys.addAll(this.value_.keySet());
        return keys;
    }

    /** Return a collection of the values in this map. */
    public Collection<V> values() {
        // Get values from transient map
        LinkedList<V> values = new LinkedList<V>(this.trans_value_.values());
        // Add values from permanent map for keys that are not in the transient map
        for (K key : this.value_.keySet()) {
            if (!this.trans_value_.containsKey(key)) {
                values.add(this.value_.get(key));
            }
        }
        return values;
    }
}
