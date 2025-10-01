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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An annotation to specify that a state value is to be reverted at start of snapshot instead of reset time.
 * This is useful for blocks that do not validate a snapshot and need to keep some information around during 
 * the next iterations in order to make the snapshot converge toward a new permanent state of the model.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SnapshotAttribute {
    //
}
