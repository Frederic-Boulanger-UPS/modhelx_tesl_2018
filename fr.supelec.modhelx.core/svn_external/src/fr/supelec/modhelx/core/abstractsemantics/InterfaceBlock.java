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
import java.util.LinkedList;
import java.util.List;

/**
 * An InterfaceBlock is a special kind of Block.
 * Its behavior is given by a ModHel'X model.
 * An InterfaceBlock adapts behavior between its interface
 * and the interface of its inner model.
 */
public abstract class InterfaceBlock extends Block implements fr.supelec.modhelx.core.ecore.InterfaceBlock {
    /** The internal model of this interface block. */
    private Model<?> internal_;
    /** The relations between the pins of the interface block and the pins of the internal model. */ 
    private List<Relation> adaptation_;

    public InterfaceBlock(String name, Model<?> model, Object ... properties) {
        super(name, properties);
        this.internal_ = model;
        model.setParent(this);
        this.adaptation_ = new LinkedList<Relation>();
    }

    /** Set the engine in charge of the execution. */
    @Override
    public void setEngine(Engine e) {
        super.setEngine(e);
        this.internal_.setEngine(e);
    }

    /** Adapt data, time and control from the outer model to the inner one. */
    public abstract void adaptIn();

    /** Adapt data, time and control from the inner model to the outer one. */
    public abstract void adaptOut();

    @Override
    public Collection<Relation> getAdaptation() {
        return this.adaptation_;
    }

    @Override
    public Model<?> getInternalModel() {
        return this.internal_;
    }

    /** Connect one of my pins to another pin. */
    @Override
    public Relation connect(Pin mine, Pin other) {
        return other.getOwner().connectFromInterfaceBlock(this, mine, other);
    }

    /** Create a relation between a pin of the interface block and a pin of the internal model (or vice versa). */
    public Relation createAdaptationRelation(Pin source, Pin target) {
        Relation r = new Relation("adpat from "+source.getName()+" to "+target.getName(), source, target);
        this.adaptation_.add(r);
        return r;
    }

    /** Connect pin <code>other</code> of Model <code>model</code> to my pin <code>mine</code>.*/
    @Override
    public Relation connectFromModel(Model<?> model, Pin other, Pin mine) {
        // A connection from a pin of a model to a pin of an IB is an adaptation relation
        if (model.getParent() != this) {
            // If the model is not my internal model, there is an error!
            throw new Error("## Attempt to make a connction between a model and an interface block which is not its parent");
        }
        return this.createAdaptationRelation(other, mine);
    }

    @Override
    public void prep() {
        this.internal_.prep();
    }

    @Override
    public void setup() {
        this.internal_.setup();
        this.internal_.getMoC().getClock().implies(this.getMoC().getClock());
    }

    @Override
    public void startOfSnapshot() {
        this.internal_.startOfSnapshot();
    }

    @Override
    public void reset() {
        this.internal_.reset();
    }

    @Override
    public void update() {
        adaptIn();
        this.internal_.startOfUpdate();
        this.internal_.update();
        this.internal_.endOfUpdate();
        adaptOut();
    }

    @Override
    public boolean validate() {
        return this.internal_.validate();
    }

    @Override
    public void endOfSnapshot() {
        this.internal_.endOfSnapshot();
    }

    @Override
    public void emitObservationRequests() {
        this.internal_.emitObservationRequests();
    }

    @Override
    public void wrapup() {
        this.internal_.wrapup();
    }
}
