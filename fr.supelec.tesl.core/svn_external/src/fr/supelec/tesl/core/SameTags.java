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
 * A SameTags relation is a tag relation which specifies
 * that the tag of the "to" and "from" clocks are the same
 */
public class SameTags<T extends Comparable<? super T>> extends TagRelation<T,T> {
    public SameTags(Clock<T> from, Clock<T> to) {
        super(from, to);
    }
    @Override
    public T directConversion(T tag) {
        return tag;
    }

    @Override
    public T reverseConversion(T tag) {
        return tag;
    }
}