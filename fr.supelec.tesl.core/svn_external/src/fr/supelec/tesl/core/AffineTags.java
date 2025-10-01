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

/**
 * An AffineTags relation is a tag relation which specifies
 * that the tag of the "to" clock are an affine function
 * of the tags of the "from" clock: to = a * from + b
 */
public class AffineTags<T extends Comparable<? super T>> extends TagRelation<T,T> {
    private final T a_;
    private final T b_;

    public AffineTags(Clock<T> from, Clock<T> to, T a, T b) {
        super(from, to);
        this.a_ = a;
        this.b_ = b;
    }

    //@ Convert a tag of the "from" clock to a tag of the "to" clock 
    @Override
    public T directConversion(T tag) {
        T conv = fromClock().tagProduct(tag, this.a_);
        conv = fromClock().tagSum(conv, this.b_);
        return conv;
    }

    //@ Convert a tag of the "to" clock to a tag of the "from" clock 
    @Override
    public T reverseConversion(T tag) {
        T conv = toClock().tagDifference(tag, this.b_);
        conv = toClock().tagQuotient(conv, this.a_);
        return conv;
    }

    @Override
    public String toString() {
        return super.toString() + " x" + this.a_ + "+" + this.b_;
    }
}
