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
 * Copyright CentraleSupélec, Department of Computer Science, 2016
 * http://wdi.supelec.fr/software
 * 
 */

package fr.supelec.tesl.core;

/**
 * A SquareIntTags relation is a tag relation which specifies
 * that the tag of the "to" clock are the square
 * of the tags of the "from" clock: to = from * from + b
 */
public class PowerTags<T extends Comparable<? super T>> extends TagRelation<T,T> {
    private final int n_;
    private final T a_;
    private final T b_;

    public PowerTags(Clock<T> from, Clock<T> to, int n, T a, T b) {
        super(from, to);
        this.n_ = n;
        this.a_ = a;
        this.b_ = b;
    }

    //@ Convert a tag of the "from" clock to a tag of the "to" clock 
    @Override
    public T directConversion(T tag) {
    	T conv = this.fromClock().tagPower(tag, n_);
    	conv = this.fromClock().tagProduct(a_, conv);
    	conv = this.fromClock().tagDifference(conv, b_);
        return conv;
    }

    //@ Convert a tag of the "to" clock to a tag of the "from" clock 
    @Override
    public T reverseConversion(T tag) {
    	T conv = this.fromClock().tagDifference(tag, b_);
    	conv = this.fromClock().tagQuotient(conv, a_);
    	conv = this.fromClock().tagRoot(conv, n_);
        return conv;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.a_ + " * x^" + this.n_ + " + " + this.b_;
    }
}
