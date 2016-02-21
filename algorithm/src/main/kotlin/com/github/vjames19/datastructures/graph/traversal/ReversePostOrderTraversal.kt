package com.github.vjames19.datastructures.graph.traversal

import com.github.vjames19.datastructures.graph.DirectedGraph
import java.util.*

/**
 * Created by vjames19 on 2/21/16.
 */
class ReversePostOrderTraversal<V>(graph: DirectedGraph<V>) : BaseTraversal<V>(graph) {

    val stack = Stack<V>()

    override fun dfs(v: V) {
        markAsVisited(v)


        for (w in graph.adjecent(v)) {
            if (!hasBeenVisited(w)) {
                dfs(w)
            }
        }

        stack.push(v)
    }

    override fun traverse() = stack

}