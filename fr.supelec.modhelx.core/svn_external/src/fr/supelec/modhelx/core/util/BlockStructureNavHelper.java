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

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import fr.supelec.modhelx.core.abstractsemantics.ObservableEntity;
import fr.supelec.modhelx.core.ecore.Block;
import fr.supelec.modhelx.core.ecore.BlockStructure;
import fr.supelec.modhelx.core.ecore.Model;
import fr.supelec.modhelx.core.ecore.Pin;
import fr.supelec.modhelx.core.ecore.Relation;

/**
 * A navigation helper for walking block structures.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class BlockStructureNavHelper {
    /** The structure in which we navigate. */
    private BlockStructure structure_;
    /** Map from pins to their successors. */
    private Map<Pin, Set<Pin>> pin_successors_;
    /** Map from pins to their predecessors. */
    private Map<Pin, Set<Pin>> pin_predecessors_;
    /** Map from blocks to their successors (blocks with a pin which is the target of a relation from a pin of the block).*/
    private Map<Block, Set<Block>> block_successors_;
    /** Map from blocks to their predecessors (blocks with a pin which is the origin of a relation to a pin of the block).*/
    private Map<Block, Set<Block>> block_predecessors_;
    /** Map from blocks to their successors, with some relations filtered out. */
    private Map<Block, Set<Block>> filtered_block_successors_;
    /** Map from blocks to their predecessors, with some relations filtered out. */
    private Map<Block, Set<Block>> filtered_block_predecessors_;
    /** Set of internal relations (relations between pins that do not belong to the model) */
    private Set<Relation> internal_relations_;
    /** Set of internal relations, with some relations filtered out */
    private Set<Relation> filtered_internal_relations_;
    /** Set of input relations (relations from pins of the model to pins of the blocks) */
    private Set<Relation> input_relations_;
    /** Set of output relations (relations from pins of the blocks to pins of the model) */
    private Set<Relation> output_relations_;

    /** Build a new navigation helper for a block structure, filtering out relations according to a filter.*/
    public BlockStructureNavHelper(BlockStructure s, RelationFilter filter) {
        this.structure_ = s;
        this.pin_successors_ = new HashMap<Pin, Set<Pin>>();
        this.pin_predecessors_ = new HashMap<Pin, Set<Pin>>();
        this.block_successors_ = new HashMap<Block, Set<Block>>();
        this.block_predecessors_ = new HashMap<Block, Set<Block>>();
        this.internal_relations_ = new HashSet<Relation>();
        this.input_relations_ = new HashSet<Relation>();
        this.output_relations_ = new HashSet<Relation>();
        if (filter == null) {
            this.filtered_block_successors_ = this.block_successors_;
            this.filtered_block_predecessors_ = this.block_predecessors_;
            this.filtered_internal_relations_ = this.internal_relations_;
        } else {
            this.filtered_block_successors_ = new HashMap<Block, Set<Block>>();
            this.filtered_block_predecessors_ = new HashMap<Block, Set<Block>>();
            this.filtered_internal_relations_ = new HashSet<Relation>();
        }
        // Find relations between pins of the blocks of the structure, 
        // ignoring relations from and to the pins of the embedding model. 
        for (Relation r : s.getRelations()) {
            boolean src_is_model = r.getOrigin().getOwner() instanceof Model;
            boolean dst_is_model = r.getTarget().getOwner() instanceof Model;
            if (! (src_is_model || dst_is_model) ) {
                this.internal_relations_.add(r);
                addToMapSet(this.pin_successors_, r.getOrigin(), r.getTarget());
                addToMapSet(this.pin_predecessors_, r.getTarget(), r.getOrigin());
                addToMapSet(this.block_successors_, (Block)(r.getOrigin().getOwner()), (Block)(r.getTarget().getOwner()));
                addToMapSet(this.block_predecessors_, (Block)(r.getTarget().getOwner()), (Block)(r.getOrigin().getOwner()));
                if ((filter != null) && (filter.accept((fr.supelec.modhelx.core.abstractsemantics.Relation) r))) {
                    addToMapSet(this.filtered_block_successors_, (Block)(r.getOrigin().getOwner()), (Block)(r.getTarget().getOwner()));
                    addToMapSet(this.filtered_block_predecessors_, (Block)(r.getTarget().getOwner()), (Block)(r.getOrigin().getOwner()));
                    this.filtered_internal_relations_.add(r);
                }
            } else if (src_is_model) {
                this.input_relations_.add(r);
            } else {
                this.output_relations_.add(r);
            }
        }
    }

    /** Return internal relations (not involving the model) */
    public Collection<Relation> getInternalRelations() {
        return this.internal_relations_;
    }

    /** Return input relations (relations from pins of the model to pins of the blocks) */
    public Collection<Relation> getInputRelations() {
        return this.input_relations_;
    }

    /** Return output relations (relations from pins of the blocks to pins of the model) */
    public Collection<Relation> getOutputRelations() {
        return this.output_relations_;
    }

    /** Return internal relations (not involving the model) ignoring those that are filtered out */
    public Collection<Relation> getFilteredInternalRelations() {
        return this.filtered_internal_relations_;
    }

    /** Helper function to add a value to a list associate to a key in a map. */
    public static <U,V> void addToMapSet(Map<U, Set<V>> map, U key, V value) {
        Set<V> set = map.get(key);
        if (set == null) {
            set = new HashSet<V>();
            map.put(key,  set);
        }
        set.add(value);
    }

    /** Get the successors of pin <code>p</code> (pins that are the target of a relation with origin p). */
    public Collection<Pin> getPinSuccessors(Pin p) {
        Set<Pin> succ = this.pin_successors_.get(p);
        if (succ == null) {
            return new ArrayList<Pin>(0);
        }
        return succ;
    }

    /** Get the predecessors of pin <code>p</code> (pins that are the origin of a relation with target p). */
    public Collection<Pin> getPinPredecessors(Pin p) {
        Set<Pin> pred = this.pin_predecessors_.get(p);
        if (pred == null) {
            return new ArrayList<Pin>(0);
        }
        return pred;
    }

    /** Get the successors of block <code>b</code> (blocks with a pin which is a successor of a pin of b). */
    public Collection<Block> getBlockSuccessors(Block b) {
        Set<Block> succ = this.block_successors_.get(b);
        if (succ == null) {
            return new ArrayList<Block>(0);
        }
        return succ;
    }

    /** Get the predecessors of block <code>b</code> (blocks with a pin which is a predecessor of a pin of b). */
    public Collection<Block> getBlockPredecessors(ObservableEntity p) {
        Set<Block> pred = this.block_predecessors_.get(p);
        if (pred == null) {
            return new ArrayList<Block>(0);
        }
        return pred;
    }

    /** Get the successors of block <code>b</code>, with some relations filtered out. */
    public Collection<Block> getFilteredBlockSuccessors(ObservableEntity b) {
        Set<Block> succ = this.filtered_block_successors_.get(b);
        if (succ == null) {
            return new ArrayList<Block>(0);
        }
        return succ;
    }

    /** Get the predecessors of block <code>b</code>, with some relations filtered out. */
    public Collection<Block> getFilteredBlockPredecessors(Block p) {
        Set<Block> pred = this.filtered_block_predecessors_.get(p);
        if (pred == null) {
            return new ArrayList<Block>(0);
        }
        return pred;
    }

    /** Return a list of the blocks of the structure, topologically sorted. */
    public List<Block> topoSort() {
        Set<Block> visited_blocks = new HashSet<Block>();
        List<Block> ordered_blocks = new LinkedList<Block>();

        for (Block b : this.structure_.getBlocks()) {
            // Start from sink blocks
            if ( this.getFilteredBlockSuccessors((ObservableEntity)b).size() == 0 ) {
                this.visit(b, visited_blocks, ordered_blocks);
            }
        }
        return ordered_blocks;
    }

    /** Visit a block for topological sort. */
    private void visit(Block b, Set<Block> visited_blocks, List<Block> ordered_blocks) {
        if ( !visited_blocks.contains(b)) {
            visited_blocks.add(b);
            for (Block pred : this.getFilteredBlockPredecessors(b)) {
                this.visit(pred, visited_blocks, ordered_blocks);
            }
            ordered_blocks.add(b);
        }
    }
}
