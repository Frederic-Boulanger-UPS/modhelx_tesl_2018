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

package fr.supelec.modhelx.core.mocs.tfsm;

import fr.supelec.modhelx.core.abstractsemantics.AtomicBlock;
import fr.supelec.modhelx.core.abstractsemantics.InputPin;
import fr.supelec.modhelx.core.abstractsemantics.OutputPin;
import fr.supelec.modhelx.core.abstractsemantics.Pin;
import fr.supelec.modhelx.core.abstractsemantics.Relation;

public class FSMState extends AtomicBlock {
    private final Pin in_;
    private final Pin out_;
    private final static String INITIAL_STATE_PROPERTY = "InitialState";

    public FSMState(String name) {
        super(name);
        this.in_ = addPin(new InputPin("in"));
        this.out_ = addPin(new OutputPin("out"));
    }
    
    public Relation transitionTo(FSMState to, String guard, String action) {
        Relation r = this.out_.connectTo(to.in_);
        r.setProperty(TFSMMoC.TFSM_ROLE_PROPERTY, TFSMMoC.TFSM_ROLE_TRANSITION);
        r.setProperty(TFSMMoC.GUARD_PROPERTY, guard);
        if (action != null) {
            r.setProperty(TFSMMoC.ACTION_PROPERTY, action);
        }
        return r;
    }

    @Override
    public void update() {
        Boolean verbose = this.getParent().getModel().getProperty("verbose", Boolean.class); 
        if ((verbose != null) && verbose) {
            System.out.println(getParent().getModel().getName() + " entering state " + getName() + " @" + ((TFSMMoC)getMoC()).getCurrentTime());
        }
    }

    public void setInitial(boolean initial) {
    	setProperty(INITIAL_STATE_PROPERTY, initial);
    }
    
    public boolean isInitial() {
    	return hasProperty(INITIAL_STATE_PROPERTY) && getProperty(INITIAL_STATE_PROPERTY, Boolean.class);
    }
}
