package com.tania.runSQLfile;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tanya on 02.10.17.
 */
public class Main {
    public static void main(String[] args) {
        Arrays.asList(123, 13, 123, 1, 2, 3, 4, 5).forEach(integer -> {
            if (integer == 1) {
                return;
            }
            System.out.println(integer);
        });
    }


}
