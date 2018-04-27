package com.tania.custom_queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueueTwoStacks<E> implements MyQueueInterface<E> {
    private int size = 0;
    private Stack<E> input = new Stack<>();
    private Stack<E> output = new Stack<>();


    @Override
    public void enqueue(E el) {
        input.push(el);
        size++;

    }

    @Override
    public E dequeue() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        if (!output.empty()) {
            size--;
            return output.pop();
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
