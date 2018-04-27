package com.tania.sobes.inheritance;

class A {
    // Init here
    final static int finalStatic = 1;


    void m1(A a) {
        System.out.print("A");
    }

    public void privateMethod() {
        System.out.println("A");
    }

    public void method() {
        System.out.print("A");
    }
}

class B extends A {
    void m1(B b) {
        System.out.print("B");
    }

}

class C extends B {
    void m1(B c) {
        System.out.print("C");
    }

    public void privateMethod() {
        System.out.println("C");
    }

    public void method() {
        System.out.print("C");
    }
}
