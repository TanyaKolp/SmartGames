package com.tania;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import java.sql.Time;

/**
 * Created by tanya on 11.10.17.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        FignyClass fignyClass = new FignyClass();
        fignyClass.setEma("dsf");
        fignyClass.setQwe("");
        System.out.println(fignyClass);

        Field[] declaredFields = fignyClass.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
//            if(f.getType() == String.class )
            System.out.println("field " + f.get(fignyClass));
            if (f.getType() == String.class && Strings.isNullOrEmpty(f.get(fignyClass).toString()))
                f.set(fignyClass, null);
        }


        System.out.println("************************");
        System.out.println(0 < 0);

        System.out.println("************************");
        System.out.println(7 % 5);

        Random random = new Random();
        System.out.println(random.nextInt(15));
        System.out.println("***********Random*************");

        int size = 1;
        Random random2 = new Random();
        System.out.println(random2.nextInt(size));
        Random random3 = new Random();
        System.out.println(random3.nextInt(size));
        Random random4 = new Random();
        System.out.println(random4.nextInt(size));
        Random random5 = new Random();
        System.out.println(random5.nextInt(size));

        System.out.println("************************");

        System.out.println((int) (Math.random() * size));
        System.out.println((int) (Math.random() * size));
        System.out.println((int) (Math.random() * size));
        System.out.println((int) (Math.random() * size));

    }


    private static List getlist() {
        List<Map<String, Object>> res = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("kl", "dsklj");
        map.put("kl", "dsklj");
        map.put("kl", "dsklj");
        for (int i = 0; i < 3; i++) {
            res.add(map);
        }
        return res;
    }
}
