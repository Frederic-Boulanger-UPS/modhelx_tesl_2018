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
 * A TagCalculus&lt;T&gt; performs operations on clock tags of type T.
 * It is used to implement consistent calculus on tags in order to avoid 
 * discrepancies caused for instance by rounding errors when using doubles.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 * @param <T>
 */
public interface TagCalculus<T> {
    public T add(T a, T b);
    public T subtract(T a, T b);
    public T multiply(T a, T b);
    public T divide(T a, T b);
    public T power(T a, int n);
    public T root(T a, int n);
    public boolean isZero(T a);
    public boolean isOne(T a);
}
