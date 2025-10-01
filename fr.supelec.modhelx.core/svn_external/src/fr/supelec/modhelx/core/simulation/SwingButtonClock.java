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

package fr.supelec.modhelx.core.simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * A SwingButtonClock is an event feeder clock that ticks when a Swing button is pressed.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class SwingButtonClock extends EventFeederClock implements ActionListener {
    /** the swing button for this clock. */
    private JButton button_;

    /**
     * Build a new SwingButton clock
     * @param name the name of the clock
     * @param buttonName the name of the button
     */
    public SwingButtonClock(String name, String buttonName) {
        super(name);
        // Create the button
        this.button_ = new JButton(buttonName);
        // and register as an action listener to be able to notify the engine
        this.button_.addActionListener(this);
    }

    /** Get the Swing button associated to this clock. */
    public JButton getButton() {
        return this.button_;
    }

    /** Called when the button is pressed.
     *  Sets the tag of tick to the current system time in milliseconds, and sets the tick to "now".
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        eventOccurred();
    }

    @Override
    public void activate() {
        this.button_.setEnabled(true);
    }

    /** Disable the button when the simulation is finished. */
    @Override
    public void wrapup() {
        this.button_.setEnabled(false);
    }
}
