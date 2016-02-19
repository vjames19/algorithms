package com.github.vjames19.datastructures.stack

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created by vjames19 on 2/19/16.
 */
abstract class AbstractStackTest(val createStack: () -> Stack<Int>) {

    var stack = createStack();

    @Before
    fun setup() {
        stack = createStack();
    }

    @Test
    fun newStackShouldBeEmpty() {
        assertTrue(stack.isEmpty())
        assertEquals(0, stack.size())
    }

    @Test
    fun pushShouldIncreaseSize() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.size())
    }

    @Test
    fun popShouldDecreaseSize() {
        stack.push(1)
        stack.push(2)

        stack.pop()
        stack.pop()

        assertEquals(0, stack.size())
        assertTrue(stack.isEmpty())
    }

    @Test
    fun popShouldRemoveInLIFOFashion() {
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

}