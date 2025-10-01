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

import java.util.LinkedList;
import java.util.List;

public class ListAttribute<T> implements StateValue {
    // Permanent value of the map
    private List<T> value_;
    // Transient value of the map
    private List<T> trans_value_;

    public ListAttribute() {
        this(null);
    }

    public ListAttribute(List<T> initlist) {
        if (initlist != null) {
            this.value_ = new LinkedList<T>();
            this.value_.addAll(initlist);
        } else {
            this.value_ = new LinkedList<T>();
        }
        this.trans_value_ = new LinkedList<T>(this.value_);
    }

    @Override
    public void revert() {
        this.trans_value_.clear();
        this.trans_value_.addAll(this.value_);
    }

    @Override
    public void commit() {
        this.value_.clear();
        this.value_.addAll(this.trans_value_);
    }

    /** Get the length of this list. */
    public int size() {
        return this.trans_value_.size();
    }

    /** Get the value associated to a key. */
    public T get(int i) {
        return this.trans_value_.get(i);
    }

    /** Add a value to the transient list. */
    public void add(T value) {
        this.trans_value_.add(value);
    }

    /** Remove a value from the transient list. */
    public void remove(int i) {
        this.trans_value_.remove(i);
    }
}
