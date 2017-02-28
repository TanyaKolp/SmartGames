package com.tania;

/**
 * Created by tania on 28.02.17.
 */
public class Test {
    public static void main(String[] args) {
        FindNumber findNumber = new FindNumber(4, 5, 6);
        System.out.println("Z array");
        for (int i = 0; i < findNumber.arrayZ.length; i++) {
            System.out.print(findNumber.arrayZ[i] + "-");
        }
        System.out.println("\nX array");
        for (int i = 0; i < findNumber.arrayX.length; i++) {
            System.out.print(findNumber.arrayX[i] + "-");
        }
        System.out.println("\nY array");
        for (int i = 0; i < findNumber.arrayY.length; i++) {
            System.out.print(findNumber.arrayY[i] + "-");
        }

    }

    public static int method1(int a, int n) {
        int p = 0;
        if (n == 0) {
            p = 1;
        } else if (n % 2 == 0) {
//'%' in Java - modulus operator
            p = method1(a, n / 2) * method1(a, n / 2);
        } else {
            p = method1(a, n - 1) * a;
        }
        return p;
    }
    public static int improvedMethod1(int a, int n) {
        int p;
        if (n == 0) {
            p = 1;
        } else {
            p = method1(a, n - 1) * a;
        }
        return p;
    }

}
