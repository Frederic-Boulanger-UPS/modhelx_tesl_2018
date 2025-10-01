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

//@ Special implementation of the Clock<Unit> type
public class UnitClock extends Clock<Unit> {

    public UnitClock(String name, TagCalculus<Unit> calc, boolean greedy) {
        super(name, calc, greedy);
    }

    public UnitClock(String name, TagCalculus<Unit> calc) {
        super(name, calc);
    }

    //@ Create a tick of the right type on this clock
    @Override
    public Tick<Unit> newTick() {
        return newTick(Unit.getInstance());
    }


}
