/*
 * This file is part of TESL.
 *
 * TESL is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * TESL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with TESL. If not, see <http://opensource.org/licenses/EPL-1.0>.
 * 
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 * 
 */

package fr.supelec.tesl.core;

import java.util.HashMap;

/*@
 * A tick on a clock, with tags of type T.
 */
public class Tick<T extends Comparable<? super T>> implements Comparable<Tick<T>> {
    //@ The clock of this tick
    private Clock<T> myclock_;
    //@ Storage for user data
    private HashMap<Object, Object> user_data_;

    public Tick(Clock<T> clock) {
        this.myclock_ = clock;
        this.user_data_ = new HashMap<Object, Object>();
    }

    public Tick(Clock<T> clock, Tag<T> tag) {
        this(clock);
        // Avoid ticks with a non null tag which has a null value => make the tag null
        if ((tag != null) && (tag.getValue() == null)) {
            setTag(null);
        } else {
            setTag(tag);
        }
    }

    public Tick(Clock<T> clock, T tag) {
        this(clock, new Tag<T>(tag));
    }

    //@ Attach data associated to owner to this tick
    public void setUserData(Object owner, Object data) {
        this.user_data_.put(owner, data);
    }

    //@ Get the data associated to owner on this tick
    public Object getUserData(Object owner) {
        return this.user_data_.get(owner);
    }

    //@ Clear the data associated to woner on this tick
    public Object clearUserData(Object owner) {
        return this.user_data_.remove(owner);
    }

    //@ Get the number of data on this tick
    public int userDataSize() {
        return this.user_data_.size();
    }

    //@ Tell  this tick is a ghost (virtual tick)
    public boolean isGhost() {
        return this.myclock_.getSolver().isGhost(this);
    }

    /*@ Merge the data associated to owners on tick and this tick.
     *  If a given owner has data on both ticks, only the data on tick is kept.
     */
    public void mergeUserData(Tick<?> tick) {
        this.user_data_.putAll(tick.user_data_);
    }

    //@ Remove this tick from its clock
    public void remove() {
        this.myclock_.removeTick(this);
    }

    /*@ Set the tag of this tick. */
    public Tick<T> setTag(Tag<T> tag) {
        this.myclock_.setTag(this, tag);
        return this;
    }

    /*@ Set the tag of this tick. */
    public Tick<T> setTagValue(T tag) {
        this.myclock_.setTagValue(this, tag);
        return this;
    }

    //@ Get the tag of this tick
    public Tag<T> getTag() {
        return this.myclock_.getTag(this);
    }

    //@ Get the tag of this tick
    public T getTagValue() {
        return this.myclock_.getTagValue(this);
    }

    //@ Is this tick "now" or in the future
    public boolean isNow() {
        return this.myclock_.isNow(this);
    }

    //@ Set this tick to "now" or in the future
    public Tick<T> setNow(boolean now) {
        this.myclock_.setNow(this, now);
        return this;
    }

    @Override
    public String toString() {
        boolean isGhost = isGhost();
        StringBuffer buf = new StringBuffer();
        if (isGhost) {
            buf.append("{");
        } else {
            buf.append("(");
        }
        Tag<T> tag = getTag();
        if (tag != null) {
            buf.append(tag.toString());
        }
        if (this.isNow()) {
            buf.append(", now");
        }
        if (isGhost) {
            buf.append("}");
        } else {
            buf.append(")");
        }
        return buf.toString();
    }

    @Override
    // A tick is less than another if it has a null tag or if it has a lesser tag than the other
    public int compareTo(Tick<T> o) {
        Tag<T> my_tag = getTag();
        Tag<T> other_tag = o.getTag();
        if (my_tag == null) {
            if (other_tag == null) {
                return 0;
            } else {
                return -1;
            }
        } else if (other_tag == null) {
            return 1;
        } else {
            return getTag().compareTo(o.getTag());
        }
    }
}
