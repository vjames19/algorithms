package com.github.vjames19.datastructures.search

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by vjames19 on 2/20/16.
 */
class TrieSTTest : BaseSTTest({ TrieST() }) {

    @Test
    fun keys() {
        val list = (0..10).map { n -> "hola" + n }

        list.forEachIndexed { index, key ->
            st.put(key, index)
        }

        val trieST = st as TrieST
        assertTrue(trieST.keys().toList().containsAll(list))
    }


    @Test
    fun keysWithPrefix() {
        val hola = (0..10).map { n -> "hola" + n }
        hola.forEachIndexed { index, key ->
            st.put(key, index)
        }

        val holas = (0..10).map { n -> "holas" + n }
        holas.forEachIndexed { index, key ->
            st.put(key, index)
        }


        val trieST = st as TrieST
        assertTrue(trieST.keysWithPrefix("holas").toList().containsAll(holas))
    }

    @Test
    fun keysWithPrefixWithNoMatchingPrefixShouldBeEmpty() {
        val hola = (0..10).map { n -> "hola" + n }
        hola.forEachIndexed { index, key ->
            st.put(key, index)
        }

        val holas = (0..10).map { n -> "holas" + n }
        holas.forEachIndexed { index, key ->
            st.put(key, index)
        }


        val trieST = st as TrieST
        assertTrue(trieST.keysWithPrefix("olas").toList().isEmpty())
    }
}