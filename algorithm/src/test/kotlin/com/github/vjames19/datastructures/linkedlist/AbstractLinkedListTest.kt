package com.github.vjames19.datastructures.linkedlist

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/17/16.
 */
abstract class AbstractLinkedListTest {

    var list: LinkedList<Int> = createList()

    abstract fun createList(): LinkedList<Int>

    @Before
    fun setup() {
        list = createList()
    }

    @Test
    fun newListShouldBeEmpty() {
        assertTrue(list.isEmpty())
    }

    @Test
    fun testWhenAddingElementsItShouldNotBeEmpty() {
        list.addFirst(1)

        assertEquals(1, list.size())

        list.addFirst(2)
        list.addLast(3)
        list.addFirst(1)

        assertEquals(4, list.size())
        assertFalse(list.isEmpty())
    }

    @Test
    fun testRemovingElementsShouldDecrementTheSize() {
        list.addFirst(1)
        list.addFirst(2)

        list.removeFirst()
        assertEquals(1, list.size())

        list.removeFirst()
        assertEquals(0, list.size())
        assertTrue(list.isEmpty())

    }

    @Test
    fun testWhenClearingTheListItShouldBeEmpty() {
        list.addFirst(1)
        list.addFirst(2)

        list.clear()

        assertTrue(list.isEmpty())
    }

    @Test
    fun testAddFirstShouldReturnTheLastAdded() {
        list.addFirst(1)
        list.addFirst(2)

        assertEquals(2, list.first())
    }

    @Test
    fun testAddLastShouldReturnTheLastAdded() {
        list.addFirst(1)
        list.addFirst(2)

        list.addLast(3)

        assertEquals(3, list.last())
    }

    @Test
    fun testRemoveFirstShouldRemoveTheFirst() {
        list.addLast(3)
        list.addFirst(1)
        list.addFirst(2)

        assertEquals(2, list.removeFirst())
        assertEquals(1, list.removeFirst())
        assertEquals(3, list.removeFirst())
    }

    @Test
    fun testRemoveLast() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)

        assertEquals(3, list.removeLast())
        assertEquals(2, list.removeLast())
        assertEquals(1, list.removeLast())
    }
}