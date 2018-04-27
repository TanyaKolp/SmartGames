package com.tania.custom_queue;

public interface MyQueueInterface<E> {

    void enqueue(E el);

    E dequeue();

    boolean isEmpty();
}
