package com.github.vjames19.datastructures.queue

import com.github.vjames19.datastructures.stack.DynamicArrayStack

/**
 * Created by vjames19 on 2/17/16.
 */
class DoubleStackQueue<E> : Queue<E> {

    val enqueue = DynamicArrayStack<E>()
    val dequeue = DynamicArrayStack<E>()

    override fun enqueue(element: E) = enqueue.push(element)

    override fun dequeue(): E? {
        if (dequeue.isEmpty()) {
            transferAllToDequeueStack()
        }

        return dequeue.pop()
    }

    override fun first(): E? {
        if (dequeue.isEmpty()) {
            transferAllToDequeueStack();
        }

        return dequeue.top()
    }

    private fun transferAllToDequeueStack() {
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop()!!)
        }
    }

    override fun size() = enqueue.size() + dequeue.size()

    override fun isEmpty() = size() == 0
}