package com.github.vjames19.datastructures.graph.sort

import com.github.vjames19.datastructures.graph.DirectedCycle
import com.github.vjames19.datastructures.graph.DirectedGraph
import com.github.vjames19.datastructures.graph.traversal.ReversePostOrderTraversal

/**
 * Created by vjames19 on 2/21/16.
 */
class TopologicalSort<V>(val graph: DirectedGraph<V>) {

    var hasCycle = false
        private set

    lateinit var reversePostOrder: ReversePostOrderTraversal<V>
    init {
        val cycleFinder = DirectedCycle(graph)
        hasCycle = cycleFinder.hasCycle

        if (!hasCycle) {
            reversePostOrder = ReversePostOrderTraversal(graph)
        }
    }

    fun order(): Iterable<V> {
        if (hasCycle) {
            throw IllegalStateException("Graph has a cycle")
        }

        return reversePostOrder.traverse()
    }
}