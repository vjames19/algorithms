package com.github.vjames19.datastructures.graph

import com.github.vjames19.datastructures.set.HashSet
import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class BreadthFirstPath<V>(val graph: Graph<V>, val source: V) : Path<V> {

    private val visited = HashSet<V>()
    private val edgeToMap = HashMap<V, V>()

    init {
        bfs(source)
    }

    fun bfs(v: V) {

        val queue = LinkedList<V>()
        visited.add(v)
        queue.addLast(v)

        while (!queue.isEmpty()) {
            val v = queue.removeFirst()
            for (w in graph.adjecent(v)) {
                if (!visited.contains(w)) {
                    visited.add(w)

                    edgeToMap.put(w, v)
                    queue.addLast(w)
                }
            }
        }
    }

    override fun hasPath(v: V) = visited.contains(v)

    override fun pathTo(v: V): Iterable<V> {
        if (!hasPath(v)) return emptyList()

        val stack = Stack<V>()
        var node = edgeToMap[v]

        while (node != null) {
            stack.push(node)
            node = edgeToMap[node]
        }

        stack.push(source)
        return stack
    }
}