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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.supelec.tesl.logging.Logger;
import fr.supelec.tesl.logging.SysErrHandler;

/*@
 * A solver for clock relations
 */
public class ClockSet {
	private class ClockTagMap {
		private Map<Clock<?>, Tag<?>> tagmap;
		
		public ClockTagMap() {
			tagmap = new HashMap<Clock<?>, Tag<?>>();
		}
		
		@SuppressWarnings("unchecked")
		public <T extends Comparable<? super T>> Tag<T> get(Clock<T> c) {
			return (Tag<T>) tagmap.get(c);
		}
		
		public <T extends Comparable<? super T>> void put(Clock<T> c, Tag<T> t) {
			tagmap.put(c,  t);
		}
	}
	
	//@ A map giving the time on each clock assuming the key clock is chosen for the now tick
	private class SyncMap {
		private Map<Clock<?>, ClockTagMap> syncmap;
		
		public SyncMap() {
			syncmap = new HashMap<Clock<?>, ClockTagMap>();
		}

		public <T extends Comparable<? super T>> ClockTagMap get(Clock<T> c) {
			return syncmap.get(c);
		}
		
		public <T extends Comparable<? super T>> void put(Clock<T> c, ClockTagMap m) {
			syncmap.put(c, m);
		}
		
		public Collection<ClockTagMap> values() {
			return syncmap.values();
		}
		
		//@ Update the the time on every clock assuming clk is the time reference
		public <T extends Comparable<? super T>> void updateWithClock(Clock<T> clk) throws Exception {
            Tick<T> firstTaggedTick = clk.getFirstTaggedTick();
            if (firstTaggedTick != null) {
                put(clk, tagClosure(clk, firstTaggedTick.getTag()));
            }
		}

		//@ Update the the time on every clock assuming clock is the time reference now
		public <T extends Comparable<? super T>> void updateWithNowTick(Clock<T> clock) throws Exception {
            Tick<T> now = clock.getNowTick();
            if (now == null) {
                return;
            }
            if (now.getTag() == null) {
                return;
            }
            // If we have a now tick with a tag, compute the closure of the tag relations for this tick
			put(clock, tagClosure(clock, now.getTag()));
		}
		
		//@ Type preserving method to get the tag of a clock assuming ref is the time reference
		public <T extends Comparable<? super T>> Tag<T> getSyncTag(Clock<?> ref, Clock<T> clock) {
			return syncmap.get(ref).get(clock);
		}

		//@ Type preserving method to compare the time on a clock according to two time references
		public <T extends Comparable<? super T>> int compareSyncTags(Clock<?> ref1, Clock<?> ref2, Clock<T> clock) {
			return compareTags(get(ref1).get(clock), get(ref2).get(clock));
		}
	}
	
    //@ The name of the solver
    private final String name_;
    //@ The logger for this solver
    private final Logger logger_;
    //@ The clock of this solver
    private List<Clock<?>> clocks_;
    //@ The clock of this solver that are public to normal users
    private Set<Clock<?>> public_clocks_;
    //@ The implication relations (event triggers)
    private List<ImplicationRelation> c_implications_;
    //@ The tag relations (simultaneity, time triggers)
    private List<TagRelation<?,?>> t_relations_;
    //@ The implication relations classified by master clocks
    private Map<Clock<?>, List<ImplicationRelation>> masters_;
    //@ The implication relations classified by slave clocks
    private Map<Clock<?>, List<ImplicationRelation>> slaves_;
    //@ The tag relations classified by "from" clock
    private Map<Clock<?>, List<TagRelation<?,?>>> tagFrom_;
    //@ The tag relations classified by "to" clock
    private Map<Clock<?>, List<TagRelation<?,?>>> tagTo_;
    //@ The ticks which are ghosts used by the solving algorithm (not real ticks) and may disappear at the end
    private List<Tick<?>> floatingGhosts_;
    //@ The belonging of clocks to time islands (connected subgraphs of the tag relations graph)
    private Map<Clock<?>, Set<Clock<?>>> time_islands_;
    //@ The transitive closure of the tag relations, computed for each clock assuming its current time is now
    private SyncMap sync_tags_;

    //@ Create a new ClokSet for solving relations between clocks
    public ClockSet(String name) {
        this.name_ = name;
        this.logger_ = Logger.getLogger(this.name_);
        this.clocks_ = new LinkedList<Clock<?>>();
        this.public_clocks_ = new HashSet<Clock<?>>();
        this.c_implications_ = new LinkedList<ImplicationRelation>();
        this.t_relations_ = new LinkedList<TagRelation<?, ?>>();
        this.masters_ = new HashMap<Clock<?>, List<ImplicationRelation>>();
        this.slaves_ = new HashMap<Clock<?>, List<ImplicationRelation>>();
        this.tagFrom_ = new HashMap<Clock<?>, List<TagRelation<?,?>>>();
        this.tagTo_ = new HashMap<Clock<?>, List<TagRelation<?,?>>>();
        this.floatingGhosts_ = new LinkedList<Tick<?>>();
        this.time_islands_ = new HashMap<Clock<?>, Set<Clock<?>>>();
        this.logger_.addInformationKinds("error", "warning", "info", "fine", "finer", "tags");
        // By default, log only errors and warnings
        this.logger_.setLoggingKinds(true, "error", "warning");
        if (this.logger_.getHandlers().size() == 0) {
            this.logger_.addHandler(new SysErrHandler());
        }
    }

    //@ Create a new ClockSet with a default name
    public ClockSet() {
        this("TESL solver");
    }

    //@ Get the logger of this solver
    public Logger getLogger() {
        return this.logger_;
    }

    public <K extends Comparable<K>> Clock<K> addNewClock(Class<K> type, String name, TagCalculus<K> calc, boolean greedy) {
        Clock<K> c = Clock.createClock(type, name, calc, greedy);
        return addClock(c);
    }

    public <K extends Comparable<K>> Clock<K> addNewClock(Class<K> type, String name, TagCalculus<K> calc) {
        Clock<K> c = Clock.createClock(type, name, calc);
        return addClock(c);
    }

    //@ Add a clock to this solver
    public <T extends Comparable<? super T>> Clock<T> addClock(Clock<T> c) {
        if ( !this.clocks_.contains(c)) {
            this.clocks_.add(c);
            c.setSolver(this);
            this.public_clocks_.add(c);
        }
        return c;
    }

    //@ Add a clock to this solver, version with erased types for Xtend
    public Clock<?> addClock_erased(Clock<?> c) {
    	return this.addClock(c);
    }
    
    //@ Make a clock hidden to normal users
    public <T extends Comparable<? super T>> void hideClock(Clock<T> c) {
        this.public_clocks_.remove(c);
    }

    //@ Tell if a clock is hidden to normal users
    public <T extends Comparable<? super T>> boolean isPublic(Clock<T> c) {
        return this.public_clocks_.contains(c);
    }

    //@ Add a clock relation to this solver
    public ImplicationRelation addImplicationRelation(ImplicationRelation r) {
        if ( this.c_implications_.contains(r) ) {
            return r;
        }
        this.c_implications_.add(r);
        r.setSolver(this);
/*        // Get the list of relations associated to the first master clock of the relation
        List<ImplicationRelation> l = this.masters_.get(r.getMasterClocks()[0]);
        if (l == null) {
            l = new LinkedList<ImplicationRelation>();
            for (Clock<?> clk : r.getMasterClocks()) {
                this.masters_.put(clk, l);
            }
        }
        l.add(r);
*/
        // Update the list of relations associated to the master clocks of the relation
        for (Clock<?> c : r.getMasterClocks()) {
        	List<ImplicationRelation> masters = this.masters_.get(c);
        	if (masters == null) {
        		masters = new LinkedList<ImplicationRelation>();
                this.masters_.put(c, masters);
            }
        	if (! masters.contains(r)) {
        		masters.add(r);
        	}
        }
        List<ImplicationRelation> slaves = this.slaves_.get(r.getSlaveClock());
        if (slaves == null) {
            slaves = new LinkedList<ImplicationRelation>();
            this.slaves_.put(r.getSlaveClock(), slaves);
        }
        if (! slaves.contains(r)) {
        	slaves.add(r);
        }
        return r;
    }

    //@ Check if a tag relation closes a cycle in the undirected tag relation graph
    public <T extends Comparable<? super T>, U extends Comparable<? super U>> boolean closesTagCycle(TagRelation<T,U> t) {
    	return tagLinked(t.fromClock(), t.toClock(), new HashSet<TagRelation<?,?>>());
    }
    
    public <T extends Comparable<? super T>, U extends Comparable<? super U>> boolean tagLinked(Clock<T> from, Clock<U> to, HashSet<TagRelation<?,?>> visited) {
    	List<TagRelation<?,?>> lfrom = this.tagFrom_.get(from);
    	if (lfrom != null) {
    		for (TagRelation<?,?> tr : lfrom) {
    			if (tr.toClock() == to) {
    				return true;
    			}
    			if (!visited.contains(tr)) {
    				visited.add(tr);
    				if (tagLinked(tr.toClock(), to, visited)) {
    					return true;
    				}
        			visited.remove(tr);
    			}
    		}
    	}
    	List<TagRelation<?,?>> lto = this.tagTo_.get(from);
    	if (lto != null) {
    		for (TagRelation<?,?> tr : lto) {
    			if (tr.fromClock() == to) {
    				return true;
    			}
    			if (!visited.contains(tr)) {
    				visited.add(tr);
    				if (tagLinked(tr.fromClock(), to, visited)) {
    					return true;
    				}
        			visited.remove(tr);
    			}
    		}
    	}
    	return false;
    }
    
    //@ Add a relation between the tags of two clocks to this solver
    public <T extends Comparable<? super T>, U extends Comparable<? super U>> TagRelation<T,U> addTagRelation(TagRelation<T,U> t) throws Exception {
        if (this.t_relations_.contains(t)) {
            return t;
        }
        if (closesTagCycle(t)) {
        	String msg = "Adding tag relation " + t + " would close a cycle in the tag relation graph.";
        	this.logger_.log("error", msg);
        	throw new Exception("#ERROR: " + msg);
        }
        this.t_relations_.add(t);
        t.setSolver(this);
        List<TagRelation<?,?>> lfrom = this.tagFrom_.get(t.fromClock()); 
        if (lfrom == null) {
        	lfrom = new LinkedList<TagRelation<?,?>>();
        	this.tagFrom_.put(t.fromClock(), lfrom);
        }
    	lfrom.add(t);
        List<TagRelation<?,?>> lto = this.tagTo_.get(t.toClock()); 
        if (lto == null) {
        	lto = new LinkedList<TagRelation<?,?>>();
        	this.tagTo_.put(t.toClock(), lto);
        }
    	lto.add(t);
        return t;
    }

    //@ Get the clocks of this solver which are not hidden
    public Iterable<Clock<?>> getClocks() {
        return this.public_clocks_;
    }

    //@ Get all the clocks (including hidden ones) of this solver
    public Iterable<Clock<?>> getAllClocks() {
        return this.clocks_;
    }

    //@ Reset the clocks of this solver
    public void resetClocks() {
        for (Clock<?> c : this.clocks_) {
            c.resetClock();
        }
    }

    //@ Tell if something can happen in the future
    public boolean hasFuture() {
        for (Clock<?> c : this.clocks_) {
            if (c.hasTicks()) {
                return true;
            }
        }
        return false;
    }

    //@ Remove the now tick on every clock
    public void removeNowTicks() {
        for (Clock<?> c : this.clocks_) {
            c.removeNowTick();
        }
    }

    //@ Get the clock relations of this solver
    public Iterable<ImplicationRelation> getImplicationRelations() {
        return this.c_implications_;
    }

    //@ Get the relation between clock tags of this solver
    public Iterable<TagRelation<?, ?>> getTagRelations() {
        return this.t_relations_;
    }

    //@ Get a backup of the state of this clockset
    public ClockSetMark getMark() {
        ClockSetMark mark = new ClockSetMark();
        for (Clock<?> clk : this.clocks_) {
            mark.addClock(clk.backup());
        }
        for (ImplicationRelation imp : this.c_implications_) {
            mark.addImplication(imp.backup());
        }
        return mark;
    }

    //@ Restore the state of this clockset to mark
    @SuppressWarnings("static-method")
	public void setMark(ClockSetMark mark) {
        for (ClockBackupInterface<?> bck : mark.clockBackups()) {
            bck.restore();
        }
        for (ImplicationBackupInterface bck : mark.implicationBackups()) {
            bck.restore();
        }
    }

    //@ Find the time islands (connected parts of the tag relation graph) of this clock set
    private void findTimeIslands() {
        this.time_islands_.clear();
        // Populate with one clock per island
        for (Clock<?> clk : getAllClocks()) {
            Set<Clock<?>> s = new HashSet<Clock<?>>();
            s.add(clk);
            this.time_islands_.put(clk, s);
        }
        // Merge islands according to tag relations
        for (TagRelation<? extends Comparable<?>, ? extends Comparable<?>> rel : this.t_relations_) {
            Clock<?> c1 = rel.fromClock();
            Clock<?> c2 = rel.toClock();
            Set<Clock<?>>island1 = this.time_islands_.get(c1);
            Set<Clock<?>>island2 = this.time_islands_.get(c2);
            if ((island1 == null) && (island2 == null)) {
                island1 = island2 = new HashSet<Clock<?>>();
                island1.add(c1);
                island1.add(c2);
                this.time_islands_.put(c1,  island1);
                this.time_islands_.put(c2,  island1);
            } else if ((island1 != null) && (island2 != null)) {
                if (island1 != island2) {
                    island1.addAll(island2);
                    for (Clock<?> c : island2) {
                        this.time_islands_.remove(c);
                        this.time_islands_.put(c, island1);
                    }
                }
            } else if (island1 == null) {
            	if (island2 != null) { // should always be true
                  island2.add(c1);
                  this.time_islands_.put(c1, island2);
            	}
            } else {
                island1.add(c2);
                this.time_islands_.put(c2, island1);
            }
        }
        this.logger_.log("fine",
                new Object() {
                  @SuppressWarnings("synthetic-access")
			      @Override
                  public String toString() {
                      StringBuffer buf = new StringBuffer("Time islands:"+Logger.EOL);
                      for (Clock<? extends Comparable<?>> robinson : ClockSet.this.time_islands_.keySet()) {
                          buf.append(Logger.TAB);
                          buf.append("Island of ");
                          buf.append(robinson.getName());
                          buf.append(" = {");
                          for (Clock<? extends Comparable<?>> friday : ClockSet.this.time_islands_.get(robinson)) {
                              buf.append(friday.getName());
                              buf.append(" ");
                          }
                          buf.append("}");
                          buf.append(Logger.EOL);
                      }
                      return buf.toString();
                  }
              }
        );
    }

    //@ Compute the current instant of this clockset
    public ClockSet solve() throws Exception {
        return this.solve((Tick<Unit>)null);
    }

    //@ Perform a solving phase: create ticks induced by relations and compute their tags at this instant, assuming tick is present now
    public <T extends Comparable<T>>  ClockSet solve(Tick<T> tick) throws Exception {
        this.logger_.log("fine",
                new Object() {
                    @SuppressWarnings("synthetic-access")
					@Override
                    public String toString() {
                        StringBuffer buf = new StringBuffer(Logger.EOL);
                        for (ImplicationRelation r : ClockSet.this.c_implications_) {
                            buf.append(Logger.TAB);
                            buf.append(r.toString());
                            buf.append(Logger.EOL);
                        }
                        return buf.toString();
                    }
                }
        );

        if (tick != null) {
            tick.setNow(true);
        }

        this.sync_tags_ = new SyncMap();

        findTimeIslands();

        this.logger_.log("info", new ClockPrinter("START"));

        cleanUpClocks();

        this.logger_.log("finer", new ClockPrinter("After cleanup"));

        // First, sort the relation in topological order to optimize solving
        doTopoSort();

        // Tell each relation that a new solving phase starts
        for (ImplicationRelation r : this.c_implications_) {
            r.startSolving();
        }

        // While new ticks are created at the current instant, apply relations and compute tags
        boolean new_tick;
        int i = 0;
        // Update tag relations closure in case some clocks already have a now tick.
        updateTagRelationClosure();
        do {
            this.logger_.log("fine", new ClockPrinter("*** ITERATION: " + (++i)));
            do {
                this.logger_.log("finer", new ClockPrinter("2 - Before solving ticks"));

                new_tick = solveTicks();

                if (new_tick) {
                    updateTagRelationClosure();
                }
                this.logger_.log("finer", new ClockPrinter("3 - After solving ticks"));

                boolean tick_added = solveTags();
                new_tick = new_tick || tick_added;
                if (new_tick) {
                    updateTagRelationClosure();
                }

                this.logger_.log("finer", new ClockPrinter("4 - After solving tags"));
            } while (new_tick);

            this.logger_.log("finer", new ClockPrinter("5 - Before merging ticks"));

            new_tick = mergeTicks();

            this.logger_.log("finer", new ClockPrinter("6 - After merging ticks"));

            if (new_tick) {
                updateTagRelationClosure();
            }

            if ( ! new_tick) {
                new_tick = alignFloatingTime();
                this.logger_.log("finer", new ClockPrinter("7 - After aligning floating times"));
            }
        } while (new_tick);
        
        // Tell each relation that the solving phase has ended (useful for detecting inconsistencies)
        for (ImplicationRelation r : this.c_implications_) {
            r.endSolving();
        }

        this.logger_.log("info", new ClockPrinter("*** Result"));

        // check that the 'now' tick it's the first tick on each clock and has a tag
        for(Clock<?> clk: this.clocks_) {
            checkFirstTick(clk);
        }

        return this;
    }

    //@ Clean up clocks: remove duplicate ticks, taking care of not removing "now" ticks
    private void cleanUpClocks() {
        for (Clock<? extends Comparable<?>> clock : this.clocks_) {
            clock.cleanUp();
        }
    }

    //@ Check how many 'now' ticks are on the input clocks
    public boolean checkNoNow() {
        int count = 0;
        for (Clock<?> clk : this.clocks_) {
            for (Tick<?> t : clk.getTicks()) {
                if (t.isNow()) {
                    count ++;
                }
            }
        }
        if (count != 0) { // there is, at least, one clock with a 'now' tick
            return false;
        } else { // no clock has a 'now' tick
            return true;
        }
    }

    //@ Check first tick of a clock, if this is 'now'
    protected <T extends Comparable<? super T>> void checkFirstTick(Clock<T> clk) throws Exception {
        if(clk.getNowTick() != null) {
            if(clk.getNowTick().getTag() == null) {
                this.logger_.log("error", "The 'now' tick has no tag on clock ", clk.getName());
                throw new Exception("# ERROR: The 'now' tick has no tag on clock "+ clk.getName());
            } else {
                if(clk.getNowTick().getTag().compareTo(clk.getTick(0).getTag()) > 0) {
                    this.logger_.log("error", "The 'now' tick is not the first one for clock ", clk.getName());
                    throw new Exception("# ERROR: The 'now' tick is not the first one for clock "+ clk.getName());
                }
            }
        }
    }

    //@ Tell whether clock c1 depends on clock c2 through implication relations
    public boolean dependsOn(Clock<?> c1, Clock<?> c2) {
        // Look for all implications that imply c1
        List<ImplicationRelation> implying_c1 = this.slaves_.get(c1);
        List<ImplicationRelation> impliedby_c2 = this.masters_.get(c2);
        if ((implying_c1 == null) || (impliedby_c2 == null)) {
            return false;
        }
        for (ImplicationRelation r1 : implying_c1) {
            for (ImplicationRelation r2 : impliedby_c2) {
                if ((r1 == r2) || dependsOn(r1, r2)) {
                    return true;
                }
            }
        }
        return false;
    }

    //@ Tell whether clock c1 depends instantaneously on clock c2 through implication relations
    private boolean dependsInstantaneouslyOn(Clock<?> c1, Clock<?> c2, Map<ImplicationRelation, Boolean> visited) {
        // Look for all implications that imply c1
        List<ImplicationRelation> implying_c1 = this.slaves_.get(c1);
        if (implying_c1 == null) {
        	return false;
        }
        for (ImplicationRelation imp : implying_c1) {
        	if (visited.containsKey(imp)) {
        		continue;
        	}
        	visited.put(imp, true);
        	// Skip non instantaneous implications
        	if (!imp.isInstantaneous()) {
        		continue;
        	}
        	for (Clock<?> c : imp.getMasterClocks()) {
        		if (c== c2) {
        			return true;
        		}
        		if (dependsInstantaneouslyOn(c, c2, visited)) {
        			return true;
        		}
        	}
        }
        return false;
    }

    //@ Tell whether clock c1 depends instantaneously on clock c2 through implication relations
    public boolean dependsInstantaneouslyOn(Clock<?> c1, Clock<?> c2) {
    	return dependsInstantaneouslyOn(c1, c2, new HashMap<>());
    }

    //@ Tell whether r1 depends on r2
    public boolean dependsOn(ImplicationRelation r1, ImplicationRelation r2) {
        return dependsOn(r1, r2, new HashMap<ImplicationRelation, Boolean>());
    }

    //@ Tell whether r1 depends on r2
    private boolean dependsOn(ImplicationRelation r1, ImplicationRelation r2, Map<ImplicationRelation, Boolean> visited) {
        visited.put(r1, true);
        // For all master clocks of r1
        for (Clock<?> clock : r1.getMasterClocks()) {
            // Get the list of implication relations which have clock as slave
            // These are the implication relations which r1 depends on
            List<ImplicationRelation> slaves = this.slaves_.get(clock);
            if (slaves != null) {
                // For each of these "master" implications
                for (ImplicationRelation r : slaves) {
                    if (r == r2) {
                        // If r2 is a "master" implication of r1, r1 depends on r2
                        // In other words, if a slave clock of r2 is a master clock of r1, r1 depends on r2
                        // This is because when applying r2, we may add ticks to its slave, which is a master of r1
                        return true;
                    }
                    if (!visited.containsKey(r) && dependsOn(r, r2, visited)) {
                        // r1 depend on r, so if r depends on r2, r1 depends on r2
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //@ Sort clock relations in topological order (less dependent first)
    protected void doTopoSort() {
        Collections.sort(this.c_implications_, new Comparator<ImplicationRelation>() {
            @Override
            public int compare(ImplicationRelation arg0, ImplicationRelation arg1) {
                if (dependsOn(arg0, arg1)) {
                    return 1;
                }
                if (dependsOn(arg1, arg0)) {
                    return -1;
                }
                return 0;
            }
        });
    }

    //@ Apply clock relations to find which clocks have a tick "now"
    protected boolean solveTicks() {
        boolean changed;
        boolean new_ticks = false;

        // Apply relations until no new tick is produced now
        do {
            changed = false;
            boolean has_now = false;
            for (Clock<?> clock : this.clocks_) {
                if (clock.hasTickNow()) {
                    has_now = true;
                    break;
                }
            }
            if (! has_now) {
                // No now tick => nothing to do
                return false;
            }
            for (Clock<?> clock : this.clocks_) {
                Tick<?> floating = clock.getFloatingTick();
                Tick<?> now = clock.getNowTick();
                // A floating tick should be "now" ASAP.
                // If there are no other now tick on the clock, make the floating tick "now"
                if ((now == null) && (floating != null)) {
                    floating.setNow(true);
                }
            }

            for (ImplicationRelation r : this.c_implications_) {
                changed = changed || r.apply();
            }
            new_ticks = new_ticks || changed;
        } while (changed);

        return new_ticks;
    }

    //@ Type preserving method to get the tag of the now tick of a clock
    private <T extends Comparable<? super T>> Tag<T> getNowTag(Clock<T> c) {
    	return c.getNowTick().getTag();
    }
    
    //@ Type preserving method to compute the closure of the tag relations assuming the now tick of c is chosen
    private <T extends Comparable<? super T>> ClockTagMap getTagClosureOfNow(Clock<T> c) throws Exception {
    	return tagClosure(c, getNowTag(c));
    }
    
    //@ Type preserving method to get the current tick on c from the tag relation closure
    private <T extends Comparable<? super T>> Tick<T> getTickWithTagFromClosure(ClockTagMap m, Clock<T> c) throws Exception {
    	return c.getTick(m.get(c));
    }
    
    //@ Type preserving method to fix the now tick on oclock assuming clock has a now tick at tag
    private <T extends Comparable<? super T>, U extends Comparable<? super U>>
    boolean fixNowTick(ClockTagMap closure, Clock<T> oclock, Clock<U> clock, Tag<U> tag) throws Exception {
        Tag<T> otag = closure.get(oclock);
        if (otag != null) {
            Tick<T> now = getTickWithTagFromClosure(closure, oclock);
            if (now != null) {
                // There is a tick with this tag on the other clock
                if ( ! now.isNow() ) {
                    // It is not 'now' yet, check if another tick is now
                    Tick<T> onow = oclock.getNowTick();
                    if (onow != null) {
                        if (onow.getTag() == null) {
                            // If the other now tick is floating, remove it
                            now.mergeUserData(onow);
                            oclock.removeTick(onow);
                        } else {
                            // Weird: the tick with the 'now' tag is not "now",
                            // but there is another tick which is "now" and has a tag
                            Tag<T> onowtag = onow.getTag();
                            if (onowtag.equals(otag)) {
                                // OK, it was just two ticks with the same tag, remove the duplicate one
                                now.mergeUserData(onow);
                                oclock.removeTick(onow);
                            } else {
                                // The now tick of the other clock does not have the 'now' tag.
                                // This is possible because tag relations are not always symmetric,
                                // so look for the now tag that clock should have according to the now tag of the other clock
                                if (compareTags(this.sync_tags_.get(oclock).get(clock), tag) != 0) {
                                    // the now tag of the other clock is not compatible with the now tag of the clock
                                    // => Inconsistent equations
                                    this.logger_.log("error", "Clock ", oclock.getName(), " has a now tick with tag ", onowtag.toString(), " but should be now at ", otag.toString());
                                    throw new Exception("Clock " + oclock.getName() + " has a now tick with tag " + onowtag.toString() + " but should be now at " + otag.toString());
                                }
                            }
                        }
                    }
                    // Set the tick with the 'now' tag to 'now' on the other clock
                    now.setNow(true);
                    return true;
                }
            } else {
                // The other clock does not have a tick with the 'now' tag
                Tick<T> onow = oclock.getNowTick();
                if (onow != null) {
                    // The other clock has a "now" tick
                    Tag<T> onowtag = onow.getTag();
                    if (onowtag == null) {
                        // We have a floating tick: set its tag to the 'now' tag
                    	onow.setTag(otag);
                    } else {
                        // The now tick of the other clock does not have the 'now' tag.
                        // This is possible because tag relations are not always symmetric,
                        // so look for the now tag that clock should have according to the now tag of the other clock
                        if (compareTags(this.sync_tags_.get(oclock).get(clock), tag) != 0) {
                            // the now tag of the other clock is not compatible with the now tag of the clock
                            // => Inconsistent equations
                            this.logger_.log("error", "Clock ", oclock.getName(), " has a now tick with tag ", onowtag.toString(), " but should be now at ", otag.toString(), Logger.EOL, this);
                            throw new Exception("Clock " + oclock.getName() + " has a now tick with tag " + onowtag.toString() + " but should be now at " + otag.toString());
                        }
                    }
                } else {
                    // Look for a floating tick
                    Tick<T> floating = oclock.getFloatingTick();
                    if (floating != null) {
                    	floating.setTag(otag);
                        floating.setNow(true);
                    }
                }
                for (Tick<T> tick : oclock.getTicks()) {
                    Tag<T> ctag = tick.getTag();
                    if (ctag == null) {
                        continue;
                    }
                    if (compareTags(ctag, otag) >= 0) {
                        break;
                    }
                    this.logger_.log("error", "Clock ", oclock.getName(), " has a tick in the past (", ctag.toString(), "). Now is at ", otag.toString(), Logger.EOL, this);
                    throw new Exception("Clock " + oclock.getName() + " has a tick in the past (" + ctag.toString() + "). Now is at " + otag.toString());
                }
            }
        }
        return false;
    }
    
    //@ Type preserving method for handling the fact that clock has a tick now
    private <T extends Comparable<? super T>> boolean handleNowTick(Clock<T> clock) throws Exception {
        Tag<T> tag = clock.getNowTick().getTag();
        boolean tick_added = false;
        if (tag != null) {
            ClockTagMap closure = getTagClosureOfNow(clock);
            this.logger_.log("fine", closure);
            // Check and fix the now tick on the other clocks according to the tag relation closure
            for (Clock<?> oclock : this.clocks_) {
                if (oclock == clock) {
                    continue;
                }
                // oclock is another clock than clock
                tick_added = tick_added || fixNowTick(closure, oclock, clock, tag);
            }
        }
        return tick_added;
    }
    
    //@ Use tag relations to compute the tags of the ticks. Return true if new ticks become "now"
    protected boolean solveTags() throws Exception {
        boolean new_ticks = false;
        boolean tick_added = false;

        do {
            tick_added = false;
            for (Clock<?> clock : this.clocks_) {
                this.logger_.log("fine", "Solving tags from clock " + clock.getName());
                if (clock.hasTickNow()) {
                	tick_added = handleNowTick(clock);
                }
            }
            new_ticks = new_ticks || tick_added;
        } while (tick_added) ;
        return new_ticks;
    }

    //@ Update the closure of the tag relations by processing rel
    private <T extends Comparable<? super T>, U extends Comparable <? super U>>
    boolean processTagRelation(ClockTagMap closure, TagRelation<T, U> rel) {
        Tag<T> from_tag = closure.get(rel.fromClock());
        Tag<U> to_tag = closure.get(rel.toClock());

        this.logger_.log("fine", "Processing tag relation ", rel, Logger.EOL,
                Logger.TAB, "From tag = ", from_tag, ", to tag = ", to_tag);

        boolean done = true;
        if ((from_tag != null) && (to_tag == null)) {
            closure.put(rel.toClock(), processConversion(rel, from_tag));
            done = false;  // we updated a tag, so we must propagate through tag relations
        }
        if ((to_tag != null) && (from_tag == null)) {
            closure.put(rel.fromClock(), (Tag<T>) processRevConversion(rel, to_tag));
            done = false; // we updated a tag, so we must propagate through tag relations
        }
        return done;
    }

    //@ Compute the closure of the tag relations assuming time is tag on clock
	private <T extends Comparable<? super T>> ClockTagMap tagClosure(Clock<T> clock, Tag<T> tag) throws Exception {
        ClockTagMap closure = new ClockTagMap();
        closure.put(clock, tag);

        // Compute tags on other clocks assuming clock "clock" has tag "tag"
        boolean done = false;
        int turns = 0;
        while (! done) {
            if (turns > this.clocks_.size()) {
                // If we iterate more than the number of clocks, something is wrong with the tag relations
                this.logger_.log("error", "Too many iterations while computing tags ticks. Are the tag relations sound?");
                throw new Exception("Too many iterations while computing tags ticks. Are the tag relations sound?");
            }
            turns++;
            done = true;
            for (TagRelation<?, ?> rel : this.t_relations_) {
            	done = done && processTagRelation(closure, rel);
            }
        }
        return closure;
    }

    //@ Merge the ticks of a clock . Return true if new ticks become "now"
    protected boolean mergeTicks() throws Exception {
        // List of clocks where a floating tick may be merged with a tagged tick
        List<Clock<?>> merge_clocks = new LinkedList<Clock<?>>();

        for (Clock<?> clk : this.clocks_) {
            Tick<?> floating = clk.getFloatingTick();
            if (floating != null && floating.isNow() && clk.hasTaggedTick()) {
                // If the floating tick is now and there is a tagged tick, we may merge them
                merge_clocks.add(clk);
            }
        }

        if (merge_clocks.size() == 0) {
            return false;
        }

        // Map: clock c1 => (the map: clock c2 => the tag that would be now on c2 if we merged the floating tick on clock c1)
        SyncMap sync_tags = new SyncMap();

        for (Clock<?> clk : this.clocks_) {
            // Map: c => tag of "now" on c assuming we merge the floating tick on clk
        	sync_tags.updateWithClock(clk);
        }

        // Find the time islands to which the merging clocks belong
        Set<Set<Clock<?>>> islands = new HashSet<Set<Clock<?>>>();
        for (Clock<?> clk : merge_clocks) {
            islands.add(this.time_islands_.get(clk));
        }
        // In each time island, look for the merging clock that gives the smallest tags
        for (Set<Clock<?>> island : islands) {
            this.logger_.log("fine", "# Processing new island");
            // Clocks of the island that have a tick to merge
            List<Clock<?>> to_merge = new LinkedList<Clock<?>>();
            for (Clock<?> clock : island) {
                // Add only clocks that have information about their tags
                if (sync_tags.get(clock) != null) {
                    to_merge.add(clock);
                }
            }
            
            this.logger_.log("fine",
                    new Object() {
                      @Override
                      public String toString() {
                        StringBuffer buf = new StringBuffer();
                        buf.append("==== Merge/Tag array =======");
                        buf.append(Logger.EOL);
                        for (Clock<?> a : to_merge) {
                            buf.append(Logger.TAB);
                            for (Clock<?> b : to_merge) {
                                buf.append(sync_tags.get(a).get(b));
                                buf.append("  ");
                            }
                            buf.append(Logger.EOL);
                        }
                        return buf.toString();
                    }
                }
            );
            
            // Find the minimal clock in order to merge ticks while advancing time as little as possible
            Clock<?> minClock = to_merge.get(0);
            for (Clock<?> ref : to_merge) {
            	boolean lower = false; // is ref lower than minClock?
            	for (Clock<?> clock : to_merge) {
            		if (sync_tags.compareSyncTags(ref, minClock, clock) > 0) {
                        // If a tag in a column is greater than on minClock, time on ref is definitely not lower than on minClock
            			lower = false;
            			break;
            		}
                    if (sync_tags.compareSyncTags(ref, minClock, clock) < 0) {
                        // If a tag in a column is smaller than on minClock, time on ref may be lower than on minClock
                        lower = true;
                    }
            	}
                if (lower) {
                    minClock = ref;
                }
            }
            if (minClock == to_merge.get(0)) {
                // Default minimum was chosen, so we found no lower clock.
                // Check that minClock is really a minimum with respect to other clocks
                for (Clock<?> other : to_merge) {
                    boolean leq = true;
                    for (Clock<?> c : to_merge) {
                        if (sync_tags.compareSyncTags(minClock, other, c) > 0) {
                            // If a tag on c is greater with respect to other than with minClock, minClock is not a minimum
                            leq = false;
                            break;
                        }
                    }
                    if (!leq) {
                        // Error: there is no minimal reference in the synchronization matrix,
                        // so there is an inconsistency in the tag relations
                        this.logger_.log("error", "Inconsistent tag relations between clocks. Use \"fine\" logging kind to get the tag array.");
                        throw new Exception("# Error: inconsistent tag relations between clocks. Use \"fine\" logging kind to get the tag array.");
                    }
                }
            }
            
            // Merge on every clock according to the tag on the min line
            for (Clock<?> c : to_merge) {
                this.logger_.log("info", "Merging on ", c, " tag = ", sync_tags.getSyncTag(minClock, c));
                mergeNullTick(c, sync_tags.getSyncTag(minClock, c));
            }

            updateTagRelationClosure();

        }

        return true;
/*          // Old version with an array. Had issues preserving type information in generics           
            final int size = to_merge.size(); // should be at least 1
            // Build an array of tag for easy navigation along columns
            // matrix[i][j] = tag of now on clock j if we merge the floating tick on clock i
            @SuppressWarnings("unchecked")
            final Tag<?>[][] matrix = new Tag[size][size];
            int i = 0;
            for (Clock<?> clock : to_merge) {
                ClockTagMap current_tags = sync_tags.get(clock);
                this.logger_.log("fine", "sync_tags["+i+"]= ", current_tags);
                int j = 0;
                for (Clock<?> oclock : to_merge) {
                    matrix[i][j] = current_tags.get(oclock);
                    this.logger_.log("finer", "sync_tags["+i+"]["+j+"] = ", matrix[i][j]);
                    j++;
                }
                i++;
            }
            this.logger_.log("fine",
                    new Object() {
                @Override
                public String toString() {
                    StringBuffer buf = new StringBuffer();
                    buf.append("==== Merge/Tag array =======");
                    buf.append(Logger.EOL);
                    for (int a = 0; a < size; a++) {
                        buf.append(Logger.TAB);
                        for (int b = 0; b < size; b++) {
                            buf.append(matrix[a][b]);
                            buf.append("  ");
                        }
                        buf.append(Logger.EOL);
                    }
                    return buf.toString();
                }
            }
                    );
            // Look across columns for a minimum line
            int min = 0;
            for (int k = 1; k < size; k++) {
                // Is row k lower than row min?
                boolean lower = false;
                for (int z = 0; z < size; z++) {
                    if (compareTags(matrix[k][z], matrix[min][z]) > 0) {
                        // If a tag in a column is greater than on line min, row k is definitely not lower than min
                        lower = false;
                        break;
                    }
                    if (compareTags(matrix[k][z], matrix[min][z]) < 0) {
                        // If a tag in a column is smaller than on line min, row k may be lower than min
                        lower = true;
                    }
                }
                if (lower) {
                    min = k;
                }
            }
            if (min == 0) {
                // Default minimum was chosen, so we found no lower line in the matrix.
                // Check that min is really a minimum line
                for (int k = 1; k < size; k++) {
                    boolean leq = true;
                    for (int z = 0; z < size; z++) {
                        if (compareTags(matrix[min][z], matrix[k][z]) > 0) {
                            // If a tag in a column is greater than in min, min is not a minimum
                            leq = false;
                            break;
                        }
                    }
                    if (!leq) {
                        // Error: there is no minimal line in the synchronization matrix,
                        // so there is an inconsistency in the tag relations
                        this.logger_.log("error", "Inconsistent tag relations between clocks. Use \"fine\" logging kind to get the tag array.");
                        throw new Exception("# Error: inconsistent tag relations between clocks. Use \"fine\" logging kind to get the tag array.");
                    }
                }
            }

            // Merge on every clock according to the tag on the min line
            for (int k = 0; k < size; k++) {
                this.logger_.log("info", "Merging on ", to_merge.get(k), " tag = ", matrix[min][k]);
                mergeNullTick(to_merge.get(k), matrix[min][k]);
            }

            updateTagRelationClosure();

        }

        return true;
*/
    }
    
    //@ Type preserving conversion of a tag according to a tag relation
    private static <U extends Comparable<? super U>, V extends Comparable<? super V>> Tag<V> processConversion(TagRelation<U, V> rel, Tag<U> tag) {
        return new Tag<V>(rel.directConversion(tag.getValue()));
    }

    //@ Type preserving reverse conversion of a tag according to a tag relation
    private static <U extends Comparable<? super U>, V extends Comparable<? super V>> Tag<U> processRevConversion(TagRelation<U, V> rel, Tag<V> tag) {
        return new Tag<U>(rel.reverseConversion(tag.getValue()));
    }


    //@ Type preserving comparison of two tags
    private static <T extends Comparable<? super T>> int compareTags(Tag<T> tag, Tag<T> tag2) {
        return tag.compareTo(tag2);
    }

    //@ Merge floating ticks to set the time on clock to tag
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void mergeNullTick(Clock<?> clock, Tag<?> tag) {
        Tick<?> floating = clock.getFloatingTick();
        Tick<?> tagged = clock.getFirstTaggedTick();

        if ((tagged != null) && (tagged.getTag().equals(tag))) {
            // We have a tagged tick with the right tag, set it to now
            tagged.setNow(true);
            // and remove the floating tick if any
            if (floating != null) {
                if (floating.isGhost()) {
                    this.floatingGhosts_.remove(floating);
                }
                clock.removeTick((Tick) floating);
            }
        } else {
            if (floating != null) {
                // We don't have a matching tagged tick. If we have a non ghost floating tick, set it to now
                if (! floating.isGhost()) {
                    floating.setTag((Tag)tag);
                    floating.setNow(true);
                } else {
                    // If it was only a ghost, remove it.
                    this.floatingGhosts_.remove(floating);
                    clock.removeTick((Tick)floating);
                }
            }
        }
    }

    /*@ Update the closure of the tag relations according to known now ticks and their tag at the current instant. */
    private void updateTagRelationClosure() throws Exception {
        for (Clock<?> clock : this.clocks_) {
            sync_tags_.updateWithNowTick(clock);
        }
    }

    /*@ Get the current tag on a clock if known in the current tag relations closure. */
    @SuppressWarnings("unchecked")
	public <T extends Comparable<? super T>> Tag<T> getCurrentTag(Clock<T> clock) {
        for (ClockTagMap  map : this.sync_tags_.values()) {
            Tag<?> tag = map.get(clock);
            if (tag != null) {
                return (Tag<T>) tag;
            }
        }
        return null;
    }

    /*@ If none of the now ticks imply a tag on some clock which has no now tick,
     *  we could nevertheless set its first tick to "now" if it is greedy.
     *  However, this could be incompatible with some other clocks because of tag
     *  relations because this could put a tick in the past without having been present at some instant.
     *  Instead, we add a floating tick than may be merged with the first tick of the clock
     *  in case there are several clocks in this case and a choice must be made.
     */
    private boolean alignFloatingTime() throws Exception {
        boolean new_tick = false;

        for (Clock<?> clock : this.clocks_) {
            if ( (! clock.isGreedy()) || clock.hasTickNow() || (!clock.hasTicks()) ) {
                // If the clock is not greedy or already has a "now" tick or has no ticks, skip it
                continue;
            }
            Tag<?> ctag = getCurrentTag(clock);
            if (ctag == null) {
                // If the clock does not have a tag according to some other "now" tick, it floats
                // so add a ghost tick to allow it to have a tick now
                Tick<?> t = clock.newTick(null).setNow(true);
                this.floatingGhosts_.add(t);
                new_tick = true;
            }
        }
        return new_tick;
    }

    /*@ Tell if a tick is a ghost and should not be considered as definitive in the current instant.
     *  A null tick is considered as a ghost because it does not exist.
     */
    public boolean isGhost(Tick<?> tick) {
        return (tick == null) || this.floatingGhosts_.contains(tick);
    }

    @Override
    public String toString() {
        return this.toString("");
    }

    public String toString(String message) {
        StringBuffer buf = new StringBuffer();
        buf.append(message);
        buf.append(System.getProperty("line.separator"));
        for (ImplicationRelation r : this.c_implications_) {
            buf.append(r.toString());
            buf.append(System.getProperty("line.separator"));
        }
        buf.append(System.getProperty("line.separator"));
        for (TagRelation<?,?> r : this.t_relations_) {
            buf.append(r.toString());
            buf.append(System.getProperty("line.separator"));
        }
        buf.append(System.getProperty("line.separator"));
        for (Clock<?> c : this.clocks_) {
            buf.append(c.toString());
            buf.append(System.getProperty("line.separator"));
        }
        return buf.toString();
    }

    private class ClockPrinter {
        private String message_;

        public ClockPrinter(String message) {
            this.message_ = message;
        }

        @SuppressWarnings("synthetic-access")
		@Override
        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append(this.message_);
            buf.append(Logger.EOL);
            for (ImplicationRelation r : ClockSet.this.c_implications_) {
                buf.append(Logger.TAB);
                buf.append(r.toString());
                buf.append(Logger.EOL);
            }
            for (TagRelation<?,?> r : ClockSet.this.t_relations_) {
                buf.append(Logger.TAB);
                buf.append(r.toString());
                buf.append(Logger.EOL);
            }
            //	    for (Clock<?> c : clocks_) {
            for (Clock<?> c : getClocks()) {  // getAllClocks for debugging?
                buf.append(Logger.TAB);
                buf.append(c.toString());
                buf.append(Logger.EOL);
            }
            return buf.toString();
        }
    }
}
