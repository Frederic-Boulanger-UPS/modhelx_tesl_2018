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

//@ The Unit type for pure clocks without a time domain
public class Unit implements Comparable<Unit> {

    private static Unit instance = null;

    private Unit() { }

    public static Unit getInstance() {
        if(instance == null) {
            instance = new Unit();
        }

        return instance;			
    }

    @Override
    public int compareTo(Unit o) {
        return 0; // All Units are made equal
    }

    @Override
    public String toString() {
        return "Unit";
    }

}