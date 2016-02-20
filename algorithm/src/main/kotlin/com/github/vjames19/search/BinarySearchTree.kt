package com.github.vjames19.search

/**
 * Created by vjames19 on 2/20/16.
 */
class BinarySearchTree<Key: Comparable<Key>, Value>: ST<Key, Value> {

    data class Node<Key, Value>(var key: Key, var value: Value, var left: Node<Key, Value>? = null, var right: Node<Key, Value>? = null)

    private var root: Node<Key, Value>? = null

    var size = 0
        private set

    override fun get(key: Key): Value? {
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

    override fun put(key: Key, value: Value) {
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

    override fun remove(key: Key) {
        root = remove(root, key)
    }

    private fun remove(root: Node<Key, Value>?, key: Key): Node<Key, Value>? {
        if (root == null) {
            return null
        } else {
            val comparison = key.compareTo(root.key)

            if (comparison < 0) {
                root.left = remove(root.left, key)
            } else if (comparison > 0) {
                root.right = remove(root.right, key)
            } else {
                size--

                if (root.right == null) return root.left
                if (root.left == null) return root.right

                val temp = root
                val replacement = min(temp.right)!!
                replacement.left = root.left
                replacement.right = remove(temp.right, replacement.key)
                return replacement
            }

            return root
        }
    }

    fun min(): Key? {
        return min(root)?.key
    }

    private tailrec fun min(root: Node<Key, Value>?): Node<Key, Value>? {
        if (root?.left == null) {
            return root
        } else {
            return min(root?.left)
        }
    }

    fun max(): Key? {
        return max(root)?.key
    }

    private tailrec fun max(root: Node<Key, Value>?): Node<Key, Value>? {
        if (root?.right == null) {
            return root
        } else {
            return max(root?.right)
        }
    }

    fun floor(key: Key): Key? {
        return floor(root, key)?.key
    }

    private fun floor(root: Node<Key, Value>?, key: Key): Node<Key, Value>? {
        if (root == null) {
            return null
        } else {
            val comparison = key.compareTo(root.key)

            if (comparison == 0) {
                return root
            } else if (comparison < 0) {
                return floor(root.left, key)
            } else {
                val node = floor(root.right, key)
                return node ?: root
            }
        }
    }
}