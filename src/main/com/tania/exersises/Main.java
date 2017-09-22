package com.tania.exersises;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Ex1 - Binary Tree\n");
        Tree test1 = new Tree();
        System.out.println("Max = " + test1.getMaxDepth(test1.setRoot()));

        System.out.println("\nEx2 - reverses the one-way linked list\n");
        MyOneWayLinkedList mylist = new MyOneWayLinkedList();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        System.out.println("initial list: ");
        mylist.printList();
        System.out.println("reverse list by iteration:");
        mylist.reverseLinkedList(mylist);
        mylist.printList();
        System.out.println("reverse again recursively:");
        MyOneWayLinkedList myOneWayLinkedList = mylist.reverseRecursively(mylist);
        MyOneWayLinkedList my = mylist.reverseRecursivelyEl(mylist);
        my.printList();

        System.out.println("\n\nEx3 - find number\n");
        FindNumber finder = new FindNumber(60, 8, 80);
        finder.printArrays();
        System.out.println("\nThe number is " + finder.findNumber());

        System.out.println("\nEx5 - power\n");
        int a = 3;
        int n = 4;
        System.out.println(a + " to the power of " + n);
        System.out.println("Original method = " + method1(a, n));
        System.out.println("Improved method = " + improvedMethod1(a, n));

        System.out.println("\nEx6 - swap\n");
        swapVariables(5, 10);
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
        if (n == 0) {
            return 1;
        }
        return method1(a, n - 1) * a;
    }

    public static void swapVariables(int a, int b) {
        System.out.println("Original values: " + "a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Result: " + "a = " + a + ", b = " + b);
    }
}
