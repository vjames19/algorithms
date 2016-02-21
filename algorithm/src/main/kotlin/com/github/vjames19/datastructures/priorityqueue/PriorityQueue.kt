package com.github.vjames19.datastructures.priorityqueue

/**
 * Created by vjames19 on 2/19/16.
 */
interface PriorityQueue<K : Comparable<K>> {

    fun insert(key: K)
    fun max(): K
    fun delMax(): K
    fun isEmpty(): Boolean
    fun size(): Int

}