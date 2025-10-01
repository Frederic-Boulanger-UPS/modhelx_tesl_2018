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

package fr.supelec.modhelx.core.ecore;

import java.util.Collection;

/**
 * A named entity is an entity with a name and properties.
 * 
 * @author frederic.boulanger@supelec.fr
 * 
 */
public interface NamedEntity {
    /** Get the name of this entity. */
    public String getName();
    /** Set the name of this entity. */
    public void setName(String name);
    /** Get the properties of this entity. */
    public abstract Collection<String> getProperties();
}
