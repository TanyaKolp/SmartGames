package com.tania.games;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tanya on 10.08.17.
 */
public class Lambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(vakue -> System.out.println(vakue));


    }
}
