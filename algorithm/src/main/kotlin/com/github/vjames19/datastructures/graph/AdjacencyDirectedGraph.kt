package com.github.vjames19.datastructures.graph

import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class AdjacencyDirectedGraph<V> : DirectedGraph<V>, AdjacencyGraph<V>() {

    val indegrees = HashMap<V, Int>()

    override fun addEdge(v: V, w: V) {
        vertices.getOrPut(v, { LinkedList() }).push(w)
        vertices.getOrPut(w, { LinkedList() })
        edges++

        indegrees.compute(w, {v, indegree ->
            indegree + 1
        })
    }

    override fun inDegree(v: V): Int {
        throw UnsupportedOperationException()
    }

    override fun outDegree(v: V) = adjecent(v).size
}