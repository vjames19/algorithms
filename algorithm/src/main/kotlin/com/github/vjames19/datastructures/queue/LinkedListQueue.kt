package com.github.vjames19.datastructures.queue

import com.github.vjames19.datastructures.linkedlist.SinglyLinkedList

/**
 * Created by vjames19 on 2/17/16.
 */
class LinkedListQueue<E>: Queue<E> {

    val queue = SinglyLinkedList<E>()

    override fun enqueue(element: E) = queue.addLast(element)

    override fun dequeue(): E? = queue.removeFirst()

    override fun first() = queue.first()

    override fun size() = queue.size()

    override fun isEmpty() = queue.isEmpty()
}