package com.github.vjames19.datastructures.tree

/**
 * Created by vjames19 on 2/20/16.
 */
class BinarySearchTree<Key: Comparable<Key>, Value> {

    data class Node<Key, Value>(var key: Key, var value: Value, var left: Node<Key, Value>? = null, var right: Node<Key, Value>? = null)

    private var root: Node<Key, Value>? = null

    var size = 0
        private set

    fun get(key: Key): Value? {
        return get(root, key)
    }

    private fun get(root: Node<Key, Value>?, key: Key): Value? {
        if (root == null) {
            return null
        } else {
            val comparison = key.compareTo(root.key)

            if (comparison < 0) {
                return get(root.left, key)
            } else if (comparison > 0) {
                return get(root.right, key)
            } else {
                return root.value
            }
        }
    }

    private fun put(key: Key, value: Value) {
        root = put(root, key, value)
    }

    private fun put(root: Node<Key, Value>?, key: Key, value: Value): Node<Key, Value>? {
        if (root == null) {
            size++
            return Node(key, value)
        } else {
            val comparison = key.compareTo(root.key)

            if (comparison < 0) {
                root.left = put(root.left, key, value)
            } else if (comparison > 0) {
                root.right = put(root.right, key, value)
            } else {
                root.value = value
            }

            return root
        }
    }
}