package com.github.vjames19.datastructures.linkedlist

/**
 * Created by vjames19 on 2/17/16.
 */
interface LinkedList<E> {
    fun size(): Int

    fun isEmpty(): Boolean

    fun first(): E?

    fun last(): E?

    fun addFirst(element: E)

    fun addLast(element: E)

    fun removeFirst(): E?

    fun removeLast(): E?

    fun clear()
}