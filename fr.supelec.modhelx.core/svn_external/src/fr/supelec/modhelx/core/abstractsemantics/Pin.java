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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fr.supelec.modhelx.core.state_management.Value;


/**
 * An implementation of Pin for the abstract semantics of ModHel'X.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public abstract class Pin extends NamedEntity implements fr.supelec.modhelx.core.ecore.Pin {
    /** The entity this pin belongs to. */
    private ObservableEntity owner_;
    /** The tokens present on this pin. */
    private List<Token> tokens_;
    /** The relations that have this pin as target. */
    private Set<Relation> incoming_;
    /** The relations that have this pin as origin. */
    private Set<Relation> outgoing_;

    /** The list of pins which are the target of a relation which has this pin as origin. */
    private List<Pin> successors_ = null;
    /** The list of pins which are the origin of a relation which has this pin as target. */
    private List<Pin> predecessors_ = null;

    /** Build a new pin named <code>name</code>. */
    public Pin(String name, Object ... properties) {
        super(name, properties);
        this.owner_ = null;
        this.tokens_ = new LinkedList<Token>();
        this.incoming_ = new HashSet<Relation>();
        this.outgoing_ = new HashSet<Relation>();
    }

    /** Set the owner of this pin. */
    public void setOwner(ObservableEntity o) {
        this.owner_ = o;
    }

    @Override
    public ObservableEntity getOwner() {
        return this.owner_;
    }

    public Relation connectTo(Pin dst) {
        return this.owner_.connect(this, dst);
    }

    /** Tell if this pin has at least a token on it. */
    public boolean hasToken() {
        return (this.tokens_.size() > 0);
    }

    /** Get a token from this pin, and remove it if <code>remove</code> is true. */
    public Token getToken(boolean remove) {
        Token tok = this.tokens_.get(0);
        if (remove) {
            this.tokens_.remove(0);
        }
        return tok;
    }

    /** Get a token value from this pin, and remove the token if <code>remove</code> is true. */
    public <T> T readValue(Class<T> type, boolean remove) {
        Token tok = this.tokens_.get(0);
        if (remove) {
            this.tokens_.remove(0);
        }
        @SuppressWarnings("unchecked")
        T value = (T) tok.getValue();
        return value;
    }

    /** Get the tokens that are on this pin. */
    public Collection<Token> getTokens() {
        return this.tokens_;
    }

    /** Add a token to this pin. */
    public Pin addToken(Token token) {
        this.tokens_.add(token);
        return this;
    }

    /** Add a token with a given value on this pin. */
    public <T> Pin putValue(T value) {
        this.addToken(new Token(this.owner_.getMoC()).setValue(value));
        return this;
    }

    /** Add a token with a given value on this pin. */
    public <T> Pin putValue(Value<T> value) {
        putValue(value.getValue());
        return this;
    }

    /** Delete all tokens on this pin. */
    public Pin clearTokens() {
        this.tokens_.clear();
        return this;
    }

    @Override
    public Collection<Relation> getIncomingRelations() {
        return this.incoming_;
    }

    @Override
    public Collection<Relation> getOutgoingRelations() {
        return this.outgoing_;
    }

    /** Add an incoming relation to this pin. */
    public void addIncoming(Relation r) {
        if (r.getTarget() != this) {
            throw new RuntimeException("Adding incoming relation "+r+" to "+this+" which is to its target");
        }
        this.incoming_.add(r);
    }

    /** Add an outgoing relation to this pin. */
    public void addOutgoing(Relation r) {
        if (r.getOrigin() != this) {
            throw new RuntimeException("Adding outgoing relation "+r+" to "+this+" which is to its origin");
        }
        this.outgoing_.add(r);
    }

    /** Get the successors of this pin (pins to which it is directly connected). */
    public Collection<Pin> getSuccessorPins() {
        if (this.successors_ == null) {
            this.successors_ = new LinkedList<Pin>();
            for (Relation r : this.outgoing_) {
                this.successors_.add(r.getTarget());
            }
        }
        return this.successors_;
    }

    /** Get the predecessors of this pin (pins that are directly connected to it). */
    public Collection<Pin> getPredecessorPins() {
        if (this.predecessors_ == null) {
            this.predecessors_ = new LinkedList<Pin>();
            for (Relation r : this.incoming_) {
                this.predecessors_.add(r.getOrigin());
            }
        }
        return this.predecessors_;
    }
    
    @SuppressWarnings("static-method")
	public boolean isInputPin() {
    	return false;
    }
    
    @SuppressWarnings("static-method")
	public boolean isOutputPin() {
    	return false;
    }

    @Override
    public String toString() {
    	return (this.owner_ == null ? "<null>" : this.owner_.toString())
    			+ "." + this.getName();
    }
}
