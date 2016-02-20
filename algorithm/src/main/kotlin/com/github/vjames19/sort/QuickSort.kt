package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class QuickSort<E : Comparable<E>> : Sort<E> {

    override fun sort(list: MutableList<E>) {
        quickSort(list, 0, list.lastIndex)
    }

    fun quickSort(list: MutableList<E>, low: Int, high: Int) {
        if (low < high) {
            val partition = partition(list, low, high)
            quickSort(list, low, partition - 1)
            quickSort(list, partition + 1, high)
        }
    }

    private fun partition(list: MutableList<E>, low: Int, high: Int): Int {
        val pivot = list[low]

        var i = low
        var j = high + 1
        while (true) {
            while (isLess(list[++i], pivot)) if (i == high) break
            while (isLess(pivot, list[--j])) if (j == low) break

            if (i >= j) break;
            list.swap(i, j)
        }

        list.swap(low, j)

        return j
    }
}