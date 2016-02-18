package com.github.vjames19.datastructures.queue

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/17/16.
 */
abstract class BaseQueueTest {

    var queue = createQueue()

    abstract fun createQueue(): Queue<Int>

    @Before
    fun setup() {
        queue = createQueue()
    }

    @Test
    fun testNewQueueShouldBeEmpty() {
        assertTrue(queue.isEmpty())
    }

    @Test
    fun testWhenAddingElementsItShouldNotBeEmpty() {
        queue.enqueue(1)
        assertEquals(1, queue.size())

        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(1)
        assertEquals(4, queue.size())

        assertFalse(queue.isEmpty())
    }

    @Test
    fun testRemovingElementsShouldDecrementTheSize() {
        queue.enqueue(1)
        queue.enqueue(2)

        queue.dequeue()
        assertEquals(1, queue.size())

        queue.dequeue()
        assertEquals(0, queue.size())
        assertTrue(queue.isEmpty())
    }

    @Test
    fun testDequeueShouldRemoveInFIFOFashion() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        assertEquals(1, queue.dequeue())
        assertEquals(2, queue.dequeue())
        assertEquals(3, queue.dequeue())
    }
    
    @Test
    fun testFirstShouldBeTheFirstEnqueued() {
        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(1, queue.first())

        queue.dequeue()

        assertEquals(2, queue.first())
    }
}
