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

/** 
 * A Model defines a behavior by interpreting its structure according to a model of computation.
 * 
 * @author frederic.boulanger@supelec.fr
 * 
 */
public interface Model extends ObservableEntity {
    public abstract BlockStructure getStructure();

    public abstract ModelOfComputation getMoC();

    public abstract InterfaceBlock getParent();

}
