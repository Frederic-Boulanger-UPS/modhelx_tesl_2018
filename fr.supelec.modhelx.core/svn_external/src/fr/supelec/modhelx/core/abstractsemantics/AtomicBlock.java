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

/** A block without an explicit ModHel'X model (opaque behavior). */
public abstract class AtomicBlock extends Block implements fr.supelec.modhelx.core.ecore.AtomicBlock {
    public AtomicBlock(String name) {
        super(name);
    }

    public AtomicBlock(String name, Object ... properties) {
        super(name, properties);
    }

    @Override
    public void prep() {
        /* Default implementation does nothing */
    }

    @Override
    public void setup() {
        /* Default implementation does nothing */
    }

    @Override
    public void startOfSnapshot() {
        /* Default implementation does nothing */
    }

    @Override
    public void reset() {
        /* Default implementation does nothing */
    }

    @Override
    public void startOfUpdate() {
        /* Default implementation does nothing */
    }

    @Override
    public void endOfUpdate() {
        /* Default implementation does nothing */
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public void endOfSnapshot() {
        /* Default implementation does nothing */
    }

    @Override
    public void emitObservationRequests() {
        /* Default implementation does nothing */
    }

    @Override
    public void wrapup() {
        /* Default implementation does nothing */
    }

}
