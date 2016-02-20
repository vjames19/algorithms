package com.github.vjames19.sort

/**
 * Created by vjames19 on 2/19/16.
 */
class MergeSort<E : Comparable<E>> : Sort<E> {

    override fun sort(list: MutableList<E>) {
        val sorted = mergeSort(list)
        list.clear()
        list.addAll(sorted)
    }

    fun mergeSort(list: MutableList<E>): MutableList<E> {
        if (list.size <= 1) {
            return list
        } else {
            val size = list.size
            val mid = list.size / 2
            val a = mergeSort(list.subList(0, mid))
            val b = mergeSort(list.subList(mid, size))
            return merge(a, b)
        }
    }

    fun merge(a: List<E>, b: List<E>): MutableList<E> {
        val merged = mutableListOf<E>()

        var i = 0
        var j = 0
        while (i < a.size && j < b.size) {
            if (isLess(a[i], b[j])) {
                merged.add(a[i])
                i++
            } else {
                merged.add(b[j])
                j++
            }
        }

        merged.addAll(a.subList(i, a.size))
        merged.addAll(b.subList(j, b.size))

        return merged
    }
}