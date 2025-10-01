/*
 * This file is part of TESL.
 *
 * TESL is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * TESL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with TESL. If not, see <http://opensource.org/licenses/EPL-1.0>.
 *
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 *
 */

package fr.supelec.tesl.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A clock with tags of type T.
 */
public class Clock<T extends Comparable<? super T>> {
    private Map<Tick<T>, Tag<T>> tags_;
    private TagCalculus<T> tag_calculus_;
    private List<Tick<T>> ticks_;
    private Tick<T> now_;
    private boolean greedy_;
    private String name_;
    private ClockSet solver_;

    /*@ A backup of a clock */
    private class ClockBackup implements ClockBackupInterface<T> {
        /*@ list of ticks */
        public List<Tick<T>> ticks_backup_;
        /*@ Tags of the ticks */
        public Map<Tick<T>, Tag<T>> tags_backup_;
        /*@ Tick which is now */
        public Tick<T> now_backup_;
        /*@ Is this clock greedy? */
        public boolean greedy_backup_;

        @SuppressWarnings("synthetic-access")
        public ClockBackup() {
            this.ticks_backup_ = new LinkedList<Tick<T>>();
            this.tags_backup_ = new HashMap<Tick<T>, Tag<T>>();
            for (Tick<T> t : Clock.this.getTicks()) {
                Tick<T> copy = Clock.this.copyTick(t);
                this.ticks_backup_.add(copy);
                if (t == Clock.this.now_) {
                    this.now_backup_ = copy;
                }
                Tag<T> tag = Clock.this.getTag(t);
                if (tag != null) {
                    this.tags_backup_.put(copy, tag.copy());
                }
            }
            this.greedy_backup_ = Clock.this.greedy_;
        }

        @Override
        public void restore() {
            Clock.this.restore(this);
        }
    }

    @SuppressWarnings("unchecked")
    //@ Create a K-Clock, type must be K.class
    public static <K extends Comparable<? super K>> Clock<K> createClock(Class<K> type, String name, TagCalculus<K> calc, boolean greedy) {
        if (type.equals(Unit.class)) {
        	// UnitClock is a particular implementation of Clock<Unit>
            return (Clock<K>) new UnitClock(name, (TagCalculus<Unit>) calc, greedy);
        } else {
            return new Clock<K>(name, calc, greedy);
        }
    }

    //@ Create a greedy K-Clock, type must be K.class
    public static <K extends Comparable<? super K>> Clock<K> createClock(Class<K> type, String name, TagCalculus<K> calc) {
        return createClock(type, name, calc, true);
    }

    //@ Create a new K-Clock with tag calculus calc
    protected Clock(String name, TagCalculus<T> calc, boolean greedy) {
        this.name_ = name;
        this.tags_ = new HashMap<Tick<T>, Tag<T>>();
        this.tag_calculus_ = calc;
        this.ticks_ = new LinkedList<Tick<T>>();
        this.greedy_ = greedy;
    }

    //@ Create a new greedy K-Clock with tag calculus calc
    protected Clock(String name, TagCalculus<T> calc) {
        this(name, calc, true);
    }

    //@ Set the solver to which this clock belongs
    public ClockSet setSolver(ClockSet cs) {
        this.solver_ = cs;
        return cs;
    }

    //@ Get the solver of this clock
    public ClockSet getSolver() {
        return this.solver_;
    }

    //@ Get the current time on this clock (even if it has no tick now)
    public Tag<T> getCurrentTag() {
        if (this.solver_ != null) {
            return (Tag<T>) this.solver_.getCurrentTag(this);
        } else {
            return null;
        }
    }

    //@ Version of getCurrentTag for erasing type parameters with Xtend
    public static Tag<?> getCurrentTag_erased(Clock<?> c) {
    	return c.getCurrentTag();
    }
    
    public static Object getCurrentTagValue_erased(Clock<?> c) {
    	Tag<?> tag = c.getCurrentTag();
    	if (tag != null) {
    		return c.getCurrentTag().getValue();
    	} else {
    		return null;
    	}
    }
    
    //@ Get a copy of this clock
    public Clock<T> getCopy(String name) {
        return new Clock<T>(name, this.tag_calculus_, this.greedy_);
    }
    //@ Make this clock imply clock <code>slave</code>.
    @SuppressWarnings("unchecked")
    public <S extends Comparable<? super S>> Implication<T,S> implies(Clock<S> slave) {
        return (Implication<T, S>) this.solver_.addImplicationRelation(new Implication<T, S>(this, slave));
    }

    public Implication<?,?> implies_erased(Clock<?> slave) {
    	return implies(slave);
    }

    //@ Make this clock imply clock <code>slave</code> when clock <code>when</code> ticks.
    @SuppressWarnings("unchecked")
    public <W extends Comparable<? super W>, S extends Comparable<? super S>> WhenImplication<T,W,S> impliesWhen(Clock<W> when, Clock<S> slave) {
        return (WhenImplication<T,W,S>) this.solver_.addImplicationRelation(new WhenImplication<T,W,S>(this, when, slave));
    }

    public WhenImplication<?,?,?> impliesWhen_erased(Clock<?> when, Clock<?> slave) {
    	return impliesWhen(when, slave);
    }

    //@ Make this clock imply clock <code>slave</code> when clock <code>when</code> does not tick.
    @SuppressWarnings("unchecked")
    public <W extends Comparable<? super W>, S extends Comparable<? super S>> WhenNotImplication<T,W,S> impliesWhenNot(Clock<W> when, Clock<S> slave) {
        return (WhenNotImplication<T,W,S>) this.solver_.addImplicationRelation(new WhenNotImplication<T,W,S>(this, when, slave));
    }

    public WhenNotImplication<?,?,?> impliesWhenNot_erased(Clock<?> when, Clock<?> slave) {
    	return impliesWhenNot(when, slave);
    }

    //@ Make this clock imply clock <code>slave</code> with delay <code>delay</code> counted on clock <code>counting</code>.
    @SuppressWarnings("unchecked")
    public <S extends Comparable<? super S>, C extends Comparable<? super C>>
    DelayedImplication<T,C,S> impliesWithDelay(Clock<S> slave, Clock<C> counting, int delay, boolean immediate, boolean reset) {
        return (DelayedImplication<T,C,S>) this.solver_.addImplicationRelation(
                new DelayedImplication<T, C, S>(this, counting, slave, delay, immediate, reset)
                );
    }

    //@ Version of impliesWithDelay with erased type parameters for Xtend
    public DelayedImplication<?,?,?> impliesWithDelay_erased(Clock<?> slave, Clock<?> counting, int delay, boolean immediate, boolean reset) {
    	return impliesWithDelay(slave, counting, delay, immediate, reset);
    }

    //@ Make this clock imply clock <code>slave</code> with delay <code>delay</code> counted on clock <code>counting</code>.
    @SuppressWarnings("unchecked")
    public <S extends Comparable<? super S>, C extends Comparable<? super C>>
    DelayedImplication<T,C,S> impliesWithDelay(Clock<S> slave, Clock<C> counting, int delay, boolean immediate) {
        return (DelayedImplication<T,C,S>) this.solver_.addImplicationRelation(
                new DelayedImplication<T, C, S>(this, counting, slave, delay, immediate)
                );
    }

    //@ Helper for creating a non immediate delayed implication.
    public <S extends Comparable<? super S>, C extends Comparable<? super C>>
    DelayedImplication<T,C,S> impliesWithDelay(Clock<S> slave, Clock<C> counting, int delay) {
        return this.impliesWithDelay(slave, counting, delay, false);
    }

    //@ Make this clock imply clock <code>slave</code> through a filtering relation.
    @SuppressWarnings("unchecked")
    public <S extends Comparable<? super S>>
    FilteredImplication<T,S> impliesThroughFilter(Clock<S> slave, int skip, int count, int repskip, int repcount) {
        return (FilteredImplication<T,S>) this.solver_.addImplicationRelation(
                new FilteredImplication<T,S>(this, slave, skip, count, repskip, repcount)
                );
    }

    public FilteredImplication<?,?> impliesThroughFilter_erased(Clock<?> slave, int skip, int count, int repskip, int repcount) {
    	return impliesThroughFilter(slave, skip, count, repskip, repcount);
    }

    /** Make this clock sustain clock <code>slave</code> between occurrences of <code>start</code> and <code>stop</code>.
     *
     * @param slave the slave clock
     * @param start the clock that starts the sustaining of slave
     * @param stop  the clock that stops the sustaining of slave
     * @param immediate if true, slave has a tick when the master and start occur at the same time
     * @param weak if true, slave does not get a tick when stop occurs at the same time as the master
     */
    @SuppressWarnings("unchecked")
    public <M2 extends Comparable<? super M2>, M3 extends Comparable<? super M3>, S extends Comparable<? super S>>
    SustainedImplication<T,M2,M3,S> sustains(Clock<S> slave, Clock<M2> start, Clock<M3> stop, boolean immediate, boolean weak) {
        return (SustainedImplication<T,M2,M3,S>) this.solver_.addImplicationRelation(
                new SustainedImplication<T,M2,M3,S>(this, start, stop, slave, immediate, weak)
                );
    }

    public SustainedImplication<?,?,?,?> sustains_erased(Clock<?> slave, Clock<?> start, Clock<?> stop, boolean immediate, boolean weak) {
    	return sustains(slave, start, stop, immediate, weak);
    }

    //@ Helper for creating a strong delayed sustain
    public <M2 extends Comparable<? super M2>, M3 extends Comparable<? super M3>, S extends Comparable<? super S>>
    SustainedImplication<T,M2,M3,S> sustains(Clock<S> slave, Clock<M2> start, Clock<M3> stop) {
        return this.sustains(slave, start, stop, false, false);
    }

    //@ Helper for creating a time delayed with reset implication
    @SuppressWarnings("unchecked")
    public <M extends Comparable<? super M>, R extends Comparable<? super R>, S extends Comparable<? super S>>
    TimeDelayedImplication<T, M, R, S> impliesWithTimeDelay(Clock<R> reset, Clock<S> slave, Clock<M> measuring, M delay, boolean use_ruler) {
        return (TimeDelayedImplication<T, M, R, S>) this.solver_.addImplicationRelation(
                new TimeDelayedImplication<T, M, R, S>(this, measuring, reset, slave, delay, use_ruler)
                );
    }

    public <M extends Comparable<? super M>> TimeDelayedImplication<?,M,?,?> impliesWithTimeDelay_erased(Clock<?> reset, Clock<?> slave, Clock<M> measuring, M delay, boolean use_ruler) {
    	return impliesWithTimeDelay(reset, slave, measuring, delay, use_ruler);
    }

    //@ Helper for creating a time delayed implication without reset
    @SuppressWarnings("unchecked")
	public <M extends Comparable<? super M>, S extends Comparable<? super S>>
    TimeDelayedImplication<T, M, Unit, S> impliesWithTimeDelay(Clock<S> slave, Clock<M> measuring, M delay, boolean use_ruler) {
        return (TimeDelayedImplication<T, M, Unit, S>) this.solver_.addImplicationRelation(
                new TimeDelayedImplication<T, M, Unit, S>(this, measuring, (UnitClock)null, slave, delay, use_ruler)
                );
    }

    //@ Helper for creating a time delayed implication without reset and with a distinct hidden ruler clock
    public <M extends Comparable<? super M>, S extends Comparable<? super S>>
    TimeDelayedImplication<T, M, Unit, S> impliesWithTimeDelay(Clock<S> slave, Clock<M> measuring, M delay) {
        return impliesWithTimeDelay((UnitClock)null, slave, measuring, delay, true);
    }

    //@ Deprecated, use impliesThroughFilter instead
    @SuppressWarnings("unchecked")
    @Deprecated
    public <S extends Comparable<? super S>> FilteredImplication<T,S> filteredImplies(Clock<S> slave, int skip, int keep, int repSkip, int repKeep) {
        return (FilteredImplication<T, S>) this.solver_.addImplicationRelation(new FilteredImplication<T, S>(this, slave, skip, keep, repSkip, repKeep));
    }

    //@ Deprecated, use createSlaveImplication instead
    @Deprecated
    public <U extends Comparable<? super U>> Implication<T, U> createMasterImplication(Clock<U> slave) {
        return new Implication<T, U>(this, slave);
    }

    //@ Create an implication relation from master to this clock
    public <U extends Comparable<? super U>> Implication<U, T> createSlaveImplication(Clock<U> master) {
        return new Implication<U, T>(master, this);
    }

    //@ Make awaited imply this clock through an await implication with reset
    @SuppressWarnings("unchecked")
    public <R extends Comparable<? super R>> AwaitImplication<T, R> awaits(Clock<R> reset, boolean weak, Clock<?>... awaited) {
        return (AwaitImplication<T, R>) this.solver_.addImplicationRelation(new AwaitImplication<T, R>(this, reset, weak, awaited));
    }

    public AwaitImplication<?,?> awaits_erased(Clock<?> reset, boolean weak, Clock<?>... awaited) {
    	return awaits(reset, weak, awaited);
    }

    //@ Make this clock have the same tags as <code>clock</code>.
    public SameTags<T> sameTags(Clock<T> clock) throws Exception {
        return (SameTags<T>) this.solver_.addTagRelation(new SameTags<T>(this, clock));
    }

    @SuppressWarnings("unchecked")
    public SameTags<T> sameTags_erased(Clock<?> clock) throws Exception {
        return (SameTags<T>) this.solver_.addTagRelation(new SameTags<T>(this, (Clock<T>) clock));
    }
    
    /** Create an affine relation between the tags of this clock and the tags as <code>clock</code>.
     *  Tags on <code>clock</code> are <code>coeff</code> * tags on this + <code>offset</code>.
     * @param clock the clock from which to compute tags
     * @param coeff the coefficient of the affine relation
     * @param offset the offset of the affine relation
     * @return the AffineRelation from this clock to <code>clock</code>
     * @throws Exception 
     */
    //	public AffineTags<T> affineTags(TagCalculus<T> calc, Clock<T> clock, T coeff, T offset) {
    //		return (AffineTags<T>) this.owner_.addTagRelation(new AffineTags<T>(calc, this, clock, coeff, offset));
    //	}
    public AffineTags<T> affineTags(Clock<T> clock, T coeff, T offset) throws Exception {
        return (AffineTags<T>) this.solver_.addTagRelation(new AffineTags<T>(this, clock, coeff, offset));
    }

    public PowerTags<T> powerTags(Clock<T> clock, int power, T coeff, T offset) throws Exception {
        return (PowerTags<T>) this.solver_.addTagRelation(new PowerTags<T>(this, clock, power, coeff, offset));
    }

    //@ Set the greedy state of this clock
    public void setGreedy(boolean greedy) {
        this.greedy_ = greedy;
    }

    //@ Is this clock greedy?
    public boolean isGreedy() {
        return this.greedy_;
    }

    //@ Get the tag calculus used by this clock
    public TagCalculus<T> getTagCalculus() {
        return this.tag_calculus_;
    }

    //@ Log a message, if possible
    public void log(String kind, Object message) {
        ClockSet solver = this.getSolver();
        if (solver != null) {  // In case the clock is not yet registered with a solver
            solver.getLogger().log(kind,  message);
        }
    }

    //@ Compute the sum of two tags on this clock
    public T tagSum(final T t1, final T t2) {
        final T r = this.tag_calculus_.add(t1, t2);
        log("tags", new Object() {
            @Override
            public String toString() {
                return t1.toString() + " + " + t2.toString() + " = " + r.toString();
            }
        });
        return r;
    }

    //@ Compute the difference of two tags on this clock
    public T tagDifference(final T t1, final T t2) {
        final T r = this.tag_calculus_.subtract(t1, t2);
        log("tags", new Object() {
            @Override
            public String toString() {
                return t1.toString() + " - " + t2.toString() + " = " + r.toString();
            }
        });
        return r;
    }

    //@ Compute the product of two tags on this clock
    public T tagProduct(final T t1, final T t2) {
        final T r = this.tag_calculus_.multiply(t1, t2);
        log("tags", new Object() {
            @Override
            public String toString() {
                return t1.toString() + " * " + t2.toString() + " = " + r.toString();
            }
        });
        return r;
    }

    //@ Compute the product of two tags on this clock
    public T tagQuotient(final T t1, final T t2) {
        final T r = this.tag_calculus_.divide(t1, t2);
        log("tags", new Object() {
            @Override
            public String toString() {
                return t1.toString() + " / " + t2.toString() + " = " + r.toString();
            }
        });
        return r;
    }

    //@ Compute the power of a tag on this clock
    public T tagPower(final T t1, final int n) {
        final T r = this.tag_calculus_.power(t1, n);
        log("tags", new Object() {
            @Override
            public String toString() {
                return t1.toString() + " ^ " + n + " = " + r.toString();
            }
        });
        return r;
    }

    //@ Compute the root of a tag on this clock
    public T tagRoot(final T t1, final int n) {
        final T r = this.tag_calculus_.root(t1, n);
        log("tags", new Object() {
            @Override
            public String toString() {
                return "root(" + t1.toString() + ", " + n + ") = " + r.toString();
            }
        });
        return r;
    }

    //@ Create a tick tagged with <code>value</code> on this clock
    public Tick<T> newTick(T value) {
        Tick<T> t = new Tick<T>(this);
        this.ticks_.add(0, t);
        if (value != null) {
            this.setTagValue(t, value);
        }
        return t;
    }

    //@ Create a tick of the right type on this clock
    @SuppressWarnings("unchecked")
    public Tick<T> newTick() {
        if (this.tag_calculus_ instanceof UnitCalc) {
            log("warning", "# Warning: Unit clock " + this.name_ + " is a Clock<Unit> instead of a UnitClock.");
            return newTick((T) Unit.getInstance());
        }
        return newTick(null);
    }

    /*@ Create a now tick on this clock, taking existing ticks into account
     *  Return true if a new tick was set to now.
     */
    public boolean newNowTick() {
        if (hasTickNow()) {
            // If the clock already has a now tick, do nothing
            return false;
        }
        if (hasFloatingTick()) {
            // If it has a floating tick, set it to now
            getFloatingTick().setNow(true);
        } else {
            // else, create a new tick and set it to now.
            newTick().setNow(true);
        }
        return true;
    }

    /*@ Make a copy of a tick (used for backups).
     * This amounts to create a tick owned by this clock,
     * but without adding it to the list of ticks of the clock.
     */
    private Tick<T> copyTick(Tick<T> t) {
        return new Tick<T>(this);
    }

    //@ Set the tag of a tick on this clock
    public Tick<T> setTagValue(Tick<T> tick, T tag) {
        if (tag == null) {
            setTag(tick, null);
        } else {
            setTag(tick, new Tag<T>(tag));
        }
        return tick;
    }

    //@ Set the tag of a tick on this clock
    public Tick<T> setTag(Tick<T> tick, Tag<T> tag) {
        if (tag == null) {
            this.tags_.remove(tick);
        } else {
            this.tags_.put(tick, tag);
        }
        Collections.sort(this.ticks_);
        return tick;
    }

    //@ Get the tag of a tick on this clock
    public Tag<T> getTag(Tick<T> tick) {
        return this.tags_.get(tick);
    }

    //@ Get the tag of a tick on this clock
    public T getTagValue(Tick<T> tick) {
        Tag<T> tag = this.tags_.get(tick);
        if (tag == null) {
            return null;
        } else {
            return tag.getValue();
        }
    }

    //@ Set a tick on this clock to now (or not)
    public Tick<T> setNow(Tick<T> tick, boolean now) {
        if (now) {
            this.now_ = tick;
        } else if (tick == this.now_) {
            this.now_ = null;
        }
        return tick;
    }

    //@ Is a tick on this clock now ?
    public boolean isNow(Tick<T> tick) {
        return tick == this.now_;
    }

    //@ Get the number of ticks on this clock
    public int getNumberOfTicks() {
        return this.ticks_.size();
    }

    //@ Remove a tick of this clock
    public void removeTick(Tick<T> tick) {
        this.ticks_.remove(tick);
        this.tags_.remove(tick);
        if (this.now_ == tick) {
            this.now_ = null;
        }
    }

    //@ Remove tick at index i of this clock
    public void removeTick(int i) {
        removeTick(getTick(i));
    }

    //@ Remove tick if I am the last owner of data. Returns true if the tick was removed.
    public boolean removeOwnedTick(Tick<T> tick, Object dataOwner) {
        tick.clearUserData(dataOwner);
        if (tick.userDataSize() == 0) {
            removeTick(tick);
            return true;
        }
        return false;
    }

    //@ Get the tick at index i of this clock
    public Tick<T> getTick(int i) {
        if (this.ticks_.size() <= i) {
            return null;
        }
        return this.ticks_.get(i);
    }

    //@ Get a tick with tag <code>tag</code> if any, or null if there is no such tick on this clock.
    public Tick<T> getTick(Tag<T> tag) {
        if (tag == null) {
            return getFloatingTick();
        } else {
            return getTick(tag.getValue());
        }
    }

    //@ Get a tick with tag <code>tag</code> if any, or null if there is no such tick on this clock.
    public Tick<T> getTick(T tag) {
        if (tag == null) {
            return getFloatingTick();
        } else {
            for (Tick<T> tick : this.tags_.keySet()) {
                Tag<T> t = this.tags_.get(tick);
                if (t != null) {
                    if (t.getValue().equals(tag)) {
                        return tick;
                    }
                }
            }
            return null;
        }
    }

    //@ Tell if the clock has a floating tick (tick with a null tag)
    public boolean hasFloatingTick() {
        for (Tick<T> tick : this.ticks_) {
            if (this.tags_.get(tick) == null) {
                return true;
            }
        }
        return false;
    }

    //@ Get the floating tick if any, or null if there is no floating tick on this clock
    public Tick<T> getFloatingTick() {
        for (Tick<T> tick : this.ticks_) {
            if (this.tags_.get(tick) == null) {
                return tick;
            }
        }
        return null;
    }

    //@ Tell if this clock has ticks
    public boolean hasTicks() {
        return getNumberOfTicks() > 0;
    }

    //@ Tell if this clock has a tick at the current instant
    public boolean hasTickNow() {
        return this.now_ != null;
    }

    //@ Tell if this clock has a real tick (not a ghost) at the current instant
    public boolean hasRealTickNow() {
        return ! this.solver_.isGhost(this.now_);
    }

    //@ Get 'now' tick of this clock
    public Tick<T> getNowTick() {
        return this.now_;
    }

    //@ Tell if this clock has at least a tagged tick
    public boolean hasTaggedTick() {
        return ! this.tags_.isEmpty();
    }

    //@ Get the first tagged tick if any.
    public Tick<T> getFirstTaggedTick() {
        for (Tick<T> tick : this.ticks_) {
            if (this.tags_.get(tick) != null) {
                return tick;
            }
        }
        return null;
    }

    //@ Get all the ticks of this clock
    public Collection<Tick<T>> getTicks() {
        return this.ticks_;
    }

    //@ Delete all the ticks of this clock
    public void resetClock() {
        this.ticks_.clear();
        this.tags_.clear();
        this.now_ = null;
    }

    //@ Remove the now tick on this clock
    public void removeNowTick() {
        if (this.now_ != null) {
            removeTick(this.now_);
        }
    }

    //@ Get the name of this clock
    public String getName() {
        return this.name_;
    }

    //@ Clean up : remove duplicate ticks, taking care of not removing "now" ticks
    public void cleanUp() {
        int ntics = this.getNumberOfTicks();
        int i = 0;
        Tag<T> last_tag = null;
        Tick<T> last_tick = null;
        boolean last_floating = false;
        while (i < ntics) {
            // Look at all ticks, and remove successive ticks that are the same (have same tag or are both floating)
            boolean remove = false;
            Tick<T> tick = this.getTick(i);
            Tag<T> curtag = tick.getTag();
            if (curtag == null) {
                if (last_floating) {
                    remove = true;
                }
            } else {
                if (curtag.equals(last_tag)) {
                    remove = true;
                }
            }
            if (remove) {
                if (tick.isNow()) {
                    // merge user data from both tick into the remaining tick
                    tick.mergeUserData(last_tick);
                    removeTick(last_tick);
                    last_tick = tick;
                    last_tag = curtag;
                    last_floating = (curtag == null);
                } else {
                    // merge user data from both tick into the remaining tick
                	if (last_tick != null) {
                      last_tick.mergeUserData(tick);
                      removeTick(tick);
                	}
                }
                ntics--;
            } else {
                last_tick = tick;
                last_tag = curtag;
                last_floating = (curtag == null);
                i++;
            }
        }
    }

    //@ Make a backup of this clock
    public ClockBackupInterface<T> backup() {
        return new ClockBackup();
    }

    //@ Restore from backup
    public void restore(ClockBackupInterface<T> backup) {
        this.resetClock();
        ClockBackup bck = (ClockBackup)backup;
        for (Tick<T> t : bck.ticks_backup_) {
            Tick<T> copy = this.copyTick(t);
            this.ticks_.add(copy);
            if (t == bck.now_backup_) {
                this.now_ = copy;
            }
            Tag<T> tag = bck.tags_backup_.get(t);
            if (tag != null) {
                this.tags_.put(copy, tag.copy());
            }
        }
        this.greedy_ = bck.greedy_backup_;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("Clock \"");
        buf.append(getName());
        buf.append("\": ");
        for (Tick<T> t : getTicks()) {
            buf.append(t.toString());
            buf.append(" ");
        }
        return buf.toString();
    }
}
