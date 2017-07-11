package com.tania;

import java.util.Set;

/**
 * Created by tania on 26.06.17.
 */
public class A {
    public static void main(String[] args) throws Throwable {
        Object obj = null;
        Long storeId = (Long) (obj != null ? 100L : null);
        System.out.println(storeId);

        Object obj2 = new Object();
        Long storeId2 = (Long) (obj2!= null ? 100L : 0L);
        System.out.println(storeId2);
        if (true) {
            System.out.println("throw Exc");
            //throw new Exception("kdj");
        }
        try {
            d();
        } finally {
            System.out.println("finally");
            System.out.println("time="+System.nanoTime());
        }

    }

    private static void d() {
        System.out.println("print: sm");
    }
}
