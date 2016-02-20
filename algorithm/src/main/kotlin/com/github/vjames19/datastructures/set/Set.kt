package com.github.vjames19.datastructures.set

/**
 * Created by vjames19 on 2/20/16.
 */
interface Set<E> : Iterable<E> {
    fun add(e: E)

    fun addAll(iterable: Iterable<E>)

    fun remove(e: E)

    fun contains(e: E): Boolean

    fun clear()

    fun size(): Int

    fun isEmpty() = size() == 0

    fun union(set: Set<E>)

    fun difference(set: Set<E>)

    fun intersection(set: Set<E>)
}