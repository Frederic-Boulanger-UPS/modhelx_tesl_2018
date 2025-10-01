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

import fr.supelec.tesl.core.Clock;

/** A ModelOfComputation models the rules for combining the behavior of the blocks in a structure.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public abstract class ModelOfComputation<T extends Comparable<? super T>> extends NamedEntity implements fr.supelec.modhelx.core.ecore.ModelOfComputation {
    /** The engine running the simulation. */
    private Engine engine_;

    public ModelOfComputation(String name) {
        super(name);
    }

    public void setEngine(Engine e) {
        this.engine_ = e;
    }

    public Engine getEngine() {
        return this.engine_;
    }

    /** Get the observation clock of this MoC. */
    public abstract Clock<T> getClock();
    /** Get the current time of this MoC. */
    public abstract T getCurrentTime();

    // operations for tokens
    /** Get the value associated to a token by this MoC. */
    public abstract Object getTokenValue(Token t);
    /** Set the value associated to a token by this MoC. */
    public abstract void setTokenValue(Token t, Object val);
    /** Create a new token for this MoC. */
    public abstract Token createToken(Object val);
    /** Duplicate a token (return a new, different token, associated to the same value. */
    public abstract Token duplicateToken(Token t);

    /** Prepare for simulation.
     * This is called early, just after loading the model, before the execution starts. 
     * @param s the block structure of the model driven by this MoC
     */
    public abstract void prep(BlockStructure s);

    // beginning of the simulation, done just before executing the model (pair with wrapup, done just after executing)
    /** Setup for simulation.
     * Called after <code>prep</code>, before the first snapshot.
     * @param s the block structure of the model driven by this MoC
     */
    public abstract void setup(BlockStructure s);

    /** Start the computation of a new snapshot on structure <code>s</code>. */
    public abstract void startOfSnapshot(BlockStructure s);
    /** Reset for a new computation of the current snapshot (called at least once at the beginning of the snapshot). */
    public abstract void reset(BlockStructure s);
    /** Choose a block to be updated. */
    public abstract void schedule(BlockStructure s);
    /** Update a block. */
    public abstract void update(BlockStructure s);
    /** Propagate new information produced by the update of a block. */
    public abstract void propagate(BlockStructure s);
    /** Tell if it is possible to compute more information. */
    public abstract boolean canGoFurther(BlockStructure s);
    /** Tell if the current computation of the snapshot is valid according to the semantics of this MoC. */
    public abstract boolean validate(BlockStructure s);
    /** End of the snapshot =&gt; update internal state, produce outputs. */
    public abstract void endOfSnapshot(BlockStructure s);
    /** Place ticks on clocks to request to be observed in future snapshots. */
    public abstract void emitObservationRequests(BlockStructure s);

    /** Called at the beginning of an update of an inner block (get partial inputs from the upper model). */
    public abstract void startOfUpdate(BlockStructure s);
    /** Called at the end of an update of an inner block (produce partial outputs for the upper model). */
    public abstract void endOfUpdate(BlockStructure s);

    /** End of the simulation =&gt; release resources and clean up. */
    public abstract void wrapup(BlockStructure s);
}
