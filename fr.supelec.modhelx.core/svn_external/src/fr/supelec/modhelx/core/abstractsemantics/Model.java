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


/**
 * A Model describes a behavior by the combination of the behavior of the blocks of a structure according to a model of computation.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class Model<T extends Comparable<? super T>> extends ObservableEntity implements fr.supelec.modhelx.core.ecore.Model {
    /** The model of computation of this model. */
    private ModelOfComputation<T> moc_;
    /** The structure that holds the blocks of this model. */
    private BlockStructure structure_;
    /** The interface block this model belongs to (if any, null otherwise). */
    private InterfaceBlock parent_;
    /** The execution engine in charge of the execution of this model (cached value). */
    private Engine engine_;

    /** Build a new model.
     * 
     * @param name name of the model
     * @param moc model of computation of the model
     * @param s block structure of the model
     */
    public Model(String name, ModelOfComputation<T> moc, BlockStructure s, Object ... properties) {
        super(name, properties);
        this.moc_ = moc;
        this.structure_ = s;
        // Tell the structure it belongs to this model
        s.setModel(this);
        this.parent_ = null;
        this.engine_ = null;
    }

    /** Build a model, automatically creating the corresponding block structure. */
    public Model(String name, ModelOfComputation<T> moc, Object ... properties) {
        this(name, moc, new BlockStructure(name+"_struct"), properties);
    }

    /** Add a block to this model. */
    public <B extends Block> B add(B b) {
        this.structure_.add(b);
        return b;
    }

    /** Connect two pins in this model. */
    public Relation createRelation(Pin source, Pin target) {
        return this.structure_.createRelation(source, target);
    }

    /** Connect one of my pins to another pin. */
    @Override
    public Relation connect(Pin mine, Pin other) {
        // Double dispatch: I am a Model
        return other.getOwner().connectFromModel(this, mine, other);
    }

    /** Connect pin <code>other</code> of Model <code>model</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromModel(Model<?> model, Pin other, Pin mine) {
        // We should never have a connection between two pins that belong to models,
        // there should be an interface block between the two.
        throw new Error("## Direct connection between model pins");
    }

    /** Connect pin <code>other</code> of regular Block <code>block</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromRegularBlock(Block block, Pin other, Pin mine) {
        // A connection from a pin of a regular block and a pin of a model is a regular relation
        if (block.getParent() != this.structure_) {
            // Error, connection between a model and a block that does not belong to the model
            throw new Error("## Connection across hierarchical levels");
        }
        return block.getParent().createRelation(other, mine);
    }

    /** Connect pin <code>other</code> of InterfaceBlock <code>intfBlock</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromInterfaceBlock(InterfaceBlock intfBlock, Pin other, Pin mine) {
        // A connection from a pin of an IB and a pin of a model is an adaptation relation
        if (intfBlock.getInternalModel() != this) {
            // If the model is not the internal model of the interface block, there is an error!
            throw new Error("## Attempt to make a connction between a model and an interface block which is not its parent");
        }
        return intfBlock.createAdaptationRelation(other, mine);
    }

    /** Set the interface block that contains this model. */
    public void setParent(InterfaceBlock b) {
        this.parent_ = b;
    }

    @Override
    public InterfaceBlock getParent() {
        return this.parent_;
    }

    /** Get the execution engine which is in charge of executing this model. */
    public Engine getEngine() {
        Model<?> m = this;
        Engine e = m.engine_;
        while (e == null) {
            // If we don't know how execution engine, look for a parent interface block
            InterfaceBlock b = m.getParent();
            if (b == null) {
                break;
            }
            // Get the model of the block structure containing this interface block
            m = b.getParent().getModel();
            if (m == null) {
                break;
            }
            e = m.engine_;
        }
        this.engine_ = e;
        return e;
    }

    // Set the execution engine in charge of executing this model (used for the root model). */
    public void setEngine(Engine e) {
        this.engine_ = e;
        this.moc_.setEngine(e);
        this.structure_.setEngine(e);
    }

    @Override
    public ModelOfComputation<T> getMoC() {
        return this.moc_;
    }

    @Override
    public BlockStructure getStructure() {
        return this.structure_;
    }

    // operations necessary for hierarchical execution, delegated to the moc associated to the model
    @Override
    public void prep() {
        this.getEngine().getLogger().log("info", "----- Prep: ", getName());
        this.moc_.prep(this.getStructure());
    }

    @Override
    public void sanityCheck() {
        this.structure_.sanityCheck();
    }

    @Override
    public void setup() {
        this.engine_.getLogger().log("info", "----- Setup: ", getName());
        this.moc_.setup(this.getStructure());
    }

    @Override
    public void startOfSnapshot() {
        this.engine_.getLogger().log("info", "----- Start of snapshot: ", getName());
        this.moc_.startOfSnapshot(this.getStructure());
    }

    @Override
    public void reset() {
        this.engine_.getLogger().log("info", "----- Reset: ", getName());
        this.moc_.reset(this.getStructure());
    }

    @Override
    public void update() {
        this.engine_.getLogger().log("info", "----- Update: ", getName());
        BlockStructure s = this.getStructure();
        boolean canGoFurther = this.moc_.canGoFurther(s);
        // While the MoC says we can compute more things
        while (canGoFurther) {
            // Ask the MoC to schedule a block
            this.moc_.schedule(s);
            // Ask the MoC to update the block it has scheduled
            this.moc_.update(s);
            // Ask the MoC to propagate new information in the model
            this.moc_.propagate(s);
            // Ask the MoC if we can compute more things
            canGoFurther = this.moc_.canGoFurther(s);
        }
    }

    @Override
    public boolean validate() {
        this.engine_.getLogger().log("info", "----- Validate: ", getName());
        return this.moc_.validate(this.getStructure());
    }

    @Override
    public void endOfSnapshot() {
        this.engine_.getLogger().log("info", "----- End of snapshot: ", getName());
        this.moc_.endOfSnapshot(this.getStructure());
    }

    @Override
    public void emitObservationRequests() {
        this.engine_.getLogger().log("info", "----- Observation requests: ", getName());
        this.moc_.emitObservationRequests(this.getStructure());
    }

    @Override
    public void wrapup() {
        this.engine_.getLogger().log("info", "----- Wrapup: ", getName());
        this.moc_.wrapup(this.structure_);
    }

    // for hierarchy
    @Override
    public void startOfUpdate() {
        this.engine_.getLogger().log("info", "----- Start of update: ", getName());
        this.moc_.startOfUpdate(this.structure_);
    }

    @Override
    public void endOfUpdate() {
        this.engine_.getLogger().log("info", "----- End of update: ", getName());
        this.moc_.endOfUpdate(this.structure_);
    }
}
