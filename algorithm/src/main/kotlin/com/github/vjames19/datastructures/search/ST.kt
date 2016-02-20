package com.github.vjames19.datastructures.search

/**
 * Created by vjames19 on 2/20/16.
 */
interface ST<Key : Comparable<Key>, Value> {

    fun get(key: Key): Value?
    fun put(key: Key, value: Value)
    fun remove(key: Key)
    fun contains(key: Key): Boolean
    fun size(): Int

}