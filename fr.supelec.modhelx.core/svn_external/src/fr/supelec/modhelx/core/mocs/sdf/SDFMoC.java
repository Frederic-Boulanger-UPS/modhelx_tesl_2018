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

package fr.supelec.modhelx.core.mocs.sdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.supelec.tesl.logging.Logger;
import fr.supelec.modhelx.core.abstractsemantics.Block;
import fr.supelec.modhelx.core.abstractsemantics.BlockStructure;
import fr.supelec.modhelx.core.abstractsemantics.Engine;
import fr.supelec.modhelx.core.abstractsemantics.InterfaceBlock;
import fr.supelec.modhelx.core.abstractsemantics.Model;
import fr.supelec.modhelx.core.abstractsemantics.ModelOfComputationImpl;
import fr.supelec.modhelx.core.abstractsemantics.NamedEntity;
import fr.supelec.modhelx.core.abstractsemantics.Pin;
import fr.supelec.modhelx.core.abstractsemantics.Relation;
import fr.supelec.modhelx.core.abstractsemantics.Token;
import fr.supelec.modhelx.core.util.BlockStructureNavHelper;
import fr.supelec.modhelx.core.util.RelationFilter;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.core.Unit;
import fr.supelec.tesl.core.UnitCalc;

public class SDFMoC extends ModelOfComputationImpl<Unit> {
    private class RelationState {
        int prod_rate;
        int cons_rate;
        int init_count;
        int current_count;

        RelationState(Relation r) {
            this.prod_rate = getPinRate(r.getOrigin());
            this.cons_rate = getPinRate(r.getTarget());
            this.init_count = getNumberOfInitialTokens(r.getOrigin());
            this.current_count = this.init_count;
        }
    }

    /** Name of the property of pin that do not depend instantaneously on the behavior of their block.*/
    public static final String INITTOKENS_PROPERTY = "NumberOfInitialTokens";
    public static final String PINRATE_PROPERTY = "Rate";
    /** The observation clock of SDF. */
    private Clock<Unit> sdf_clock_;
    /** Schedule of the blocks (sorted in topological order and appearing as many times as they must be updated). */
    private List<Block> scheduled_blocks_;
    private Iterator<Block> schedule_;
    private Block current_block_;

    /** List of model pins that are connected to block inputs */
    private List<Pin> model_inputs_;
    /** List of block pins that are connected to model outputs */
    private List<Pin> model_outputs_;

    public SDFMoC(String name) {
        super(name);
        this.sdf_clock_ = Clock.createClock(Unit.class, name+" clock", new UnitCalc());
    }

    @Override
    public Clock<Unit> getClock() {
        return this.sdf_clock_;
    }

    @Override
    public Unit getCurrentTime() {
        return Unit.getInstance();
    }

    /** Tell if pin <code>p</code> has initial tokens. */
    public static boolean hasInitialTokens(Pin p) {
        Integer nbInitTokens = ((NamedEntity) p).getProperty(INITTOKENS_PROPERTY, Integer.class);
        return (nbInitTokens != null) && (nbInitTokens > 0);
    }

    /** Get number of initial tokens on pin <code>p</code>. */
    public static int getNumberOfInitialTokens(Pin p) {
        Integer nbInitTokens = ((NamedEntity) p).getProperty(INITTOKENS_PROPERTY, Integer.class);
        if (nbInitTokens == null) {
            return 0;
        } else {
            return nbInitTokens;
        }
    }

    /** Set number of initial tokens on pin <code>p</code>. */
    public static void setNumberOfInitialTokens(Pin p, int n) {
        ((NamedEntity) p).setProperty(INITTOKENS_PROPERTY, n);
    }

    /** Get production/consumption rate for pin <code>p</code>. */
    public static int getPinRate(Pin p) {
        Integer rate = ((NamedEntity) p).getProperty(PINRATE_PROPERTY, Integer.class);
        if (rate == null) {
            return 1;
        } else {
            return rate;
        }
    }

    /** Set production/consumption rate for pin <code>p</code>. */
    public static void setPinRate(Pin p, int rate) {
        ((NamedEntity) p).setProperty(PINRATE_PROPERTY, rate);
    }

    private static void addRelationStateToPinMap(HashMap<Pin, List<RelationState>> map, Pin p, RelationState rs) {
        List<RelationState> l = map.get(p);
        if (l == null) {
            l = new LinkedList<RelationState>();
            map.put(p, l);
        }
        l.add(rs);
    }

    private static int gcd(int a , int b) {
        // Euclide's algorithm
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public void setup(final BlockStructure s) {
        super.setup(s);
        // Build a navigation helper which filter out the 
        // relations with initial tokens
        BlockStructureNavHelper nav_helper_ = new BlockStructureNavHelper(s, new RelationFilter() {
            @Override
            public boolean accept(Relation r) {
                return ! hasInitialTokens(r.getOrigin());
            }
        });
        // Sort the block in topological order
        List<fr.supelec.modhelx.core.ecore.Block> sorted_blocks = nav_helper_.topoSort();
        // Compute activations according to numbers of produced/consumed tokens
        HashMap<Pin, List<RelationState>> relmap = new HashMap<Pin, List<RelationState>>();
        for (fr.supelec.modhelx.core.ecore.Relation r : nav_helper_.getInternalRelations()) {
            Relation rr = (Relation)r;
            RelationState relstate = new RelationState(rr);
            addRelationStateToPinMap(relmap, rr.getOrigin(), relstate);
            addRelationStateToPinMap(relmap, rr.getTarget(), relstate);
        }
        int [] num_block_activations = new int[sorted_blocks.size()];
        int i = 0;
        for (i = 0; i < num_block_activations.length; i++) {
            num_block_activations[i] = 0;
        }
        // In an update, all blocks should be updated at least once
        int min_activations = 1;
        boolean cycleprod = false;
        // Maximum number of turns for finding the schedule
        int max_turns = 1;
        int rates_gcd = 1;
        for (Block b : s.getBlocks()) {
            for (Pin p : b.getInterface()) {
                if (relmap.get(p) == null) {
                    // Fill table with empty lists so that get(p) never returns null
                    relmap.put(p, new ArrayList<RelationState>());
                }
                Integer rate = p.getProperty(PINRATE_PROPERTY, Integer.class);
                if (rate != null) {
                    max_turns *= rate;
                    rates_gcd = gcd(rates_gcd, rate);
                }
            }
        }
        // Max number of turns is the smallest common multiple of the rates.
        max_turns /= rates_gcd;
        getLogger().log("info", "------ Max number of turns for computing SDF schedule: ", max_turns);
        // Number of turns of the scheduling algorithms
        int turns = 0;
        // Loop until we come back to the initial number of tokens on each pin
        do {
            i = 0;
            for (fr.supelec.modhelx.core.ecore.Block b : sorted_blocks) {
                Block sb = (Block) b;
                int nbact = min_activations;
                // Compute the number of updates required to come back to the initial count of tokens on the outputs. 
                for (Pin p : sb.getOutputPins()) {
                    for (RelationState state : relmap.get(p)) {
                        double ratio = (double)(state.init_count - state.current_count) / state.prod_rate;
                        int n = (int) Math.ceil(ratio);
                        if (n > nbact) {
                            nbact = n;
                        }
                    }
                }
                // Compute the number of updates required to come back to the initial count of tokens on the inputs. 
                for (Pin p : sb.getInputPins()) {
                    for (RelationState state : relmap.get(p)) {
                        double ratio = (double)(state.current_count - state.init_count) / state.cons_rate;
                        int n = (int) Math.ceil(ratio);
                        if (n > nbact) {
                            nbact = n;
                        }
                    }
                }
                // Add this number of activations to the activation count of this block
                num_block_activations[i] += nbact;
                // Compute the consequences of these updates on the number of tokens
                for (Pin p : sb.getOutputPins()) {
                    for (RelationState state : relmap.get(p)) {
                        state.current_count += nbact * state.prod_rate;
                    }
                }
                for (Pin p : sb.getInputPins()) {
                    for (RelationState state : relmap.get(p)) {
                        state.current_count -= nbact * state.cons_rate;
                    }
                }
                // Next block
                i++;
            }
            // If every relation is back to its original number of tokens, we are done
            cycleprod = true;
            for (List<RelationState> rellist : relmap.values()) {
                for (RelationState state : rellist) {
                    if (state.current_count != state.init_count) {
                        cycleprod = false;
                        break;
                    }
                }
                if (!cycleprod) {
                    break;
                }
            }
            // Did we reach the max number of turns?
            turns++;
            if (turns > max_turns) {
                throw new RuntimeException("No solution to the balance equations of the production/consumption rates in SDF model "+s.getModel().getName());
            }
            // For the next turns, blocks should be updated only if this is necessary to consume or produce tokens
            min_activations = 0;
        } while (!cycleprod);
        // Build the list of scheduled blocks
        this.scheduled_blocks_ = new LinkedList<Block>();
        i = 0;
        for (fr.supelec.modhelx.core.ecore.Block b : sorted_blocks) {
            for (int k = 0; k < num_block_activations[i]; k++) {
                this.scheduled_blocks_.add((Block) b);
            }
            i++;
        }
        //
        getLogger().log("info", new Object() {
            @SuppressWarnings("synthetic-access")
			@Override
            public String toString() {
                StringBuffer buf = new StringBuffer("------ Static scheduling: ");
                buf.append(s.getModel().getName());
                buf.append(Logger.EOL);
                for (Block b : SDFMoC.this.scheduled_blocks_) {
                    buf.append(Logger.TAB);
                    buf.append(b.toString());
                    buf.append(Logger.EOL);
                }
                return buf.toString();
            }
        });
        // Propagate initial tokens
        for (Block b : this.scheduled_blocks_) {
            for (Pin p : b.getOutputPins()) {
                if (hasInitialTokens(p)) {
                    propagateFromPin(p);
                }
            }
        }
        //
        this.model_inputs_ = new LinkedList<Pin>();
        for (fr.supelec.modhelx.core.ecore.Relation r : nav_helper_.getInputRelations()) {
            Relation rr = (Relation)r;
            this.model_inputs_.add(rr.getOrigin());
        }
        this.model_outputs_ = new LinkedList<Pin>();
        for (fr.supelec.modhelx.core.ecore.Relation r : nav_helper_.getOutputRelations()) {
            Relation rr = (Relation)r;
            this.model_outputs_.add(rr.getOrigin());
        }
        //
        @SuppressWarnings("unchecked")
        Model<Unit> m = (Model<Unit>) s.getModel();
        Engine engine = m.getEngine();
        ClockSet solver = engine.getSolver();
        // Add the SDF clock to the clock solver
        solver.addClock(this.sdf_clock_);
        InterfaceBlock container = m.getParent();
        if (container != null) {
            // Our observation clock implies the observation clock of our parent
            this.sdf_clock_.implies(container.getMoC().getClock());
            //			solver.addImplicationRelation(this.sdf_clock_.createMasterImplication(container.getParent().getModel().getMoC().getClock()));
        } else {
            // SDF auto triggers only if it is not embedded in another model
            this.sdf_clock_.newTick(Unit.getInstance());
        }
    }

    @Override
    public void reset(BlockStructure s) {
        super.reset(s);
        this.schedule_ = this.scheduled_blocks_.iterator();
    }

    @Override
    public void schedule(BlockStructure s) {
        this.current_block_ = this.schedule_.next();
    }

    @Override
    public void update(BlockStructure s) {
        this.current_block_.update();
    }

    private static void propagateFromPin(Pin p) {
        while (p.hasToken()) {
            Token t = p.getToken(true);
            for (Pin to : p.getSuccessorPins()) {
                to.addToken(t);
            }
        }
    }

    @Override
    public void propagate(BlockStructure s) {
        for (Pin p : this.current_block_.getOutputPins()) {
            propagateFromPin(p);
        }
    }

    @Override
    public boolean canGoFurther(BlockStructure s) {
        return this.schedule_.hasNext();
    }

    // SDF always wants to run when it is at the top level.
    @Override
    public void emitObservationRequests(BlockStructure s) {
        if (s.getModel().getParent() == null) {
            // If we are at the top level, run by ourself
            getLogger().log("info", "------ Observation requests: ", getName());
            this.sdf_clock_.newTick(Unit.getInstance());
        } else {
            // else, the embedding model takes care of activating us
        }
    }

    @Override
    public void startOfUpdate(BlockStructure s) {
        for (Pin p : this.model_inputs_) {
            for (Token t : p.getTokens()) {
                for (Pin target : p.getSuccessorPins()) {
                    target.addToken(t);
                }
            }
            p.clearTokens();
        }
    }

    @Override
    public void endOfUpdate(BlockStructure s) {
        for (Pin p : this.model_outputs_) {
            for (Token t : p.getTokens()) {
                for (Pin target : p.getSuccessorPins()) {
                    target.addToken(t);
                }
            }
            p.clearTokens();
        }
    }
}
