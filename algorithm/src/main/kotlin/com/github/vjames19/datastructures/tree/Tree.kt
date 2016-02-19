package com.github.vjames19.datastructures.tree

/**
 * Created by vjames19 on 2/19/16.
 */
interface Tree<E>: Iterable<Tree<E>> {

    var element: E;

    var parent: Tree<E>?

    fun root(): Tree<E> {
        var tree = this;
        while(!tree.isRoot()) {
            tree = tree.parent!!
        }
        return tree;
    }

    fun children(): List<Tree<E>>

    fun addChild(tree: Tree<E>)

    fun setChildren(children: List<Tree<E>>)

    fun height(): Int {
        var height = 0;

        for (tree in children()) {
            height = Math.max(height, tree.height())
        }

        return 1 + height
    }

    fun depth(): Int {
        if (isRoot()) {
            return 0
        } else {
            return 1 + parent!!.depth()
        }
    }

    fun isRoot() = parent == null

    fun isInternal() = children().isNotEmpty()

    fun isExternal() = children().isEmpty()

    override fun iterator(): Iterator<Tree<E>> {
        return preOrder().iterator()
    }

    fun preOrder(): List<Tree<E>> {
        val snapshot = mutableListOf<Tree<E>>()
        preOrderSubtree(this, snapshot)
        return snapshot
    }

    private fun preOrderSubtree(tree: Tree<E>, snapshot: MutableList<Tree<E>>) {
        snapshot.add(tree)

        for (child in tree.children()) {
            preOrderSubtree(child, snapshot)
        }
    }

    fun postOrder(): List<Tree<E>> {
        val snapshot = mutableListOf<Tree<E>>()
        postOrderSubtree(this, snapshot)
        return snapshot;
    }

    private fun postOrderSubtree(tree: Tree<E>, snapshot: MutableList<Tree<E>>) {
        for (child in tree.children()) {
            postOrderSubtree(child, snapshot)
        }

        snapshot.add(tree)
    }
}