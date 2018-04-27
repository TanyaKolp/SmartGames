package com.tania.sobes.inheritance;

public class SuperBase {
    String x = "A";

    public void printX() {
        System.out.println(x);
    }
}

class Base extends SuperBase {
    String x = "B";

    Base() {
        x = null;
    }
}

class Child extends Base {
}

class Aa {
    public Base method() {
        return new Base();
    }
}

class SubAa extends Aa {
    public Child method() {
        return new Child();
    }
}