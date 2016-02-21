package com.github.vjames19.datastructures.graph

/**
 * Created by vjames19 on 2/20/16.
 */
interface Graph<V> {
    fun vertices(): Iterable<V>

    fun edges(): Int

    fun addEdge(v: V, w: V)

    fun adjecent(v: V): Iterable<V>

    fun degree(v: V): Int {
        return adjecent(v).toList().size
    }

    fun maxDegree(): Int {
        var max = 0

        for (v in vertices()) {
            max = Math.max(degree(v), max)
        }

        return max;
    }
}