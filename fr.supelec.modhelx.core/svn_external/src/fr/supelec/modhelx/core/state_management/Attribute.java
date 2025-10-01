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

/** An Attribute is a storage with commit and revert operations.
 *  An attribute has a permanent value, which is set at initialization time,
 *  and by the <code>commit</code> operation. It also has a transient value, 
 *  which is set by the <code>setValue</code> operation. The transient value
 *  becomes the permanent value when <code>commit</code> is called.
 *  The transient value if forgotten when <code>revert</code> is called.
 *  The current value of an attribute is its transient value if it is set,
 *  or its permanent value otherwise. 
 */
public class Attribute<T> extends Value<T> implements StateValue {
    /** The transient value of the attribute, which will become its value after committing. */
    private T trans_value_;
    private boolean was_set_;

    /** Create an attribute for storing a value of type <code>type</code>. */
    public Attribute(Class<T> type, boolean giveInitWarning) {
        super(type, giveInitWarning);
        this.trans_value_ = null;
        this.was_set_ = false;
    }

    /** Create an attribute for storing a value of type <code>type</code>. */
    public Attribute(Class<T> type) {
        this(type, true);
    }

    /** Get the value of the attribute.
     *  This is the transient value if <code>setValue</code> was called since the last call of <code>commit</code>,
     *  or the last committed (or initialized) value.
     */
    @Override
    public T getValue() {
        if (this.was_set_) {
            return this.trans_value_;
        } else {
            return super.getValue();
        }
    }

    /** Set the transient value of the attribute. */
    @Override
    public void setValue(T val) {
        this.trans_value_ = val;
        this.was_set_ = true;
    }

    /** Set the transient value of the attribute. */
    @Override
    public void setValue(Value<T> val) {
        super.setValue(val);
    }

    /** Commit the transient value into the permanent value. */
    @Override
    public void commit() {
        if (this.was_set_) {
            super.setValue(this.trans_value_);
            this.was_set_ = false;
        }
    }

    /** Revert to the last committed value by forgetting the transient value. */
    @Override
    public void revert() {
        this.was_set_ = false;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("Attribute<"+getType()+"> = ");
        T perm_value = super.getValue();
        if (perm_value == null) {
            buf.append("_null_");
        } else {
            buf.append(perm_value);
        }
        buf.append(" (");
        if (this.trans_value_ == null) {
            buf.append("_null_");
        } else {
            buf.append(this.trans_value_);
        }
        buf.append(")");
        return buf.toString();
    }
}
