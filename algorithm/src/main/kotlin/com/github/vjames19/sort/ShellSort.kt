package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class ShellSort<E : Comparable<E>> : Sort<E> {

    override fun sort(list: MutableList<E>) {
        val N = list.size
        var h = 1
        while (h < N / 3) h = 3 * h + 1
        while (h >= 1) {
            for (i in h..list.lastIndex) {
                var j = i;
                while (j >= h && isLess(list[j], list[j - h])) {
                    list.swap(j, j - h)
                    j -= h
                }
            }

            h /= 3
        }
    }
}