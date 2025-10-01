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

package fr.supelec.modhelx.core.state_management;

/** A ManagedBlock with no timed behavior. */
public abstract class PlainManagedBlock extends ManagedBlock {
    public PlainManagedBlock(String name, Object... properties) {
        super(name, properties);
    }

    @Override
    public void doStartOfSnapshot() {
        // Nothing to do for a plain managed block
    }

    @Override
    public void doPreSetup() {
        // Nothing to do for a plain managed block
    }

    @Override
    public void doReset() {
        // Default = do nothing
    }

    @Override
    public void doEndOfSnapshot() {
        // Default = do nothing

    }
}
