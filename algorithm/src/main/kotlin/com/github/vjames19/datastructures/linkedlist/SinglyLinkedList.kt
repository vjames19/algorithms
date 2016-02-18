package com.github.vjames19.datastructures.linkedlist

/**
 * Created by vjames19 on 2/17/16.
 */
class SinglyLinkedList<E> : LinkedList<E> {

    private var size: Int = 0

    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    override fun size() = size

    override fun isEmpty() = size == 0

    override fun first() = head?.element

    override fun last() = tail?.element

    override fun addFirst(element: E) {
        head = Node(element, head)

        if (isEmpty()) {
             tail = head
        }

        size++
    }

    override fun addLast(element: E) {
        val newest = Node(element, null)

        if (isEmpty()) {
            addFirst(element)
        } else {
            tail!!.next = newest
            tail = newest
            size++
        }
    }

    override fun removeFirst(): E? {
        if (isEmpty()) {
            return null
        } else {
            val element = first()

            head = head!!.next;
            size--

            return element
        }
    }

    override fun removeLast(): E? {
        if (isEmpty()) {
            return null
        } else {
            if (size() == 1) {
                return removeFirst()
            } else {
                val element = last();

                var runner = head
                while(runner!!.next != tail) {
                    runner = runner.next
                }

                runner.next = null
                tail = runner

                size--

                return element
            }
        }
    }

    override fun clear() {
        while(!isEmpty()) {
            removeFirst();
        }
    }

    private data class Node<E>(var element: E, var next: Node<E>?)
}