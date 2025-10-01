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

import java.util.Collection;
import java.util.HashSet;

/**
 * A BlockStructure is a set of blocks with relations between their pins.
 * A BlockStructure has no meaning by itself, it is interpreted according to a model of computation for computing its behavior.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class BlockStructure extends NamedEntity implements fr.supelec.modhelx.core.ecore.BlockStructure {
    /** The blocks which belong to this structure. */
    private Collection<Block> blocks_;
    /** The relations between the pins of these blocks. */
    private Collection<Relation> relations_;
    /** The model this structure belongs to. */
    private Model<?> model_;
    /** The engine running the simulation. */
    private Engine engine_;

    public BlockStructure(String name) {
        super(name);
        this.blocks_ = new HashSet<Block>();
        this.relations_ = new HashSet<Relation>();
    }

    public void setEngine(Engine e) {
        this.engine_ = e;
        for (Block b : this.blocks_) {
            b.setEngine(e);
        }
    }

    public Engine getEngine() {
        return this.engine_;
    }

    @Override
    public Collection<Block> getBlocks() {
        return this.blocks_;
    }

    /** Get the number of blocks in this structure. */
    public int size() {
        return this.blocks_.size();
    }

    /** Add a block to this structure. */
    public void add(Block b) {
        this.blocks_.add(b);
        b.setParent(this);
    }

    @Override
    public Collection<Relation> getRelations() {
        return this.relations_;
    }

    /** Create a relation between two pins in the structure. */
    public Relation createRelation(Pin source, Pin target) {
        Relation r = new Relation(source.getName()+"->"+target.getName(), source, target);
        this.relations_.add(r);
        return r;
    }

    @Override
    public Model<?> getModel() {
        return this.model_;
    }

    /** Set the model this structure belongs to. */
    public void setModel(Model<?> model_) {
        this.model_ = model_;
    }

    /** Initialize the behavior of the structure.
     *  Called at the beginning of the simulation, before the setup.
     *  This call is delegated to the blocks of the structure.
     */
    public void prep() {
        for (Block b : this.blocks_) {
            b.prep();
        }
    }

    /** Perform sanity check before setup. */
    public void sanityCheck() {
        for (Block b : this.blocks_) {
            b.sanityCheck();
        }
    }

    /** Setup the structure for a simulation.
     *  Called at the beginning of a simulation before the first snapshot, but after <code>prep</code>.
     *  This call is delegated to the blocks of the structure.
     */
    public void setup() {
        for (Block b : this.blocks_) {
            b.setup();
        }
    }

    /** Start a new snapshot.
     *  Called at the beginning of the snapshot, before the first call to update.
     *  This call is delegated to the blocks of the structure.
     */
    public void startOfSnapshot() {
        for (Block b : this.blocks_) {
            b.startOfSnapshot();
        }
    }

    /** Reset the computation of the outputs and next state of the observable.
     *  Called each time the computation of the snapshot is reset, before the first call to update.
     *  This call is delegated to the blocks of the structure.
     */
    public void reset() {
        for (Block b : this.blocks_) {
            b.reset();
        }
    }

    /** Validate the computation of the observation. Answer true if the observable agrees with the observed values.
     *  Called each time the computation of the snapshot is done, before calling endOfSnapshot.
     *  This call is delegated to the blocks of the structure.
     *  @return true if all the blocks validate the snapshot.
     */
    public boolean validate() {
        boolean valid = true;
        for (Block b : this.blocks_) {
            valid = valid & b.validate();
        }
        return valid;
    }

    /** End of the observation round, the observable can update its internal state.
     *  Called each time a snapshot has been validated, before calling emitObservationRequests.
     *  This call is delegated to the blocks of the structure.
     */
    public void endOfSnapshot() {
        for (Block b : this.blocks_) {
            b.endOfSnapshot();
        }
    }

    /** After the end of the snapshot, the clocks have been reset, and it is time to post observation requests in the form of ticks.
     *  Called after the end of each snapshot.
     *  This call is delegated to the blocks of the structure.
     */
    public void emitObservationRequests() {
        for (Block b : this.blocks_) {
            b.emitObservationRequests();
        }
    }

    /** Cleanup at the end of the simulation.
     *  This call is delegated to the blocks of the structure.
     */
    public void wrapup() {
        for (Block b : this.blocks_) {
            b.wrapup();
        }
    }
}
