package com.github.vjames19.datastructures.search

import java.util.*

/**
 * Created by vjames19 on 2/20/16.
 */
class TrieST<Value> : ST<String, Value> {
    private var size = 0;

    private var root = Trie(null)

    private inner class Trie(var value: Value?) {
        val map = HashMap<Char, Trie>()
    }

    override fun get(key: String): Value? {
        return getNode(key)?.value
    }

    private fun getNode(key: String): Trie? {
        var trie = root
        key.forEachIndexed { index, c ->
            if (!trie.map.containsKey(c)) {
                return null
            } else {
                trie = trie.map[c]!!

                if (index == key.lastIndex) {
                    return trie
                }
            }
        }

        return null
    }

    override fun put(key: String, value: Value) {
        var trie = root

        key.forEachIndexed { index, c ->
            if (!trie.map.contains(c)) {
                trie.map.put(c, Trie(null))
            }

            trie = trie.map[c]!!

            if (index == key.lastIndex) {
                if (trie.value == null) size++
                trie.value = value
            }
        }
    }

    override fun contains(key: String): Boolean {
        return get(key) != null
    }

    override fun remove(key: String) {
        if (key.isEmpty()) {
            return
        } else if (root.map.contains(key[0])) {


            if (remove(root.map[key[0]], key, 0)) {
                root.map.remove(key[0])
            }
        }
    }

    private fun remove(trie: Trie?, key: String, depth: Int): Boolean {
        if (trie == null) {
            return true
        } else {
            if (depth == key.lastIndex) {
                // found it make its value null
                if (trie.value != null) {
                    trie.value = null
                    size--
                }
            } else {
                if (remove(trie.map[key[depth]], key, depth + 1)) {
                    trie.map.remove(key[depth])
                }
            }

            return trie.map.isEmpty()
        }
    }

    fun keys(): Iterable<String> {
        return keysWithPrefix("")
    }

    fun keysWithPrefix(prefix: String): Iterable<String> {
        val keys = ArrayList<String>()
        collectKeys(getNode(prefix), prefix, keys)
        return keys
    }

    private fun collectKeys(trie: Trie?, prefix: String, keys: ArrayList<String>) {
        if (trie == null) return
        if (trie.value != null) keys.add(prefix)

        trie.map.entries.forEach {
            collectKeys(it.value, prefix + it.key, keys)
        }
    }

    override fun size() = size
}