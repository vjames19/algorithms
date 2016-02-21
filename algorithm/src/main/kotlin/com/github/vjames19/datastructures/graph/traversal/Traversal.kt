package com.github.vjames19.datastructures.graph.traversal

/**
 * Created by vjames19 on 2/21/16.
 */
interface Traversal<V> {
    fun traverse(): Iterable<V>
}