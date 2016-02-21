package com.github.vjames19.datastructures.graph

import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
open class AdjacencyGraph<V> : Graph<V> {

    protected var edges = 0

    protected val vertices = HashMap<V, LinkedList<V>>()

    override fun vertices() = vertices.keys

    override fun edges() = edges

    override fun addEdge(v: V, w: V) {
        vertices.getOrPut(v, { LinkedList() }).push(w)
        vertices.getOrPut(w, { LinkedList() }).push(v)

        edges++
    }

    override fun adjecent(v: V) = vertices.getOrElse(v, { emptyList<V>() })
}