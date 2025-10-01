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

import java.util.List;

/**
 * Represents a binary boolean operator.
 *
 */
public abstract class BinaryOperator extends Expression {
    protected List<Expression> args;

    protected BinaryOperator(List<Expression> args) {
        this.args = args;

    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("(");
        for(int i=0; i<this.args.size()-1; i++) {
            res.append(this.args.get(i)).append(" ").append(getOp()).append(" ");
        }

        return res.append(this.args.get(this.args.size()-1)).append(")").toString();
    }

    protected abstract String getOp();

}
