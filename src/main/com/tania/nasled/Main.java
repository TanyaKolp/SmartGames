package com.tania.nasled;

/**
 * Created by tanya on 17.09.17.
 */
public class Main {
    public static void main(String[] args) {
        A a = new B();
        a.setPropA("aaa");

        DoClass doClass = new DoClass();
        doClass.doSmt(a);
    }
}
