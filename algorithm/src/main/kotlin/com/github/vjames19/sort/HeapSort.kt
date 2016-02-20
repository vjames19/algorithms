package com.github.vjames19.sort

import com.github.vjames19.datastructures.priorityqueue.ArrayHeapPriorityQueue
import java.util.*

/**
 * Created by vjames19 on 2/19/16.
 */
class HeapSort<E : Comparable<E>> : Sort<E>{

    override fun sort(list: MutableList<E>) {
        val heap = ArrayHeapPriorityQueue<E>(Comparator { a, b -> b.compareTo(a) })
        list.forEach {
            heap.insert(it)
        }

        list.clear()
        while(!heap.isEmpty()) {
            list.add(heap.delMax())
        }
    }
}