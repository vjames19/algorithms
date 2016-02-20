package com.github.vjames19.datastructures.priorityqueue

import com.github.vjames19.sort.swap
import java.util.*

/**
 * Created by vjames19 on 2/19/16.
 */
class ArrayHeapPriorityQueue<K : Comparable<K>>(
        val comparator: Comparator<K> = Comparator { a, b -> a.compareTo(b) }) : PriorityQueue<K> {

    val heap = mutableListOf<K>()

    override fun insert(key: K) {
        heap.add(key)
        swim(heap.lastIndex)
    }

    override fun max() = heap[0]

    override fun delMax(): K {
        val key = max()

        heap.swap(0, heap.lastIndex)
        heap.removeAt(heap.lastIndex)
        sink(0)

        return key
    }

    override fun isEmpty() = size() == 0

    override fun size() = heap.size

    fun swim(index: Int) {
        var nodeIndex = index
        while (nodeIndex > 1 && isLess(parentIndex(nodeIndex), nodeIndex)) {
            heap.swap(parentIndex(nodeIndex), nodeIndex)
            nodeIndex = parentIndex(nodeIndex)
        }
    }

    fun sink(index: Int) {
        var nodeIndex = index
        while (leftIndex(nodeIndex) < size()) {
            var childIndex = leftIndex(nodeIndex)
            if (childIndex < size() - 1 && isLess(childIndex, childIndex + 1)) {
                childIndex++
            }

            if (isLess(nodeIndex, childIndex)) {
                heap.swap(nodeIndex, childIndex)
                nodeIndex = childIndex
            } else {
                return
            }
        }
    }

    fun parentIndex(index: Int) = (index - 1) / 2
    fun leftIndex(index: Int) = index * 2 + 1

    fun isLess(index1: Int, index2: Int) = comparator.compare(heap[index1], heap[index2]) < 0

}