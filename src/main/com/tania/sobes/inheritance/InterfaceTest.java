package com.tania.sobes.inheritance;

public class InterfaceTest {
    interface Animal {
        void eat(); // eat something
        void sleep(); // sleep somewhere
        void walk(); // walk
        void run(); // walk very fast
    }

    class Cat implements Animal, Runnable {
        public void eat() {
            System.out.println("eat");
// eat whiskas, drink milk
        }
        public void sleep() {
// sleep in warm place
        }
        public void walk() {
// walk quietly
        }
        public void run() {
// ?????????????????????????
        }
    }

}
