package com.github.vjames19.datastructures.graph

/**
 * Created by vjames19 on 2/20/16.
 */
interface DirectedGraph<V> : Graph<V> {
    fun inDegree(v: V): Int
    fun outDegree(v: V): Int
}