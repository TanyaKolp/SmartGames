package com.tania.sobes;

import com.tania.entity.Item;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetComparator {
    public static void main(String[] args) {

        go();
        Set<Integer> set = new TreeSet();
        set.add(new Integer(1));
        set.add(new Integer(1));
        set.add(new Integer(1));
        System.out.println("size = " + set.size());

        Set<Item> set2 = new TreeSet<>();
        set2.add(new Item());
        set2.add(new Item());
        set2.add(new Item());
        System.out.println("size = " + set2.size());



    }

    public static void go() {
        System.out.println("1");
        try {
            System.out.println("g");
        } catch (Exception e) {
            System.out.println("e");
        } finally {
            System.out.println("f");
        }
        System.out.println("2");
    }

}
