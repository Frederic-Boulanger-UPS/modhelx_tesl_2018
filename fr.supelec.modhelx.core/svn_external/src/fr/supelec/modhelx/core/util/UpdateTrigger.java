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

package fr.supelec.modhelx.core.util;

import fr.supelec.modhelx.core.abstractsemantics.ObservableEntity;

/**
 * An UpdateTrigger memorizes the fact that an observable entity should be updated.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class UpdateTrigger {
    /** The entity that should be updated. */
    private ObservableEntity entity_to_update_;

    /** Build a new UpdateTrigger for entity <code>e</code>. */
    public UpdateTrigger(ObservableEntity e) {
        this.entity_to_update_ = e;
    }

    /** Get the entity that should be updated. */
    public ObservableEntity getEntity() {
        return this.entity_to_update_;
    }

    /** Prepare the update of the entity (MoC dependent). */
    public void prepareUpdate() {
        /* Nothing to do here. */
    }

    /** Update the entity. */
    public void update() {
        this.entity_to_update_.update();
    }

    @Override
    public String toString() {
        return "UpdateTrigger of \"" + this.entity_to_update_.getName() + "\"";
    }
}
