package com.github.vjames19.datastructures.stack

import com.github.vjames19.datastructures.linkedlist.LinkedList
import com.github.vjames19.datastructures.linkedlist.SinglyLinkedList

/**
 * Created by vjames19 on 2/17/16.
 */
class LinkedListStack<E> : Stack<E> {

    private val stack: LinkedList<E> = SinglyLinkedList()

    override fun push(element: E) {
        stack.addFirst(element)
    }

    override fun pop() = stack.removeFirst()

    override fun top() = stack.first()

    override fun isEmpty() = stack.isEmpty()

    override fun size() = stack.size()
}