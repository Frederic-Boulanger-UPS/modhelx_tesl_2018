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

package fr.supelec.modhelx.core.mocs.de;

import fr.supelec.modhelx.core.abstractsemantics.ModelOfComputationImpl;
import fr.supelec.modhelx.core.abstractsemantics.NamedEntity;
import fr.supelec.modhelx.core.abstractsemantics.Pin;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.RoundDouble;

/**
 * AbstractDEMoC declares the common abstract semantics of Discrete Events MoCs.
 * It can be specialized for implementing various flavors of DE.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public abstract class AbstractDEMoC extends ModelOfComputationImpl<Double> {
    /** Name of the property of pin that do not depend instantaneously on the behavior of their block.*/
    public static final String NID_PROPERTY = "NotInstantaneouslyDependent";
    /** The observation clock of this MoC. */
    protected Clock<Double> de_clock_;
    /** The current DE time. */
    protected Double current_time_;

    public AbstractDEMoC(String name) {
        super(name);
        this.de_clock_ = Clock.createClock(Double.class, this.getName() + " clock", new RoundDouble());
    }

    /** Set pin <code>p</code> as not instantaneously dependent. */
    public static void setNotInstantaneouslyDependent(Pin p) {
        ((NamedEntity) p).setProperty(NID_PROPERTY, true);
    }

    /** Set pin <code>p</code> as instantaneously dependent (default). */
    public static void removeNotInstantaneouslyDependent(Pin p) {
        ((NamedEntity) p).removeProperty(NID_PROPERTY);
    }

    /** Tell if pin <code>p</code> is instantaneously dependent. */
    public static boolean isNotInstantaneouslyDependent(Pin p) {
        Boolean isnid = ((NamedEntity) p).getProperty(NID_PROPERTY, Boolean.class);
        return (isnid != null) && isnid;
    }

    /** Get the current time in this MoC. */
    @Override
    public Double getCurrentTime() {
        return this.current_time_;
    }

    @Override
    public Clock<Double> getClock() {
        return this.de_clock_;
    }
}
