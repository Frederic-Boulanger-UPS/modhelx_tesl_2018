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

package fr.supelec.modhelx.core.mocs.de;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.supelec.tesl.logging.Logger;
import fr.supelec.modhelx.core.abstractsemantics.Block;
import fr.supelec.modhelx.core.abstractsemantics.BlockStructure;
import fr.supelec.modhelx.core.abstractsemantics.Engine;
import fr.supelec.modhelx.core.abstractsemantics.Model;
import fr.supelec.modhelx.core.abstractsemantics.Pin;
import fr.supelec.modhelx.core.abstractsemantics.Relation;
import fr.supelec.modhelx.core.abstractsemantics.Token;
import fr.supelec.modhelx.core.util.BlockStructureNavHelper;
import fr.supelec.modhelx.core.util.RelationFilter;
import fr.supelec.modhelx.core.util.UpdateTrigger;
import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.core.Tag;
import fr.supelec.tesl.core.Tick;

/**
 * DEMoC implements a Discrete Events MoCs.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class DEMoC extends AbstractDEMoC {
    /** The list of DE events for the blocks. */
    protected List<UpdateTrigger> events_;
    /** A navigation helper to ease the navigation in the block structure. */
    protected BlockStructureNavHelper nav_helper_;
    /** A list of the blocks of the structure is topological order. */
    protected List<fr.supelec.modhelx.core.ecore.Block> sorted_blocks_;
    /** The next block to update (chosen by 'schedule'). */ 
    protected Block block_to_update_;
    /** The number of schedule/update/propagate turns in this snapshot. */
    protected int n_turns_;

    /** An event in DE. */
    protected class DEEvent extends UpdateTrigger {
        /** The token for the value of this event. */
        private Token token_;
        /** The destination pin of this event. */
        private Pin pin_;

        /** Build a new DE event.
         * 
         * @param e the block which is to receive the event
         * @param t the token holding the value of the event
         * @param p the pin onto which the event should be delivered
         */
        public DEEvent(Block e, Token t, Pin p) {
            super(e);
            this.token_ = t;
            this.pin_ = p;
        }

        @Override
        public void prepareUpdate() {
            if ( (this.pin_ != null) && (this.token_ != null) ) {
                // Put the token on the pin in preparation for the update of the block
                this.pin_.addToken(this.token_);
            }
        }

        @Override
        public void update() {
            // Update the block which receives the event
            getEntity().update();
        }

        @Override
        public String toString() {
            return "DEEvent: " + this.token_ + " for pin \"" + this.pin_.getName() + "\" of \"" + getEntity().getName() + "\"";
        }
    }

    public DEMoC() {
        this("DE MoC");
    }

    public DEMoC(String name) {
        super(name);
        this.events_ = new LinkedList<UpdateTrigger>();
    }

    /** Compute the current time by looking at the tag of the first tagged event on the DE clock. */
    private void computeCurrentTime() {
        Tick<Double> now = this.de_clock_.getFirstTaggedTick();
        if (now != null) {
            this.current_time_ = now.getTagValue();
        }
    }

    @Override
    public void setup(BlockStructure s) {
        // Build a navigation helper which filter out the 
        // relations between not instantaneously dependent pins
        this.nav_helper_ = new BlockStructureNavHelper(s, new RelationFilter() {
            @Override
            public boolean accept(Relation r) {
                return !(isNotInstantaneouslyDependent(r.getOrigin())
                        || isNotInstantaneouslyDependent(r.getTarget()));
            }
        });
        // Sort the block in topological order
        this.sorted_blocks_ = this.nav_helper_.topoSort();
        @SuppressWarnings("unchecked")
        Model<Double> m = (Model<Double>) s.getModel();
        Engine engine = m.getEngine();
        ClockSet solver = engine.getSolver();
        // Add the DE clock to the clock solver
        solver.addClock(this.de_clock_);
        //
        super.setup(s);
    }

    @Override
    public void reset(BlockStructure s) {
        super.reset(s);
        for (Block b : s.getBlocks()) {
            if (b.hasObservationRequest()) {
                // If a block has requested to be observed, create an update trigger for it
                UpdateTrigger trig = new UpdateTrigger(b);
                @SuppressWarnings("unchecked")
                Tag<Double> reqTime = (Tag<Double>) b.getTimeOfRequest();
                if (reqTime == null) {
                    throw new Error("Update trigger in DE without time of request for block " + b);
                }
                //				Tick<Double> tick = this.de_clock_.getTick(reqTime);
                //				if (tick == null) {
                //					System.err.println(s.getModel().getEngine().getSolver().toString());
                //					throw new Error("Update trigger in DE at " + reqTime 
                //							      + " without corresponding tick on DE clock = " + this.de_clock_
                //							      + " for block " + b);
                //				}
                this.events_.add(trig);
            }
        }
        // Reset the schedule/update/propagate iteration count
        this.n_turns_ = 0;
        computeCurrentTime();
    }

    @Override
    public void startOfUpdate(BlockStructure s) {
        // Create events on the target pins for the tokens from the input pins of the models 
        for (Pin pin : s.getModel().getInputPins()) {
            for (Token tok : pin.getTokens()) {
                for (Pin tgt : pin.getSuccessorPins()) {
                    DEEvent evt = new DEEvent((Block) tgt.getOwner(), tok, tgt);
                    this.events_.add(evt);
                }
            }
            pin.clearTokens();
        }
        computeCurrentTime();
    }

    @Override
    public void schedule(BlockStructure s) {
        this.n_turns_++;
        this.block_to_update_ = null;
        getLogger().log("info", "------ Schedule: (", this.n_turns_, ") ", getName());
        getLogger().log("fine",
                new Object() {
            @Override
            public String toString() {
                StringBuffer buf = new StringBuffer();
                for (UpdateTrigger ut : DEMoC.this.events_) {
                    buf.append(Logger.TAB);
                    buf.append("## @");
                    buf.append(DEMoC.this.current_time_);
                    buf.append(": ");
                    buf.append(ut.toString());
                    buf.append(Logger.EOL);
                }
                return buf.toString();
            }
        }
                );
        // For each block in the model, look for events for this block.
        // Topological order is used so that a block which can produce an event
        // for another block is updated before that block.
        //		System.err.println("## DE events before: " + this.events_);
        for (fr.supelec.modhelx.core.ecore.Block b : this.sorted_blocks_) {
            Iterator<UpdateTrigger> iter = this.events_.iterator();
            this.block_to_update_ = null;
            while (iter.hasNext()) {
                UpdateTrigger ut = iter.next();
                if (ut.getEntity() == b) {
                    iter.remove();
                    ut.prepareUpdate();
                    this.block_to_update_ = (Block) b;
                }
            }
            // If we found a block to update, that's it
            if (this.block_to_update_ != null) {
                break;
            }
        }
        //		System.err.println("## DE events after: " + this.events_);
    }

    @Override
    public void update(BlockStructure s) {
        getLogger().log("info", "------ Update: (", this.n_turns_, ") ", getName(), " (", this.block_to_update_, ")");
        if (this.block_to_update_ != null) {
            this.block_to_update_.update();
        }
    }

    @Override
    public void propagate(BlockStructure s) {
        getLogger().log("info", "------ Propagate: (", this.n_turns_, ") ", getName(), " (", this.block_to_update_, ")");
        if (this.block_to_update_ != null) {
            // Propagate tokens from the output pins of the block that has just been updated
            for (Pin pin : this.block_to_update_.getOutputPins()) {
                for (Token tok : pin.getTokens()) {
                    for (Pin dest : pin.getSuccessorPins()) {
                        DEEvent evt = new DEEvent((Block) dest.getOwner(), tok, dest);
                        this.events_.add(evt);
                    }
                }
                pin.clearTokens();
            }
        }
        getLogger().log("fine",
                new Object() {
            @Override
            public String toString() {
                StringBuffer buf = new StringBuffer();
                for (UpdateTrigger ut : DEMoC.this.events_) {
                    buf.append("## @");
                    buf.append(DEMoC.this.current_time_);
                    buf.append(": ");
                    buf.append(ut.toString());
                    buf.append(Logger.EOL);
                }
                return buf.toString();
            }
        }
                );
    }

    @Override
    public boolean canGoFurther(BlockStructure s) {
        if (this.n_turns_ > 2* s.size()) {
            throw new RuntimeException("Too many iterations in "+getName());
        }
        // Are there still some event to process now (ignoring events for the output pins of the model)?
        boolean go = false;
        for (UpdateTrigger ut : this.events_) {
            if (ut.getEntity() instanceof Model) {
                continue;
            } else {
                go = true;
            }
        }
        return go;
    }

    @Override
    public void endOfUpdate(BlockStructure s) {
        // Propagate tokens to the outputs of the model
        Iterator<UpdateTrigger> iter = this.events_.iterator();
        while (iter.hasNext()) {
            UpdateTrigger ut = iter.next();
            if (ut.getEntity() instanceof Model) {
                ut.prepareUpdate();
                iter.remove();
            }
        }
        this.de_clock_.resetClock();
    }

    @Override
    public void endOfSnapshot(BlockStructure s) {
        super.endOfSnapshot(s);
        this.events_.clear();
        this.block_to_update_ = null;
    }
}
