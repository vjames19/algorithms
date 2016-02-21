package com.github.vjames19.datastructures.graph

import com.github.vjames19.datastructures.set.HashSet
import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class DirectedCycle<V>(val graph: DirectedGraph<V>) {

    var hasCycle = false
        private set
        get() = cycle.isNotEmpty()

    private val onStack = HashSet<V>()
    private val visited = HashSet<V>()
    private val edgeToMap = HashMap<V, V>()
    private val cycle = Stack<V>()

    init {
        for (v in graph.vertices()) {
            if (!visited.contains(v)) {
                dfs(v)
            }
        }
    }

    private fun dfs(v: V) {
        visited.add(v)
        onStack.add(v)

        for (w in graph.adjecent(v)) {
            if (hasCycle) return
            if (!visited.contains(v)) {
                edgeToMap.put(w, v)
                dfs(v)
            } else if (onStack.contains(w)) {
                var node = edgeToMap[v]
                while (node != w) {
                    cycle.push(node)
                    node = edgeToMap[v]
                }

                cycle.push(w)
                cycle.push(v)
            }
        }
    }


}