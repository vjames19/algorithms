package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class SelectionSort<E : Comparable<E>> : Sort<E> {

    override fun sort(list: MutableList<E>) {
        for (i in 0..list.lastIndex) {
            var min = i
            for (j in i+1..list.lastIndex) {
                if (isLess(list[j], list[min])) {
                    min = j;
                }
            }

            list.swap(i, min)
        }
    }
}