package com.github.vjames19.datastructures.graph

import com.github.vjames19.datastructures.set.HashSet
import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class ConnectedComponent<V>(val graph: Graph<V>) {

    private var connectedCount = 0
    private val visited = HashSet<V>()
    private val id = HashMap<V, Int>()

    init {
        for (v in graph.vertices()) {
            if (!visited.contains(v)) {
                dfs(v)
                connectedCount++
            }
        }
    }

    private fun dfs(source: V) {
        visited.add(source)
        id.put(source, connectedCount)

        for (v in graph.adjecent(source)) {
            if (!visited.contains(v)) {
                dfs(v)
            }
        }
    }

    fun count() = connectedCount

    fun isConnected(v: V, w: V) = visited.contains(v) && visited.contains(w) && id[v] == id[w]
}