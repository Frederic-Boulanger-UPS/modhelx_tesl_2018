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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//@ A storage for the state of a clockset 
public class ClockSetMark {
    private List<ClockBackupInterface<?>> clock_mark_;
    private List<ImplicationBackupInterface> impl_mark_;

    //@ Create an empty mark
    public ClockSetMark() {
        this.clock_mark_ = new LinkedList<ClockBackupInterface<?>>();
        this.impl_mark_ = new LinkedList<ImplicationBackupInterface>();
    }

    //@ Add a clock to the mark
    public void addClock(ClockBackupInterface<?> backup) {
        this.clock_mark_.add(backup);
    }

    //@ Add an implication relation to the mark
    public void addImplication(ImplicationBackupInterface backup) {
        this.impl_mark_.add(backup);
    }

    //@ Get the saved state of the clocks
    public Collection<ClockBackupInterface<?>> clockBackups() {
        return this.clock_mark_;
    }

    //@ Get the saved state of the implication relations
    public Collection<ImplicationBackupInterface> implicationBackups() {
        return this.impl_mark_;
    }

}
