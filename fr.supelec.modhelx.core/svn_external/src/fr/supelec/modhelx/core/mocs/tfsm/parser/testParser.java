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
import java.util.Vector;

public class testParser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {

            Vector<String> listOfInputEvents = new Vector<String>();
            listOfInputEvents.add("D2");
            //listOfInputEvents.add("evt1");
            listOfInputEvents.add("evt2");
            //			
            //			@SuppressWarnings("unused")
            //			String delay = Expression.getDelayGard("D 2.0");
            //			
            Boolean reponse = Expression.parse("(D 2)&evt2", listOfInputEvents);
            if (reponse)
                System.out.println("true");
            else
                System.out.println("false");

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
