package com.github.vjames19.datastructures.set

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/20/16.
 */
abstract class BaseSetTest(val createSet: () -> Set<Int>) {

    lateinit var set: Set<Int>

    @Before
    fun setup() {
        set = createSet()
    }

    @Test
    fun newSetShouldBeEmpty() {
        assertTrue(set.isEmpty())
        assertEquals(0, set.size())
    }

    @Test
    fun add() {
        val list = (0..10).toList()
        set.addAll(list)

        list.forEach {
            assertTrue(set.contains(it))
        }
    }

    @Test
    fun contains() {
        set.add(1)
        assertTrue(set.contains(1))

        set.add(100)
        assertTrue(set.contains(100))

        assertFalse(set.contains(1000))
    }

    @Test
    fun size() {
        val list = (0..1000).toList().apply {
            forEach {
                set.add(it);
            }
        }

        assertEquals(list.size, set.size())
    }

    @Test
    fun clear() {
        val list = (0..1000).toList()
        set.addAll(list)

        set.clear()

        assertTrue(set.isEmpty())
    }

    @Test
    fun union() {
        val list1 = (0..10 step 2).toList()
        val list2 = (1..10).toList()

        set.addAll(list1)

        val set2 = createSet()
        set2.addAll(list2)


        set.union(set2)

        list1.toMutableList().apply {
            addAll(list2)

            assertTrue(set.toList().containsAll(this))
        }
    }

    @Test
    fun intersection() {
        val list1 = (0..10 step 2).toList()
        val list2 = (1..10).toList()

        set.addAll(list1)

        val set2 = createSet()
        set2.addAll(list2)


        set.intersection(set2)

        assertFalse(set.contains(0))
        assertTrue(set.toList().containsAll(list1.subList(1, list1.size)))
    }

    @Test
    fun differenceWithAllElementsInCommon() {
        val list1 = (0..10 step 2).toList()

        set.addAll(list1)

        val set2 = createSet()
        set2.addAll(list1)

        set.difference(set2)

        assertTrue(set.isEmpty())
    }

    @Test
    fun differenceDisjoint() {
        val list1 = (0..10).toList()
        val list2 = (11..20).toList()


        set.addAll(list1)

        val set2 = createSet()
        set2.addAll(list2)

        set.difference(set2)

        assertTrue(set.toList().containsAll(list1))
    }

    @Test
    fun differenceWithSomeElementsInCommon() {
        val list1 = (0..10).toList()
        val list2 = (0..5).toList()


        set.addAll(list1)

        val set2 = createSet()
        set2.addAll(list2)

        set.difference(set2)

        assertTrue(set.toList().containsAll((6..10).toList()))
    }
}