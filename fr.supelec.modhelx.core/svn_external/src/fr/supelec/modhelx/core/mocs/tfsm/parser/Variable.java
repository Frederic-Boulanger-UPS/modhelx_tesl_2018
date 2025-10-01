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
 * Represents a variable in a boolean expression.
 *
 */
public class Variable extends Expression {
    String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Value eval(Map<String, Value> in) throws EvaluationException {
        Value val = in.get(this.name);
        if(val != null) return val;
        else throw new EvaluationException("No value for variable " + this.name);
    }

    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public String toString() {
        return "`" + this.name + "`";
    }

}