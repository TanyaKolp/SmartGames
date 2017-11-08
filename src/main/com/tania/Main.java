package com.tania;

import java.util.*;

import java.sql.Time;

/**
 * Created by tanya on 11.10.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println((new Byte("10") / 100.0));
        System.out.println((new Byte("10") / 100));
        Date now = java.sql.Date.valueOf("2017-01-01");
        int i = 0;
        Time time = Time.valueOf("16:44:50");
        if (time.after(now)) {
            System.out.println("yes");
        }
        if (now.after(time)) {
            System.out.println("now yes");
        }

        List<String> list = new ArrayList<>();
        if (i == 0) {
            list = null;
        }
//        list.forEach(s -> System.out.println(s));
//        String random = UUID.fromString(String.valueOf(System.currentTimeMillis())).toString();
        String random = UUID.randomUUID().toString();
        System.out.println("random=" + random);
        String[] split = "1234567".split("(?!^)");
        List<Integer> interger = Arrays.asList(1, 2, 3, 4, 5, 6);
        interger = Collections.emptyList();
        Optional<Integer> first = interger.stream().filter(integer -> integer == 9).findFirst();
        if (first.isPresent()) {
            System.out.println("y");
        } else {
            System.out.println("n");
        }
    }
}
