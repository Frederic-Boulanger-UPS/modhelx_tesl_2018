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

import fr.supelec.tesl.core.Unit;
import fr.supelec.tesl.core.UnitCalc;


/**
 * An ASAPClock is a kind of driving clock that always has a tick as soon as possible
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class ASAPClock extends DrivingClock<Unit> {
    /** Thread used to notify the execution engine. */
    private class ASAPThread extends Thread {
        /** Should the thread continue running? */
        public  boolean run;

        public ASAPThread() {
            this.run = false;
        }

        public void cancel() {
            this.interrupt();
        }

        @Override
        public void run() {
            this.run = true;
            while (this.run) {
                try {
                    // Wait for the execution to be waiting for us
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    // Interrupt means check again if we should run
                    continue;
                }
                if (ASAPClock.this.listener_ != null) {
                    // Notify the listener execution engine that we have a tick
                    synchronized (ASAPClock.this.listener_) {
                        ASAPClock.this.listener_.notify();
                    }
                }
            }
        }
    }

    private ASAPThread mythread_;

    public ASAPClock(String name) {
        super(name, new UnitCalc());
        // This clock always has a "now" tick
        newTick().setTagValue(Unit.getInstance()).setNow(true);
        this.mythread_ = new ASAPThread();
        this.mythread_.start();
    }

    @Override
    public void foresee() {
        newTick(Unit.getInstance());
    }

    @Override
    public void backToPresent() {
        // Nothing to do, backup/restore will take care of it
    }

    @Override
    public void activate() {
        synchronized (this.mythread_) {
            if (getTicks().size() == 0) {
                newTick(Unit.getInstance());
            }
            getTick(0).setNow(true);
            this.mythread_.notify();
        }
    }

    @Override
    public void cancel() {
        this.mythread_.cancel();
    }

    @Override
    public void wrapup() {
        this.mythread_.run = false;
        this.mythread_.interrupt();

    }
}
