package com.github.vjames19.datastructures.graph

import com.github.vjames19.datastructures.set.HashSet
import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class DepthFirstPath<V>(val graph: Graph<V>, val source: V) : Path<V> {

    private val visited = HashSet<V>()
    private val edgeToMap = HashMap<V, V>()

    init {
        dfs(source)
    }

    fun dfs(v: V) {

        visited.add(source)

        for (w in graph.vertices()) {
            if (!visited.contains(w)) {
                edgeToMap.put(w, v)
            }
        }
    }

    override fun hasPath(v: V) = visited.contains(v)

    override fun pathTo(v: V): Iterable<V> {
        if (!hasPath(v)) return emptyList()

        val stack = Stack<V>()
        var node = edgeToMap[v]

        while (node != source) {
            stack.push(node)
            node = edgeToMap[node]
        }

        stack.push(source)
        return stack
    }
}