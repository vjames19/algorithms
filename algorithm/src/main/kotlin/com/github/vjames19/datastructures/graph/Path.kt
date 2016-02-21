package com.github.vjames19.datastructures.graph

/**
 * Created by vjames19 on 2/20/16.
 */
interface Path<V> {
    fun hasPath(v: V): Boolean

    fun pathTo(v: V): Iterable<V>
}