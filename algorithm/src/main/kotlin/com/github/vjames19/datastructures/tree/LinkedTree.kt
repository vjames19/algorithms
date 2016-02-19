package com.github.vjames19.datastructures.tree

/**
 * Created by vjames19 on 2/19/16.
 */
class LinkedTree<E>(override var element: E) : Tree<E> {

    override var parent: Tree<E>? = null

    private val childrenList : MutableList<Tree<E>> = mutableListOf()

    override fun children(): List<Tree<E>> {
        return childrenList
    }

    override fun addChild(tree: Tree<E>) {
        tree.parent = this
        childrenList.add(tree)
    }

    override fun setChildren(children: List<Tree<E>>) {
        childrenList.clear()

        children.forEach {
            addChild(it)
        }
    }
}