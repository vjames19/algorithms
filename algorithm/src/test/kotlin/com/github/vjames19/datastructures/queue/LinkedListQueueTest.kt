package com.github.vjames19.datastructures.queue

/**
 * Created by vjames19 on 2/17/16.
 */
class LinkedListQueueTest: AbstractQueueTest() {
    override fun createQueue() = LinkedListQueue<Int>()
}