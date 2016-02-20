package com.github.vjames19.datastructures.priorityqueue

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * Created by vjames19 on 2/19/16.
 */
abstract class BasePriorityQueueTest(val createPriorityQueue: (comparator: Comparator<Int>) -> PriorityQueue<Int>) {

    lateinit var priorityQueue: PriorityQueue<Int>

    @Before
    fun setup() {
        priorityQueue = createPriorityQueue(Comparator { a, b -> a.compareTo(b) })
    }

    @Test
    fun newPriorityQueueShouldBeEmpty() {
        assertTrue(priorityQueue.isEmpty())
        assertEquals(0, priorityQueue.size())
    }

    @Test
    fun sizeShouldIncrement() {
        val list = (0..10).toList()
        list.forEach {
            priorityQueue.insert(it)
        }

        assertEquals(list.size, priorityQueue.size())
        assertFalse(priorityQueue.isEmpty())
    }

    @Test
    fun delMax() {
        val list = (1..998).toList()

        list.forEach {
            priorityQueue.insert(it)
        }

        val result = mutableListOf<Int>()

        while(!priorityQueue.isEmpty()) {
            result.add(priorityQueue.delMax())
        }

        assertEquals(list.sortedDescending(), result)
        assertTrue(priorityQueue.isEmpty())
    }

    @Test
    fun delMaxWithRandomData() {
        val list = listOf(1, 5, 10, 2, -1, 3, 203, 1000, 23203, -11000)

        list.forEach {
            priorityQueue.insert(it)
        }

        val result = mutableListOf<Int>()

        while(!priorityQueue.isEmpty()) {
            result.add(priorityQueue.delMax())
        }

        assertEquals(list.sortedDescending(), result)
        assertTrue(priorityQueue.isEmpty())
    }

    @Test
    fun delMaxWithComparator() {
        priorityQueue = createPriorityQueue(Comparator { a, b -> b.compareTo(a)})

        val list = (1..997).toList()

        list.forEach {
            priorityQueue.insert(it)
        }

        val result = mutableListOf<Int>()

        while(!priorityQueue.isEmpty()) {
            result.add(priorityQueue.delMax())
        }

        assertEquals(list, result)
        assertTrue(priorityQueue.isEmpty())
    }
}