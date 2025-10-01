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

import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.core.Tag;


/** 
 * A Block is the basic unit of behavior in ModHel'X.
 */
public abstract class Block extends ObservableEntity implements fr.supelec.modhelx.core.ecore.Block {
    /** The BlockStructure this block belongs to. */
    private BlockStructure structure_;
    /** The engine used for simulation. */
    private Engine engine_;

    public Block(String name, Object ... properties) {
        super(name, properties);
        this.structure_ = null;
    }

    @Override
    public BlockStructure getParent() {
        return this.structure_;
    }

    /** Set the BlockStructure this block belongs to. */
    public void setParent(BlockStructure s) {
        this.structure_ = s;
    }

    /** Connect one of my pins to another pin. */
    @Override
    public Relation connect(Pin mine, Pin other) {
        // Double dispatch: I am a regular Block
        return other.getOwner().connectFromRegularBlock(this, mine, other);
    }

    /** Connect pin <code>other</code> of Model <code>model</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromModel(Model<?> model, Pin other, Pin mine) {
        // A connection from a pin of a Model and a pin of a regular Block is a regular relation
        if (model.getStructure() != this.structure_) {
            // Error, connection between a model and a block that does not belong to the model
            throw new Error("## Connection across hierarchical levels");
        }
        return model.createRelation(other, mine);
    }

    /** Connect pin <code>other</code> of regular Block <code>block</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromRegularBlock(Block block, Pin other, Pin mine) {
        // A connection from a pin of a regular block and a pin of a regular Block is a regular relation
        if (block.structure_ != this.structure_) {
            // Error, connection between a model and a block that does not belong to the model
            throw new Error("## Connection across hierarchical levels");
        }
        return block.getParent().createRelation(other, mine);
    }

    /** Connect pin <code>other</code> of InterfaceBlock <code>intfBlock</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromInterfaceBlock(InterfaceBlock intfBlock, Pin other, Pin mine) {
        // A connection from a pin of an IB and a pin of a block is a regular relation
        if (intfBlock.getParent() != this.structure_) {
            // Error, connection between a model and a block that does not belong to the model
            throw new Error("## Connection across hierarchical levels");
        }
        return intfBlock.getParent().createRelation(other, mine);
    }

    /** Get the ModelOfComputation according to which this Block is executed. */ 
    @Override
    public ModelOfComputation<?> getMoC() {
        return getParent().getModel().getMoC();
    }

    /** Get the execution Engine by which this block is executed. */ 
    public Engine getEngine() {
        return this.engine_;
    }

    /** Set the engine in charge of the execution. */
    public void setEngine(Engine e) {
        this.engine_ = e;
    }

    /** Get the clock solver of the execution engine. */ 
    public ClockSet getSolver() {
        return getEngine().getSolver();
    }

    /** Has this block posted an observation request?
     *  If yes, the block needs to be updated even if the scheduling policy of the MoC does not require it.
     */
    @SuppressWarnings("static-method")
	public boolean hasObservationRequest() {
        return false;
    }

    /** Get the time tag at which the block has requested to be observed. */
    @SuppressWarnings("static-method")
	public Tag<? extends Comparable<?>> getTimeOfRequest() {
        // Default behavior for blocks that don't request to be observed.
        return null;
    }

    @Override
    public void sanityCheck() {
        if (this.structure_ == null) {
            throw new Error("## Error: block " + this.getName() + " is not embedded in a structure.");
        }
    }
}
