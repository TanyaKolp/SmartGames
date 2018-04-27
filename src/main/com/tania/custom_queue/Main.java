package com.tania.custom_queue;

public class Main {
    public static void main(String[] args) {
        MyQueueInterface<Integer> myQueue = new MyQueueOfLinkedList<>();
        for (int i = 0; i < 10; i++) {
            myQueue.enqueue(i);
        }
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.dequeue());
        }
//        myQueue.dequeue();
        System.out.println("****");
        System.out.println(50 % 2);
        System.out.println(25/2);
        System.out.println(25 / 2 % 2);
    }

}
