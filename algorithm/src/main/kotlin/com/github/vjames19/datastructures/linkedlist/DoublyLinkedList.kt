package com.github.vjames19.datastructures.linkedlist

/**
 * Created by vjames19 on 2/17/16.
 */
class DoublyLinkedList<E> : LinkedList<E> {

    private var size: Int = 0

    private var head: Node<E>
    private var tail: Node<E>

    init {
        head = Node(null, null, null)
        tail = Node(null, head, null)
        head.next = tail
    }

    override fun size() = size

    override fun isEmpty() = size == 0

    override fun first() = head.next!!.element

    override fun last() = tail.previous!!.element

    override fun addFirst(element: E) {
        addBetween(element, head, head.next!!)
    }

    override fun addLast(element: E) {
        addBetween(element, tail.previous!!, tail)
    }

    private fun addBetween(element: E, prev: Node<E>, next: Node<E>) {
        val node = Node(element, prev, next)

        prev.next = node
        next.previous = node

        size++
    }

    override fun removeFirst(): E? {
        if (isEmpty()) {
            return null
        } else {
            val element = first()

            remove(head.next!!)

            return element
        }
    }

    private fun remove(node: Node<E>) {
        val previous = node.previous
        val next = node.next

        previous!!.next = next
        next!!.previous = previous

        size--
    }

    override fun clear() {
        while(!isEmpty()) {
            removeFirst();
        }
    }

    private data class Node<E>(var element: E?, var previous: Node<E>?, var next: Node<E>?)
}