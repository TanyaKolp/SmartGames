package com.tania.sobes;

public class Tests {
    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 4, 5};
        new Object() {
            void twice() {
                for (int i = 0; i < array.length; ++i) {
                    array[i] *= 2;
                }
            }
        }.twice();
        for (int i = 0; i < array.length; i++) {
            System.out.println(
                    array[i]
            );
        }
    }
}
