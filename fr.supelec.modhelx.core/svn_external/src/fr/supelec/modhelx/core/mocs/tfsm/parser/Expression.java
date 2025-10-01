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

import java.text.ParseException;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.List;



/**
 * Represents boolean expressions.
 *
 */
public abstract class Expression {
    boolean isValid = false;
    public abstract Value eval(Map<String, Value> in) throws EvaluationException;

    private static int precedence(char op) {
        switch(op) {
            case '|': case '+': return 1;
            case '&': case '*': return 2;
            case '!': return 3;
            default: return -1;
        }
    }

    private static void pushVariable(Stack<Expression> output, String var) {
        output.push(new Variable(var));
    }

    private static boolean pushOperator(Stack<Expression> output, char op,List<String> listOfEvents) throws ParseException {
        boolean reponse = false;
        if(op == '|' || op == '&' || op == '+' || op == '*') {
            if(output.size() < 2) {
                throw new ParseException("Arity problem while processing binary operator " + op, 0);
            }
            Expression arg2 = output.pop();
            Expression arg1 = output.pop();

            Expression operator = null;
            switch(op) {
                case '|': case '+': operator = new OperatorOr(arg1, arg2); 
                if(((listOfEvents.contains(arg1.getName()) || listOfEvents.contains(arg2.getName())))
                        ||(arg1.getValid())
                        ||(arg2.getValid()))
                    reponse = true;								
                break;
                case '&': case '*': operator = new OperatorAnd(arg1, arg2); 
                if(listOfEvents.contains(arg1.getName()) && listOfEvents.contains(arg2.getName())
                        ||((arg1.getValid()) && listOfEvents.contains(arg2.getName()))
                        ||(arg2.getValid() && listOfEvents.contains(arg1.getName()))
                        || (arg1.getValid() && arg2.getValid()))
                    reponse = true;
                break;
                default:
                    throw new ParseException("Invalid operator \"" + op +"\"", 0);
                    // no default case, as it can NOT happen. Impossible things sometimes happen...
            }
            //			if (operator != null) {
            operator.setValid(reponse);
            //			}
            output.push(operator);
        } else if(op == '!') {
            if(output.empty()) throw new ParseException("Arity problem while processing unary operator " + op, 0);
            Expression exp = output.pop();
            Expression operator = new OperatorNot(exp);
            if(listOfEvents.contains(exp.getName()))
                operator.setValid(false);
            else
                operator.setValid(true);

            output.push(operator);
        } else if(op=='D') {
            if(output.empty()) throw new ParseException("Arity problem while processing unary operator " + op, 0);
            Expression timeOfDelay = output.pop();
            Expression operator = new OperatorDelay(timeOfDelay);
            if(listOfEvents.contains("D"+timeOfDelay.getName()))
            {
                operator.setValid(true);
                reponse = true;
            }


            else
                operator.setValid(false);

            output.push(operator);
        }
        else throw new ParseException("Unknown operator:" + op, 0);
        return reponse;
    }

    private static boolean isWhiteSpace(char c) {
        return c == '\u0020' || c == '\u00A0' || c == '\t';
    }


    private static boolean hasOnlyWhiteSpace(String s) {
        for(int i = 0; i < s.length() ; i++)
            if(! isWhiteSpace(s.charAt(i))) return false;
        return true;
    }


    public static boolean parse(String s,List<String> listOfEvents) throws ParseException {
        boolean reponse=false;
        Stack<Expression> output = new Stack<Expression>();
        Stack<Character> operator = new Stack<Character>();

        // An empty guard is always satisfied
        if (s.length() == 0) {
            return true;
        }

        StringTokenizer st = new StringTokenizer(s, " \u00A0\t&|!()+*", true);

        // Dijkstra's shunting yard algorithm
        while(st.hasMoreTokens()) {
            String t = st.nextToken();

            // skip whitespace
            if(hasOnlyWhiteSpace(t)) continue;

            // operator handling
            if("|".equals(t) || "&".equals(t) || "!".equals(t) ||
                    "+".equals(t) || "*".equals(t) || "D".equals(t)) {
                char o1 = t.charAt(0);
                int po1 = precedence(o1);
                while(! operator.isEmpty()) {
                    char o2 = operator.peek();
                    int po2 = precedence(o2);

                    if((o1=='|' || o1=='&' || o1=='+' || o1=='*') && po1 <= po2) {
                        operator.pop();
                        reponse = pushOperator(output, o2,listOfEvents);
                    } else break;
                }

                operator.push(o1);
                continue;
            }

            // left parenthesis
            if("(".equals(t)) {
                operator.push('(');
                continue;
            }

            // right parenthesis
            if(")".equals(t)) {
                while(true) {
                    if(operator.isEmpty()) throw new ParseException("Mismatched parentheses", 0);
                    char o = operator.pop();
                    if(o == '(') break;
                    else reponse = pushOperator(output, o,listOfEvents);
                }
                continue;
            }

            // symbol
            pushVariable(output, t);
        }

        while(! operator.isEmpty()) {
            char o = operator.pop();
            if(o == '(' || o == ')') throw new ParseException("Mismatched parentheses", 0);
            reponse = pushOperator(output, o,listOfEvents);
        }

        if(output.size() != 1) throw new ParseException("Malformed expression", 0);
        if(output.size()==1) 
        {
            Expression ex = output.peek();
            if(listOfEvents.contains(ex.getName()))
                reponse = true;
        }
        //System.out.println(output.toString());
        return reponse;
    }

    public void setValid(boolean reponse)
    {
        this.isValid = reponse;
    }

    @SuppressWarnings("static-method")
	public String getName()
    {
        return "";
    }

    public boolean getValid(){
        return this.isValid;
    }
    public static String getDelayGard(String gard)
    {
        //		Vector<OperatorDelay> retour = new Vector<OperatorDelay>();
        StringTokenizer st = new StringTokenizer(gard, " \u00A0\t&|!()+*", false);
        //String[] result = gard.split("()\\s");
        //for (int x=0; x<result.length; x++)
        while(st.hasMoreElements())
        {
            String t = st.nextToken();
            if(t.equals("D"))
            {
                //				String temp = st.nextToken();
                //	        	 retour.add(new OperatorDelay(new Variable(st.nextToken())));
                return st.nextToken();
            }
        }

        return null;
    }
}
