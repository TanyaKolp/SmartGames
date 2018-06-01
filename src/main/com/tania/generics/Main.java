package com.tania.generics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("ss");
        Set<Object> s2 = new HashSet();
        s2.add(new Object());

        System.out.println(wildcardType_question(s1, s2));
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, new Integer(42));
        String s = strings.get(0);
    }

    private static int wildcardType_question(Set<?> s1, Set<?> s2) {
        // s1.add("ss"); // compile error
        // s1.add(new Object()); // compile error
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }

        return result;
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
