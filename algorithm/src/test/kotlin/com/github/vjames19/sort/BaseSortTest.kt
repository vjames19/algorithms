package com.github.vjames19.sort

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/19/16.
 */
abstract class BaseSortTest(val createSort: () -> Sort<Int>) {

    lateinit var sort: Sort<Int>

    @Before
    fun setup() {
        sort = createSort()
    }

    @Test
    fun isLess() {
        sort.isLess(-1, 1)
    }

    @Test
    fun sortAlreadySorted() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        val expected = list.toList()

        sort.sort(list)

        assertEquals(expected, list)
    }

    @Test
    fun sortDescending() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        var expected = list.sorted()

        list.sortDescending()

        sort.sort(list)

        assertEquals(expected, list)
    }

    @Test
    fun sortRandom() {
        val list = mutableListOf(1, 5, 10, 2, -1, 3, 203, 1000, 23203, -11000)
        var expected = list.sorted()

        sort.sort(list)

        assertEquals(expected, list)
    }
}