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

package fr.supelec.modhelx.core.abstractsemantics;

/**
 * A Token is a piece of information that can be put on a pin to be communicated between blocks.
 * A value is associated to a token by its model of computation.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class Token {
    /** The model of computation that knows the value of this token. */
    private ModelOfComputation<?> owner_;

    /** Build a new token, valid in a model of computation. */
    public Token(ModelOfComputation<?> owner) {
        this.owner_ = owner;
    }

    /** Get the model of computation in which this token is valid. */
    public ModelOfComputation<?> getOwner() {
        return this.owner_;
    }

    /** Get the value which is assoviated to this token. */
    public Object getValue() {
        return this.owner_.getTokenValue(this);
    }

    /** Set the value which is associated to this token. */
    public Token setValue(Object o) {
        this.owner_.setTokenValue(this, o);
        return this;
    }
}
