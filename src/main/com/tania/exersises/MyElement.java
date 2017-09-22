package com.tania.exersises;

/**
 * Created by tania on 27.02.17.
 */
public class MyElement {
    private Object val;
    private MyElement next;

    public MyElement(Object val,MyElement next) {
        this.val = val;
        this.next = next;
    }

    public MyElement getNext() {
        return next;
    }

    public void setNext(MyElement next) {
        this.next = next;
    }

    public Object getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "el = "+ val;
    }
}
