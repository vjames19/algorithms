package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class InsertionSort<E : Comparable<E>> : Sort<E> {

    override fun sort(list: MutableList<E>) {
        for (i in 1..list.lastIndex) {
            var j = i;
            while (j > 0 && isLess(list[j], list[j - 1])) {
                list.swap(j, j - 1)
                j--
            }
        }
    }
}