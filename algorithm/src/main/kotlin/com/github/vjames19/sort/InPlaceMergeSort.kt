package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class InPlaceMergeSort<E : Comparable<E>> : Sort<E> {

    lateinit var helper: MutableList<E>

    override fun sort(list: MutableList<E>) {
        helper = list.toMutableList()
        mergeSort(list, 0, list.lastIndex)
    }

    fun mergeSort(list: MutableList<E>, low: Int, high: Int) {
        if (low < high) {
            val mid = low + (high - low) / 2
            mergeSort(list, low, mid)
            mergeSort(list, mid + 1, high)
            merge(list, low, mid, high)
        }
    }

    fun merge(list: MutableList<E>, low: Int, mid: Int, high: Int) {
        for (index in low..high) {
            helper[index] = list[index]
        }

        var i = low
        var j = mid + 1

        for (k in low..high) {
            if (i > mid) {
                list[k] = helper[j++]
            } else if (j > high) {
                list[k] = helper[i++]
            } else if (isLess(helper[i], helper[j])) {
                list[k] = helper[i++]
            } else {
                list[k] = helper[j++]
            }
        }
    }
}