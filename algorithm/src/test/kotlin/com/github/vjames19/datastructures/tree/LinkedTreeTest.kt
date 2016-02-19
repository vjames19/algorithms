package com.github.vjames19.datastructures.tree

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by vjames19 on 2/19/16.
 */
class LinkedTreeTest {

    @Test
    fun treeWithNoChildrenShouldHaveHeightOf1() {
        val tree = LinkedTree(1)

        assertEquals(1, tree.height())
    }

    @Test
    fun height() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(LinkedTree(4))

        tree2.addChild(LinkedTree(5))

        assertEquals(4, root.height())
        assertEquals(3, tree1.height())
    }

    @Test
    fun depth() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)
        val tree3 = LinkedTree(4)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(tree3)

        assertEquals(0, root.depth())
        assertEquals(1, tree1.depth())
        assertEquals(2, tree2.depth())
        assertEquals(2, tree3.depth())
    }

    @Test
    fun isRoot() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(LinkedTree(4))
        tree2.addChild(LinkedTree(5))

        assertTrue(root.isRoot())
        assertFalse(tree1.isRoot())
        assertFalse(tree2.isRoot())
    }

    @Test
    fun isExternal() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)

        root.addChild(tree1)
        tree1.addChild(tree2)
        tree1.addChild(LinkedTree(4))

        assertTrue(tree2.isExternal())

        assertFalse(root.isExternal())
        assertFalse(tree1.isExternal())
    }

    @Test
    fun isInternal() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)

        root.addChild(tree1)
        tree1.addChild(tree2)
        tree1.addChild(LinkedTree(4))


        assertTrue(root.isInternal())
        assertTrue(tree1.isInternal())

        assertFalse(tree2.isInternal())
    }

    @Test
    fun root() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(LinkedTree(4))

        assertEquals(root, root.root())
        assertEquals(root, tree1.root())
        assertEquals(root, tree2.root())
    }

    @Test
    fun preOrder() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)
        val tree3 = LinkedTree(4)
        var tree4 = LinkedTree(5)
        var tree5 = LinkedTree(6)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(tree3)
        tree1.addChild(tree4)

        tree4.addChild(tree5)

        val preorder = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(preorder, root.preOrder().map { it.element })
    }

    @Test
    fun postOrder() {
        val root = LinkedTree(1)
        val tree1 = LinkedTree(2)
        val tree2 = LinkedTree(3)
        val tree3 = LinkedTree(4)
        var tree4 = LinkedTree(5)
        var tree5 = LinkedTree(6)

        root.addChild(tree1)

        tree1.addChild(tree2)
        tree1.addChild(tree3)
        tree1.addChild(tree4)

        tree4.addChild(tree5)

        val postOrder = listOf(3, 4, 6, 5, 2, 1)

        assertEquals(postOrder, root.postOrder().map { it.element })
    }
}