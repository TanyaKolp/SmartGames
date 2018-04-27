package com.tania.sobes.inheritance;

public class Наследование {
    public static void main(String[] args) {
        A a = new B();
        a.method();

        System.out.println("****");
        Base base = new Base();
        System.out.println(base.x);
        base.printX();


    }
}
