package com.tania.streamplay;

import com.tania.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tanya on 14.09.17.
 */
public class Main {
    public static void main(String[] args) {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                }).forEach(s -> System.out.println(s));

        boolean b = Stream.of("a2", "a2", "a1", "a3", "ac")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .allMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        System.out.println("result "+b);

//        List list = Collections.singletonList("qwer");
        Data el = new Data("key", "v");
        List<Data> list =  Collections.singletonList(el);
//        List list = new ArrayList(Arrays.asList("qwer"));
        Data  d = list.get(0);
        d.setValue("new");
        list.set(0,new Data("key", "set"));
        System.out.println("Collections.singletonList");
        System.out.println(list.get(0));

        List<Data> arr = Arrays.asList(el);
        Data change = arr.get(0);
        change.setValue("new");
//        arr.add(0,"dfds");

        System.out.println("Arrays.asList");
        System.out.println(arr.get(0));
    }
}
