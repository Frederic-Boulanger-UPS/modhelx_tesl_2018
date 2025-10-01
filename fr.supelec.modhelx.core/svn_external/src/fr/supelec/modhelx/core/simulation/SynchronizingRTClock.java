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

import fr.supelec.tesl.core.LongCalc;
import fr.supelec.tesl.core.Tick;

/**
 * A driving clock that ticks on real time.
 * If you put a tick on this clock, it will become "now" at the time of its tag. 
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class SynchronizingRTClock extends DrivingClock<Long> {
    /**
     * The thread used to notify the execution engine when a tick is produced on the clock.
     * 
     * @author frederic.boulanger@supelec.fr
     *
     */
    private class SynchronizingRTThread extends Thread {
        /** Should the thread keep running? */
        public  boolean run;

        public SynchronizingRTThread() {
            this.run = false;
        }

        public void cancel() {
            this.interrupt();
        }

        @SuppressWarnings("synthetic-access")
		@Override
        public void run() {
            this.run = true;
            while (this.run) {
                try {
                    // Wait for the engine to be waiting for us.
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    // Interrupt means check again if we should run
                    continue;
                }
                if (SynchronizingRTClock.this.listener_ != null) {
                    // Compute the delay to wait to reach the next tick of the clock
                    long delay;
                    do {
                        long next_time = SynchronizingRTClock.this.getNextTime();
                        long rt = System.currentTimeMillis();
                        delay = tagDifference(next_time, rt);
                        if (delay < 0) {
                            System.err.println("## Warning: missed sync with real time at " + next_time
                                    + " (now is " + rt + ", which is " + (-delay) + " later)");
                            SynchronizingRTClock.this.adjustTime(-delay + 100);
                        }
                    } while (delay < 0);
                    try {
                        // Sleep until this time has come
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        // Interrupt means check again if we should run
                        continue;
                    }
                    synchronized (SynchronizingRTClock.this.listener_) {
                        // Create the now tick, this will notify the exec engine
                        SynchronizingRTClock.this.newTick(SynchronizingRTClock.this.next_tick_time_).setNow(true);
                    }
                }
            }
        }
    }

    private SynchronizingRTThread mythread_;
    private long offset_;
    private Long next_tick_time_;

    public SynchronizingRTClock(String name) {
        super(name, new LongCalc());
        this.offset_ = 0;
        this.mythread_ = new SynchronizingRTThread();
        this.mythread_.start();
    }

    public static long getRealTime() {
        return System.currentTimeMillis();
    }

    /** Compute the time for the next tick.
     *  This must be corrected by an offset which depends on the current time 
     *  on the machine when the simulation was started.
     */
    public Long getNextTime() {
        if (this.next_tick_time_ != null) {
            return this.next_tick_time_ + this.offset_;
        } else {
            return null;
        }
    }

    /** Adjust the reference time when missing real time dead lines. */
    public void adjustTime(long delta) {
        this.offset_ += delta;
    }

    @Override
    public void foresee() {
        // Nothing special to do, if we have a tick, it may happen any time,
        // else, nothing will happen.
    }

    @Override
    public void backToPresent() {
        // Memorize the tag of the tick that was created during 
        // the foresee solving phase as the next time we should tick
        Tick<Long> next_tick = this.getFirstTaggedTick();
        if (next_tick != null) {
            this.next_tick_time_ = next_tick.getTagValue();
        }
    }

    @Override
    public void activate() {
        Long next_time = getNextTime();
        if (next_time != null) {
            synchronized (this.mythread_) {
                this.mythread_.notify();
            }
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
