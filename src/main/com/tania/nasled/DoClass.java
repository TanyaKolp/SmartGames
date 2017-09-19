package com.tania.nasled;

/**
 * Created by tanya on 17.09.17.
 */
public class DoClass {
    void doSmt(A a){
        B b = (B) a;
        System.out.println(a.getPropA());
        System.out.println(b.getPropB());
    }
}
