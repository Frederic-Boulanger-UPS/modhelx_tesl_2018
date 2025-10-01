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
 * A Relation is an oriented connection between two pins.
 *  
 * @author frederic.boulanger@supelec.fr
 *
 */
public class Relation extends NamedEntity implements fr.supelec.modhelx.core.ecore.Relation {
    /** The origin of the relation. */
    private Pin origin_;
    /** The target of the relation. */
    private Pin target_;

    /** Build a new relation named <code>name</code> between two pins. */
    public Relation(String name, Pin origin, Pin target) {
        super(name);
        this.origin_ = origin;
        this.target_ = target;
        origin.addOutgoing(this);
        target.addIncoming(this);
    }

    @Override
    public Pin getOrigin() {
        return this.origin_;
    }
    
    @Override
    public Pin getTarget() {
        return this.target_;
    }
}
