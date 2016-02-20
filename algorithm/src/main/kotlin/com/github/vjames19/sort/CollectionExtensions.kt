package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */

fun <E> MutableList<E>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun <T> Comparable<T>.isLess(other: T) = this.compareTo(other) < 0