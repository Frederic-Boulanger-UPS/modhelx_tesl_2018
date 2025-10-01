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

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import fr.supelec.modhelx.core.abstractsemantics.Block;
import fr.supelec.modhelx.core.abstractsemantics.BlockStructure;
import fr.supelec.modhelx.core.abstractsemantics.Engine;
import fr.supelec.modhelx.core.abstractsemantics.Model;
import fr.supelec.modhelx.core.abstractsemantics.ModelOfComputationImpl;
import fr.supelec.modhelx.core.abstractsemantics.Pin;
import fr.supelec.modhelx.core.abstractsemantics.Relation;
import fr.supelec.modhelx.core.abstractsemantics.Token;
import fr.supelec.modhelx.core.mocs.tfsm.parser.Expression;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.core.RoundDouble;
import fr.supelec.tesl.core.TagRelation;
import fr.supelec.tesl.core.Tick;

/**
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class TFSMMoC extends ModelOfComputationImpl<Double> {
    /** The observation request clock of this MoC. */
    protected Clock<Double> tfsm_clock_;
    /** The current TFSM time. */
    protected Double current_time_;
    protected Model<Double> state_machine_;
    protected Engine exec_engine_;
    protected Block currentState_;
    protected Block initialState_;
    protected Double timeOfEntry_;
    protected List<String> tfsmEvents_;
    protected List<String> tfsmActions_;
    private boolean firstUpdate;
    private double next_time_of_update_;
    private String label_of_next_transition_ ;
    
    public final static String GUARD_PROPERTY = "Guard";
    public final static String ACTION_PROPERTY = "Action";
    public final static String TFSM_ROLE_PROPERTY = "TFSMRole";
    public final static String TFSM_ROLE_TRANSITION = "Transition";

    public TFSMMoC(String name) {
        super(name);
        this.tfsm_clock_ = Clock.createClock(Double.class, this.getName() + " clock", new RoundDouble());
        this.currentState_ = null;
        this.tfsmEvents_ = new LinkedList<String>();
        this.tfsmActions_ = new LinkedList<String>();
        this.timeOfEntry_ = null;
        this.firstUpdate = true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void setup(BlockStructure s) {
        super.setup(s);
        this.state_machine_ = (Model<Double>) s.getModel();
        
        // Find the initial state
        for(Block b : s.getBlocks()) {
        	if(((FSMState)b).isInitial()) {
        		this.initialState_ = b;
        		break;
        	}
        }
        
        if (this.initialState_ == null) {
            throw new Error("## Error: no initial state in " + this.state_machine_.getName());
        }
        this.timeOfEntry_ = this.state_machine_.getProperty("initTime", Double.class);
        this.current_time_ = this.timeOfEntry_;
        setCurrentState(this.initialState_);
        this.exec_engine_ = this.state_machine_.getEngine();
        ClockSet solver = this.exec_engine_.getSolver();
        // Add the TFSM clock to the clock solver
        solver.addClock(this.tfsm_clock_);

        // Look for an epsilon transition (empty guard) starting from the initial state
        boolean init_trans = false;
        for (Pin p : this.currentState_.getOutputPins()) {
            for (Relation r : p.getOutgoingRelations()) {
                String label = r.getProperty(GUARD_PROPERTY, String.class);
                if (label.length() == 0) {
                    init_trans = true;
                    break;
                }
            }
        }
        // If there is such a transition, the state machine should react ASAP
        if (init_trans) {
            if (this.timeOfEntry_ == null) {
                System.err.println("# TFSM Warning: state machine \""
                        + this.state_machine_.getName()
                        + "\" has initial epsilon transition but no initTime property to set its date");
                this.timeOfEntry_ = 0.0;
            }
            this.tfsm_clock_.newTick(this.timeOfEntry_);
            this.tfsmEvents_.add("");
        } else {
            emitObservationRequests(s);
        }
    }

    @Override
    public void reset(BlockStructure s) {
        super.reset(s);
        this.firstUpdate = true;
    }

    public void setCurrentState(Block b) {
        this.currentState_ = b;
        b.update();
    }

    public Block getCurrentState() {
        return this.currentState_;
    }

    @Override
    public void schedule(BlockStructure s) {
        // Nothing to do, everything is in update
    }

    @Override
    public void update(BlockStructure s) {
        Relation relationToUpdate = getFiringTransition(s);
        if ((relationToUpdate != null) && this.firstUpdate) {
            if(!relationToUpdate.getOrigin().getOwner().equals(this.currentState_)) {
                throw new Error("Update of TFSM without any observationRequest");
            }
            setCurrentState((FSMState) relationToUpdate.getTarget().getOwner());
            this.timeOfEntry_ = this.current_time_;

            String action = relationToUpdate.getProperty(ACTION_PROPERTY, String.class);
            if (action != null) {
                StringTokenizer st = new StringTokenizer(action, "/", true);

                while(st.hasMoreElements()) {
                    String t = st.nextToken();
                    this.tfsmActions_.add(t);
                    boolean action_found = false;
                    for (Pin p : s.getModel().getOutputPins()) {
                        if (p.getName().equals(t)) {
                            action_found = true;
                            if (!p.hasToken()) {
                                // Add symbol only if not already produced
                                p.addToken(new Token(this));
                            }
                        }
                    }
                    if (!action_found) {
                        System.err.println("## Warning: no pin found for action " + t + " on transition " + relationToUpdate.getName());
                    }
                }
            }
            relationToUpdate=null;	
        }	
        this.firstUpdate=false;
    }

    @Override
    public void propagate(BlockStructure s) {
        /* Nothing to propagate in TFSM. */
    }

    @Override
    public boolean canGoFurther(BlockStructure s) {
        return (this.firstUpdate && (!this.tfsmEvents_.isEmpty()));
    }

    @Override
    public void startOfUpdate(BlockStructure s) {
        getLogger().log("info", "------ Start of update: ", getName());
        computeCurrentTime();
        getIncommingEvents(s);
    }

    @Override
    public void endOfUpdate(BlockStructure s) {
        getLogger().log("info", "------ End of update: ", getName());
        for(String act : this.tfsmActions_) {
            for(Pin p : s.getModel().getOutputPins()) {
                if (p.getName().equals(act)) {
                    if (!p.hasToken()) {
                        p.addToken(new Token(this));
                    }
                }
            }
        }
    }

    /** Compute the current time by looking at the tag of the first tagged event on the tfsm clock. */
    @SuppressWarnings("unchecked")
    private void computeCurrentTime() {
        this.current_time_ = null;
        Tick<Double> now = this.tfsm_clock_.getNowTick();
        if ((now != null) && (now.getTag() != null)) {
            // A now tick was induced on the TFSM clock (delay transition for instance) 
            this.current_time_ = now.getTagValue();
        } else {
            // No now tick was induced on the TFSM clock (reaction to an input event)
            // Compute the time using tag relations
            ClockSet cs = this.exec_engine_.getSolver();
            for (TagRelation<?,?> rel : cs.getTagRelations()) {
                if (rel.fromClock() == this.tfsm_clock_) {
                    if (rel.toClock().hasTickNow()) {
                        this.current_time_ = reverseTagConversion((TagRelation<Double, ?>) rel);
                        break;
                    }
                } else if (rel.toClock() == this.tfsm_clock_) {
                    if (rel.fromClock().hasTickNow()) {
                        this.current_time_ = directTagConversion((TagRelation<?, Double>) rel);
                        break;
                    }
                }
            }
        }
        if (this.current_time_ == null) {
            throw new Error("Update of TFSM without possibility to compute the current time.");
        }
    }

    private static <T extends Comparable<? super T>> Double directTagConversion(TagRelation<T,Double> rel) {
        return rel.directConversion(rel.fromClock().getNowTick().getTagValue());
    }

    private static <T extends Comparable<? super T>> Double reverseTagConversion(TagRelation<Double,T> rel) {
        return rel.reverseConversion(rel.toClock().getNowTick().getTagValue());
    }

    /** Get the current time in this MoC. */
    @Override
    public Double getCurrentTime() {
        return this.current_time_;
    }

    @Override
    public Clock<Double> getClock() {
        return this.tfsm_clock_;
    }

    private void getIncommingEvents(BlockStructure s) {
        // Get events from inputs
        for (Pin p : s.getModel().getInputPins()) {
            if (p.hasToken()) {
                String evt = p.getName();
                if (!this.tfsmEvents_.contains(evt)) {
                    this.tfsmEvents_.add(evt);
                }
                p.clearTokens();
            }
        }
        // Get timed events
        if (this.next_time_of_update_ == this.current_time_ && this.label_of_next_transition_!=null){
            this.tfsmEvents_.add(this.label_of_next_transition_);
            this.label_of_next_transition_ = null;
        }
    }

    public Relation getFiringTransition(BlockStructure s) {
        Relation reponse = null;

        for (Pin p : this.currentState_.getOutputPins()) {
            for (Relation r : p.getOutgoingRelations()) {
                try {
                    if (Expression.parse(r.getProperty(GUARD_PROPERTY, String.class), this.tfsmEvents_)) {
                        reponse = r; 
                        break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return reponse;
    }

    @Override
    public void endOfSnapshot(BlockStructure s) {
        super.endOfSnapshot(s);
        getLogger().log("info", "------ End of snapshot: ", getName());

        this.tfsmActions_.clear();
        this.tfsmEvents_.clear();
    }

    @Override
    public void emitObservationRequests(BlockStructure s) {
        double min_delay = Double.MAX_VALUE;

        for (Pin p : this.currentState_.getOutputPins()) {
            for (Relation r : p.getOutgoingRelations()) {
                String label = r.getProperty(GUARD_PROPERTY, String.class);
                String delay = Expression.getDelayGard(label);
                if(delay != null) {
                    double current_delay = Double.parseDouble(delay);
                    if (current_delay < min_delay) {
                        min_delay = current_delay;
                    }
                }			
            }
        }
        if (min_delay != Double.MAX_VALUE) {
            if (this.timeOfEntry_ == null) {
                throw new Error("## TFSM error: timed transition from a state with no time of entry (missing \"initTime\" property?)");
            }
            this.next_time_of_update_ = RoundDouble.do_add(this.timeOfEntry_, min_delay);
            this.tfsm_clock_.newTick().setTagValue(this.next_time_of_update_);
            this.label_of_next_transition_ = "D"+min_delay;
        }
    }

    public List<String> getTfsmEvents() {
        return this.tfsmEvents_;
    }
}
