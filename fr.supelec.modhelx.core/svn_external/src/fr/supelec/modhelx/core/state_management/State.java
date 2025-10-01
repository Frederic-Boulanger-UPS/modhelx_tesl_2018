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

package fr.supelec.modhelx.core.state_management;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.supelec.modhelx.core.abstractsemantics.NamedEntity;

/**
 * A State manages the state of a NamedEntity, which is composed of its field of type <code>StateValue</code>.
 * A State can also be used to initialize the field of type <code>Value</code> of a NamedEntity.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class State {
    /** The NamedEntity which owns the Attributes managed by this State. */
    private NamedEntity owner_;
    /** A name->attribute map of the state values of the owner. */
    private HashMap<String, Field> statevalues_;
    private HashMap<String, Field> snap_statevalues_;

    /** Get all the fields of objects of a class, even inherited ones. */
    private static List<Field> getAllFields(Class<?> c) {
        List<Field> fields = new LinkedList<Field>(Arrays.asList(c.getDeclaredFields()));
        Class<?> s = c.getSuperclass();
        while (s != null) {
            fields.addAll(Arrays.asList(s.getDeclaredFields()));
            s = s.getSuperclass();
        }
        return fields;
    }

    /** Create a State for handling the state values of <code>e</code>. 
     *  @param e the entity to handle
     */
    public State(NamedEntity e) {
        this.owner_ = e;
        // Examine all fields (including inherited ones)
        List<Field> fields = getAllFields(e.getClass());
        this.statevalues_ = new HashMap<String, Field>();
        this.snap_statevalues_ = new HashMap<String, Field>();
        for (Field field : fields) {
            // Get only the Fields that are Attributes<T>
            if (StateValue.class.isAssignableFrom(field.getType())) {
                if (field.getAnnotation(SnapshotAttribute.class) != null) {
                    this.snap_statevalues_.put(field.getName(), field);					
                } else {
                    this.statevalues_.put(field.getName(), field);
                }
                field.setAccessible(true);  // Make field accessible even if private
            }
        }
    }

    /** Revert the regular state values to their value after the last <code>commit</code> operation. */
    public void revert() {
        for (Field attr : this.statevalues_.values()) {
            try {
                ((StateValue)(attr.get(this.owner_))).revert();
            } catch (Exception e) {
                System.err.println("## Could not invoke 'reset()' method on state value '" + attr + "' of '" + this.owner_ + "', aborting");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    /** Revert the snapshot state values to their value after the last <code>commit</code> operation. */
    public void revertSnap() {
        for (Field attr : this.snap_statevalues_.values()) {
            try {
                ((StateValue)(attr.get(this.owner_))).revert();
            } catch (Exception e) {
                System.err.println("## Could not invoke 'reset()' method on state value '" + attr + "' of '" + this.owner_ + "', aborting");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    /** Commit the changes to this State. */
    public void commit() {
        commitValues(this.statevalues_.values());
        commitValues(this.snap_statevalues_.values());
    }

    private void commitValues(Collection<Field> fields) {
        for (Field attr : fields) {
            try {
                ((StateValue)(attr.get(this.owner_))).commit();
            } catch (Exception e) {
                System.err.println("## Could not invoke 'updatePermanentState()' method on state value '" + attr + "' of '" + this.owner_ + "', aborting");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("State of " + this.owner_.getName());
        String newline = System.getProperty("line.separator");
        for (Map.Entry<String, Field> e : this.statevalues_.entrySet()) {
            buf.append(newline);
            buf.append(e.getKey());
            buf.append(" = ");
            try {
                buf.append(e.getValue().get(this.owner_));
            } catch (Exception exc) {
                buf.append("# exception during access #");
            }
        }
        return buf.toString();
    }

    /** Initialize the fields of type <code>Value</code> of the NamedEntity owning this state from its properties.
     *  By default, each Value is initialized from the property by the same name.
     *  If some values should be initialized from properties with a different name,
     *  the mapping from value name to property name can be given using the <code>assignments</code>
     *  parameter. Each assignment String is in the form "&lt;value name&gt;=&lt;property name&gt;".
     *  
     *  @param assignments a list of strings in the form "&lt;value name&gt;=&lt;property name&lt;" to set from 
     *  which property a value will be initialized. Values whose name
     *  does not appear in <code>assignments</code> will be initialized from properties which have the same 
     *  name as the value, if such a property exists.
     */
    public void initFromProperties(String ... assignments) {
        HashMap<String, String> aliases = new HashMap<String, String>();
        // First, interpret the assignments
        for (String assignment : assignments) {
            String parts[] = assignment.split("=");
            if (parts.length != 2) {
                throw new Error("Property to attribute assignment must be of the form <attr name>=<prop name>");
            }
            aliases.put(parts[0], parts[1]);
        }

        List<Field> fields = getAllFields(this.owner_.getClass());
        for (Field field : fields) {
            // Handle both Attributes and Parameters by selecting fields of type Storage
            if (Value.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);  // Make field accessible even if private
                String attrName = field.getName();
                String propName = aliases.get(attrName);
                if (propName  == null) {
                    propName  = attrName;
                }
                try {
                    ((Value<?>)(field.get(this.owner_))).initFromProperty(this.owner_, propName);
                } catch (Exception e) {
                    System.err.println("## Could not invoke 'initFromProperty()' method on attribute '"
                            + field.getName() + "' of '" + this.owner_.getName() + "', aborting");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }
}
