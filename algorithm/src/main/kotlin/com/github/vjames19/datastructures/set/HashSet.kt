package com.github.vjames19.datastructures.set

import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class HashSet<E> : Set<E> {

    val map = HashMap<E, E?>()

    override fun add(e: E) {
        map.put(e, null)
    }

    override fun addAll(iterable: Iterable<E>) {
        iterable.forEach { add(it) }
    }

    override fun remove(e: E) {
        map.remove(e)
    }

    override fun contains(e: E) = map.contains(e)

    override fun clear() {
        map.clear()
    }

    override fun union(set: Set<E>) {
        set.forEach {
            map.putIfAbsent(it, null)
        }
    }

    override fun difference(set: Set<E>) {
        set.forEach {
            if (contains(it)) {
                remove(it)
            }
        }
    }

    override fun intersection(set: Set<E>) {
        toList().forEach {
            if (!set.contains(it)) {
                remove(it)
            }
        }
    }

    override fun iterator() = map.keys.iterator()

    override fun size() = map.size
}