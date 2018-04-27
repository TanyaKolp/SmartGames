package com.tania.custom_queue;

public class MyQueryArrayImpl<E> implements MyQueueInterface<E> {
    private int tailIndex;
    private int headIndex;

    private E[] array;

    public MyQueryArrayImpl() {
        array = (E[]) new Object[10];
    }

    public MyQueryArrayImpl(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E el) {
        checkCapasity(array.length + 1);
    }

    private void checkCapasity(int i) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }
}
