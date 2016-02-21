package com.github.vjames19.datastructures.graph

import com.github.vjames19.datastructures.set.HashSet

/**
 * Created by vjames19 on 2/20/16.
 */
class DepthFirstSearch<V>(val graph: Graph<V>) {

    var count = 0
        private set

    val visited = HashSet<V>()

    fun dfs(v: V) {
        visited.add(v)
        count++

        for (vertex in graph.adjecent(v)) {
            if (!visited.contains(vertex)) {
                dfs(vertex)
            }
        }
    }
}