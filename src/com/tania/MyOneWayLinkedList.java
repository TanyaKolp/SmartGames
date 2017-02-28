package com.tania;

import javax.lang.model.element.Element;

/**
 * Created by tania on 27.02.17.
 */
public class MyOneWayLinkedList {
    private MyElement head;
    private int size;

    public void add(Object o) {
        MyElement newEl = new MyElement(o, null);
        size++;
        if (head == null) {
            head = newEl;
        } else {
            MyElement e = head;
            while (e.getNext() != null)
                e = e.getNext();
            e.setNext(newEl);
        }
    }

    public void add(MyElement o) {
        size++;
        if (head == null) {
            head = o;
        } else {
            MyElement e = head;
            while (e.getNext() != null)
                e = e.getNext();
            e.setNext(o);
        }
    }

    public void printList() {
        MyElement element = head;
        while (element != null) {
            System.out.print(element.getVal() + ", ");
            element = element.getNext();
        }
    }

    public void reverseLinkedList(MyOneWayLinkedList list) {
        MyElement currentEl = list.head;
        MyElement preEl = null;
        System.out.println("\nSize " + list.size);
        for (int i = 0; i < list.size; i++) {
            if (currentEl != null) {
                MyElement next = currentEl.getNext();
                currentEl.setNext(preEl);
                preEl = currentEl;
                currentEl = next;
            }
        }
        list.head = preEl;
    }

    public MyOneWayLinkedList reverseRecursively(MyOneWayLinkedList list) {

        MyElement currentEl = list.head;
        if (currentEl.getNext() == null) {
            MyOneWayLinkedList newList = new MyOneWayLinkedList();
            newList.add(new MyElement(currentEl.getVal(), null));
            return newList;
        }

        MyOneWayLinkedList newListRest = new MyOneWayLinkedList();
        newListRest.head = currentEl.getNext();

        MyElement endEl = new MyElement(  currentEl.getVal(), null);

        MyOneWayLinkedList myReverceLinkedList = reverseRecursively(newListRest);
        myReverceLinkedList.add(endEl);

        return myReverceLinkedList;
    }
    public MyOneWayLinkedList reverseRecursivelyEl(MyOneWayLinkedList list) {

        MyElement currentEl = list.head;
        if (currentEl.getNext() == null) {
            MyOneWayLinkedList newList = new MyOneWayLinkedList();
//            newList.add(new MyElement(currentEl.getVal(), null));
            currentEl.setNext(null);
            newList.add( currentEl);
            return newList;
        }

        MyOneWayLinkedList newListRest = new MyOneWayLinkedList();
        newListRest.head = currentEl.getNext();

//        MyElement endEl = new MyElement(  currentEl.getVal(), null);
        currentEl.setNext(null);
        MyElement endEl = currentEl;

        MyOneWayLinkedList myReverceLinkedList = reverseRecursively(newListRest);
        myReverceLinkedList.add(endEl);

        return myReverceLinkedList;
    }
}
