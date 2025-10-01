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
 * Represents the OR operator in boolean expressions.
 *
 */
public class OperatorOr extends BinaryOperator {
    public OperatorOr(List<Expression> args) {
        super(args);
    }

    public OperatorOr(Expression a, Expression b) {
        this(Arrays.asList(new Expression[] {a, b}));
    }

    @Override
    public Value eval(Map<String, Value> in) throws EvaluationException {
        /**
         * Calculate the OR of known values.
         * 
         * - if there is no unknown value, then this is the final result
         * - if there is an unknown value
         *     - if the OR of defined values is TRUE, the the result is TRUE
         *     - otherwise the result is UNKNOWN
         *     
         * The for loop MAY BE LAZY, because if the result is TRUE or ERROR we
         * don't care about undefined values
         */

        Value res = Value.FALSE;
        boolean anUnknownValue = false;

        for(Expression a : this.args) {
            Value av = a.eval(in);

            if(av == Value.TRUE) { res = Value.TRUE; break; }
            if(av == Value.ERROR) { res = Value.ERROR; break; }
            if(av == Value.UNKNOWN) { anUnknownValue = true; }
        }

        if(anUnknownValue) {
            return res == Value.TRUE ? Value.TRUE : Value.UNKNOWN;
        } else {
            return res;
        }
    }

    @Override
    protected String getOp() {
        return "|";
    }

}
