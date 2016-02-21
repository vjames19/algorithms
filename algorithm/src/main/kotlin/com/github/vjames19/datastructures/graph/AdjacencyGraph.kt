package com.github.vjames19.datastructures.graph

import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class AdjacencyGraph<V> : Graph<V> {

    private var edges = 0

    private val vertices = HashMap<V, LinkedList<V>>()

    override fun vertices() = vertices.keys

    override fun edges() = edges

    override fun addEdge(v: V, w: V) {
        vertices.getOrPut(v, { LinkedList() }).push(w)
        vertices.getOrPut(w, { LinkedList() }).push(v)
    }

    override fun adjecent(v: V): Iterable<V> {
        throw UnsupportedOperationException()
    }
}