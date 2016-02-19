package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
interface Sort<E: Comparable<E>> {

    fun sort(list: MutableList<E>)

    fun isLess(a: E, b: E) = a.compareTo(b) < 0
}