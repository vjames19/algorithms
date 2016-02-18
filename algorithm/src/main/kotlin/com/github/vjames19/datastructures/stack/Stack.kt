package com.github.vjames19.datastructures.stack

/**
 * Created by vjames19 on 2/17/16.
 */
interface Stack<E> {
    fun push(element: E)

    fun pop(): E?

    fun top(): E?

    fun isEmpty(): Boolean

    fun size(): Int
}