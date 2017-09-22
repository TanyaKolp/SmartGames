package com.tania;

import java.util.*;

/**
 * Created by tania on 26.06.17.
 */
public class A {
    public static void main(String[] args) throws Throwable {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(String.valueOf(i));
        }
        set.add(null);
        List<String> list = new ArrayList<>();
        list.addAll(set);
        System.out.println(list);
        Map<String, String> stringStringMap =
                Collections.unmodifiableMap(new HashMap<String, String>() {
                    {
                        put("aa","aa");
                        put("aa","aa");
                        put("aa","aa");
                        put("aa","aa");
                    }

        });

        Object o = null;
        String ostr = o.toString();


    }

    private static void d() {
        System.out.println("print: sm");
    }
}
