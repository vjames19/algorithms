package com.github.vjames19.datastructures.queue

/**
 * Created by vjames19 on 2/17/16.
 */
interface Queue<E> {
    fun enqueue(element: E)

    fun dequeue(): E?

    fun first(): E?

    fun size(): Int

    fun isEmpty(): Boolean
}