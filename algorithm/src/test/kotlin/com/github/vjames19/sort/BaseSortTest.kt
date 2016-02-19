package com.github.vjames19.sort

import org.junit.Assert.assertTrue
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
        sort.isLess(1, 2)
    }

    @Test
    fun sortAlreadySorted() {
        val list = mutableListOf(1, 2, 3, 4, 5)

        sort.sort(list)

        assertTrue(isSorted(list))
    }

    @Test
    fun sortDescending() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list.sortDescending()

        sort.sort(list)

        assertTrue(isSorted(list))
    }

    @Test
    fun sortRandom() {
        val list = mutableListOf(1, 5, 10, 2, -1, 3, 203, 1000, 23203, -1000)

        sort.sort(list)

        assertTrue(isSorted(list))
    }

    private fun <E : Comparable<E>> isSorted(list: List<E>): Boolean {
        for (i in 1..list.lastIndex) {
            if (list[i].compareTo(list[i - 1]) < 0) {
                return false
            }
        }

        return true
    }
}