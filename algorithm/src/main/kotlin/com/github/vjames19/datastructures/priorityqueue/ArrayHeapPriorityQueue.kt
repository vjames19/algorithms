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
        while (nodeIndex > 0 && isLess(parentIndex(nodeIndex), nodeIndex)) {
            heap.swap(parentIndex(nodeIndex), nodeIndex)
            nodeIndex = parentIndex(nodeIndex)
        }
    }

    fun sink(index: Int) {
        var nodeIndex = index
        while (hasLeftChild(nodeIndex)) {
            var maxChildIndex = leftIndex(nodeIndex)
            if (hasRightChild(nodeIndex) && isLess(maxChildIndex, maxChildIndex + 1)) {
                maxChildIndex++
            }

            if (isLess(nodeIndex, maxChildIndex)) {
                heap.swap(nodeIndex, maxChildIndex)
                nodeIndex = maxChildIndex
            } else {
                return
            }
        }
    }


    private fun parentIndex(index: Int) = (index - 1) / 2
    private fun leftIndex(index: Int) = index * 2 + 1
    private fun hasLeftChild(nodeIndex: Int) = leftIndex(nodeIndex) < size()
    private fun hasRightChild(nodeIndex: Int) = leftIndex(nodeIndex) + 1 < size()

    fun isLess(index1: Int, index2: Int) = comparator.compare(heap[index1], heap[index2]) < 0

}