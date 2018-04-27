package com.tania.sobes;

public class ПоследовательностьИнит {
    public static void main(String[] args) {
        new Test().m();
    }
}

class BaseTest {
    static {
        System.out.println("1Base-static");
    }

    {
        System.out.println("2Base-Non static");
    }

    public BaseTest() {
        System.out.println("3Base-constructor");
    }
}

class Test extends BaseTest {
    static {
        System.out.println("4Child-static");
    }

    {
        System.out.println("5Child-Non static");
    }

    public Test() {
        System.out.println("6Child-constructor");
    }


    public int m() {
//        return (true ? null : 0);
    return new Integer(0);
    }

}
