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

import java.util.HashMap;
import java.util.Map;

import fr.supelec.tesl.logging.Logger;

/**
 * Common default implementation of a model of computation features.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public abstract class ModelOfComputationImpl<T extends Comparable<? super T>> extends ModelOfComputation<T> {	
    /** Association of values to tokens. */
    Map<Token, Object> tokenValues_;

    public ModelOfComputationImpl(String name) {
        super(name);
        this.tokenValues_ = new HashMap<Token, Object>();
    }

    public Logger getLogger() {
        return getEngine().getLogger();
    }

    @Override
    public Object getTokenValue(Token t) {
        return this.tokenValues_.get(t);
    }

    @Override
    public void setTokenValue(Token t, Object val) {
        this.tokenValues_.put(t, val);
    }

    @Override
    public Token createToken(Object val) {
        Token tok = new Token(this);
        setTokenValue(tok, val);
        return tok;
    }

    @Override
    public Token duplicateToken(Token tok) {
        Token ntok = new Token(this);
        setTokenValue(ntok, getTokenValue(tok));
        return ntok;
    }

    private void log(String kind, String phase) {
        getLogger().log(kind, phase, getName());
    }

    @Override
    public void prep(BlockStructure s) {
        log("info", "------ Prep: ");
        s.prep();
    }

    @Override
    public void setup(BlockStructure s) {
        log("info", "------ Setup: ");
        s.setup();
    }

    @Override
    public void startOfSnapshot(BlockStructure s) {
        log("info", "------ Start of snapshot: ");
        s.startOfSnapshot();
    }

    @Override
    public void reset(BlockStructure s) {
        log("info", "------ Reset: ");
        s.reset();
    }

    @Override
    public boolean validate(BlockStructure s) {
        log("info", "------ Validate: ");
        return s.validate();
    }

    @Override
    public void endOfSnapshot(BlockStructure s) {
        log("info", "------ End of snapshot: ");
        s.endOfSnapshot();
    }

    @Override
    public void emitObservationRequests(BlockStructure s) {
        log("info", "------ Observation requests: ");
        s.emitObservationRequests();
    }

    @Override
    public void wrapup(BlockStructure s) {
        log("info", "------ Wrapup: ");
        s.wrapup();
    }
}
