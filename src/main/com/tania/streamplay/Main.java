package com.tania.streamplay;

import com.tania.entity.Data;
import com.tania.entity.Item;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.*;
import java.util.function.Supplier;
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
        System.out.println("\nCOllect=" + collect);
        String s = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining());
        String smart = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining(" and "));
        String fullUse = Stream.of("d2", "a2", "b1", "b3", "c").collect(Collectors.joining(" and ", "Bred of ", " ended"));
        Stream.of(" ", "").distinct();
        System.out.println(s);
        System.out.println(smart);
        System.out.println(fullUse);


        List<Item> itemList = fillItemList();

        getStatisticsByField(itemList);

        getCountByObjName(itemList);

        getSumsByObjName(itemList);

        transformToNewObjList_getSumsByName(itemList);
    }

    private static void getStatisticsByField(List<Item> itemList) {
        System.out.println("\n*****");
        System.out.println("FULL statistics (sum count avg min max) by obj field");
        Map<String, DoubleSummaryStatistics> collect1 = itemList.stream()
                .collect(Collectors.groupingBy((i -> i.getName()), Collectors.summarizingDouble(i -> i.getPrice())));
        System.out.println("Summarize = " + collect1);
    }

    private static void transformToNewObjList_getSumsByName(List<Item> itemList) {
        System.out.println("\n*****");
        System.out.println("Transform list to list obj with sum fields");
        List<Optional<Item>> l = itemList.stream().collect(Collectors.groupingBy(item -> item.getName())).entrySet().stream()
                .map(e -> e.getValue().stream()
                        .reduce((i1, i2) -> new Item(i1.getName(), i1.getPrice() + i2.getPrice())))
                .collect(Collectors.toList());
        System.out.println("Result List =" + l);
    }

    private static void getSumsByObjName(List<Item> itemList) {
        System.out.println("\n*****");
        System.out.println("map key - sum by field");
        Map<String, Double> mapSum = itemList.stream()
                .collect(Collectors.groupingBy((i -> i.getName()), Collectors.summingDouble(i -> i.getPrice())));
        System.out.println("Item sum = " + mapSum);
    }

    private static void getCountByObjName(List<Item> itemList) {
        System.out.println("\n*****");
        System.out.println("map key - count by field");
        Map<String, Long> mapCount = itemList.stream().collect(Collectors.groupingBy((i -> i.getName()), Collectors.counting()));
        System.out.println("Item count = " + mapCount);
    }

    private static List<Data> fillDataList() {
        List<Data> items = new ArrayList<>();
        items.add(new Data("q", ""));
        items.add(new Data("q", ""));
        items.add(new Data("q", ""));
        items.add(new Data("q", ""));
        items.add(new Data("er", ""));
        items.add(new Data("er", ""));
        items.add(new Data("er", ""));
        items.add(new Data("er", ""));
        items.add(new Data("er", ""));
        items.add(new Data("tr", ""));
        items.add(new Data("tr", ""));
        items.add(new Data("tr", ""));
        items.add(new Data("tr", ""));
        items.add(new Data("tr", ""));
        return items;
    }

    public static List<Item> fillItemList() {
        List<Item> res = new ArrayList<>();
        res.add(new Item("q", 10.0));
        res.add(new Item("q", 10.0));
        res.add(new Item("q", 10.0));
        res.add(new Item("q", 10.0));
        res.add(new Item("w", 50.0));
        res.add(new Item("w", 50.0));
        res.add(new Item("w", 50.0));
        res.add(new Item("w", 50.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        res.add(new Item("r", 4.0));
        return res;
    }
}
