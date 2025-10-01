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


/*@
 * A relation between the tags of coinciding ticks of two clocks.
 */
public abstract class TagRelation<U extends Comparable<? super U>, V extends Comparable<? super V>> {
    private ClockSet solver_;
    private Clock<U> from_;
    private Clock<V> to_;

    public TagRelation(Clock<U> from, Clock<V> to) {
        this.from_ = from;
        this.to_ = to;
    }

    //@ Set the solver of this relation
    public void setSolver(ClockSet cs) {
        this.solver_ = cs;
    }

    //@ Get the solver of this relation
    public ClockSet getSolver() {
        return this.solver_;
    }

    //@ Yield the "from" clock
    public Clock<U> fromClock() {
        return this.from_;
    }

    //@ Yield the "to" clock
    public Clock<V> toClock() {
        return this.to_;
    }

    //@ Convert a tag of the "from" clock into a tag of the "to" clock
    public abstract V directConversion(U tag);

    //@ Convert a tag of the "to" clock into a tag of the "from" clock
    public abstract U reverseConversion(V tag);

    @Override
    public String toString() {
        return "TagRelation from " + this.from_.getName() + " to " + this.to_.getName();
    }
}
