package com.github.vjames19.datastructures.stack

/**
 * Created by vjames19 on 2/17/16.
 */
class DynamicArrayStack<E> : Stack<E> {

    private val stack = arrayListOf<E>()

    override fun push(element: E) {
        stack.add(element)
    }

    override fun pop() = if (isEmpty()) null else stack.removeAt(stack.lastIndex)

    override fun top() = stack.getOrNull(stack.lastIndex)

    override fun isEmpty() = stack.isEmpty()

    override fun size() = stack.size
}