package com.github.vjames19.datastructures.graph.traversal

import com.github.vjames19.datastructures.graph.Graph
import com.github.vjames19.datastructures.set.HashSet

/**
 * Created by vjames19 on 2/21/16.
 */
abstract class BaseTraversal<V>(val graph: Graph<V>) : Traversal<V> {

    protected val visited = HashSet<V>()

    init {
        for (v in graph.vertices()) {
            if (!hasBeenVisited(v)) {
                dfs(v)
            }
        }
    }

    protected fun hasBeenVisited(v: V) = visited.contains(v)

    protected fun markAsVisited(v: V) = visited.add(v)

    protected abstract fun dfs(v: V)
}