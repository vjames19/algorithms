package com.github.vjames19.datastructures.graph.traversal

import com.github.vjames19.datastructures.graph.Graph
import java.util.*

/**
 * Created by vjames19 on 2/21/16.
 */
class PreOrderTraversal<V>(graph: Graph<V>) : BaseTraversal<V>(graph) {

    val queue = LinkedList<V>()

    override fun dfs(v: V) {
        markAsVisited(v)
        queue.addLast(v)

        for (w in graph.adjecent(v)) {
            if (!hasBeenVisited(w)) {
                dfs(w)
            }
        }
    }

    override fun traverse() = queue
}