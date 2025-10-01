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

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Represents the AND operator in boolean expressions.
 *
 */
public class OperatorAnd extends BinaryOperator {
    public OperatorAnd(List<Expression> args) {
        super(args);
    }

    public OperatorAnd(Expression a, Expression b) {
        this(Arrays.asList(new Expression[] {a, b}));
    }

    @Override
    public Value eval(Map<String, Value> in) throws EvaluationException {
        /**
         * Calculate the AND of known values.
         * 
         * - if there is no unknown value, then this is the final result
         * - if there is an unknown value
         *     - if the AND of defined values is FALSE, the the result is FALSE
         *     - otherwise the result is UNKNOWN
         *     
         * The for loop MAY BE LAZY, because if the result is FALSE or ERROR we
         * don't care about undefined values
         */

        Value res = Value.TRUE;
        boolean anUnknownValue = false;

        for(Expression a : this.args) {
            Value av = a.eval(in);

            if(av == Value.FALSE) { res = Value.FALSE; break; }
            if(av == Value.ERROR) { res = Value.ERROR; break; }
            if(av == Value.UNKNOWN) { anUnknownValue = true; }
        }

        if(anUnknownValue) {
            return res == Value.FALSE ? Value.FALSE : Value.UNKNOWN;
        } else {
            return res;
        }
    }

    @Override
    protected String getOp() {
        return "&";
    }

}