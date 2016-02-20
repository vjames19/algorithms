package com.github.vjames19.datastructures.search

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/20/16.
 */
abstract class BaseSTTest(val createST: () -> ST<String, Int>) {

    lateinit var st: ST<String, Int>

    @Before
    fun setup() {
        st = createST()
    }

    @Test
    fun newSTShouldBeEmpty() {
        assertEquals(0, st.size())
    }

    @Test
    fun put() {
        val list = (0..10).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        list.forEach {
            assertTrue("It doesn't contain " + it, st.contains(it))
        }
    }

    @Test
    fun get() {
        val list = (0..40).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        list.forEachIndexed { index, key ->
            assertEquals(index, st.get(key))
        }
    }

    @Test
    fun contains() {
        assertFalse(st.contains("not"))

        st.put("hola", 10)

        assertTrue(st.contains("hola"))
    }

    @Test
    fun removeShouldNotRemoveTheWrongKey() {
        val list = (10..30).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        st.remove("hola")

        list.forEachIndexed { index, key ->
            assertEquals(index, st.get(key))
        }
    }

    @Test
    fun removeShouldOnlyRemoveTheKey() {
        var list = (10..30).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        st.remove("hola19")

        list.toMutableList().apply {
            remove("hola19")

            forEachIndexed { index, key ->
                assertEquals(index, st.get(key))
            }
        }
    }

    @Test
    fun size() {
        val list = (0..10).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        assertEquals(list.size, st.size())
    }

}