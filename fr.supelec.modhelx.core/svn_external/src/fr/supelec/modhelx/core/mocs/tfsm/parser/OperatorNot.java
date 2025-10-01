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

package fr.supelec.modhelx.core.mocs.tfsm.parser;

import java.util.Map;

/**
 * Represents the NOT boolean operator.
 *
 */
public class OperatorNot extends Expression {
    private final Expression e;

    public OperatorNot(Expression e) {
        this.e = e;
    }

    @Override
    public Value eval(Map<String, Value> in) throws EvaluationException {
        //		return e.eval(in).not();
        return null;
    }

    @Override
    public String toString() {
        return "( ! " + this.e + ")";
    }
}