package com.tania.sobes.compare;

import java.io.IOException;

public class ReloadMethd {

    public void method(Object o){
        System.out.println("obj");
    }
    public void method(A  o){
        System.out.println("str");
    }
    public void method(B o){
        System.out.println("int");
    }

    class A {
        void mThrowE() throws IndexOutOfBoundsException{

        }
    }
    class B extends A{
        @Override
        void mThrowE() throws NullPointerException {
            super.mThrowE();
        }
    }
}
