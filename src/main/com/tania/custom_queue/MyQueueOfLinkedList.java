package com.tania.custom_queue;

import java.util.LinkedList;

public class MyQueueOfLinkedList<E> implements MyQueueInterface<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void enqueue(E el) {
        list.add(el);
    }

    @Override
    public E dequeue() {
        E first = list.getFirst();
        list.removeFirst();
        return first;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
