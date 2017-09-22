package com.tania.streamplay;

import com.tania.Data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        System.out.println("result " + b);

//cant reuse stream, but can reuse streamSupplier))
        /**
         * Stream<String> stream =
         Stream.of("d2", "a2", "b1", "b3", "c")
         .filter(s -> s.startsWith("a"));

         stream.anyMatch(s -> true);    // ok
         stream.noneMatch(s -> true);   // exception
         */
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
        IntSummaryStatistics collect = Stream.of(123, 1, 232, 23432432, 12232, 344, 233, 123)
                .collect(Collectors.summarizingInt(i -> i));
        System.out.println(collect);
        String s = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining());
        String smart = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining(" and "));
        String fullUse = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining(" and ", "Bred of ", " ended"));
      Stream.of(" ", "").distinct();
        System.out.println(s);
        System.out.println(smart);
        System.out.println(fullUse);


    }
}
