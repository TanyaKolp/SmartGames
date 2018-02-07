package com.tania.count_sum_from_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 18.01.18.
 */
public class Main {


    private static int count = 1;
    private static double sale = 10.0;

    public static void main(String[] args) {
        List<Map<String, Object>> list = createList();
        System.out.println(list);

        addTotalMap(list);
        System.out.println(list);
    }

    private static void addTotalMap(List<Map<String, Object>> list) {
        Map<String, Object> total = new HashMap<>();
        list.forEach(map -> {
            for (String key : map.keySet()) {
                if (key.equals("name")) {
                    continue;
                }
                Object value = total.get(key);
                if (value == null) {
                    total.put(key, map.get(key));
                } else {
                    total.put(key, Double.valueOf(value.toString())
                            + Double.valueOf(map.get(key).toString()));
                }
            }
        });
        list.add(total);
    }

    private static List<Map<String, Object>> createList() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(createMap());
        }
        return list;
    }

    private static Map<String, Object> createMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        map.put("count", count);
        map.put("sale", sale);

        count++;
        sale = sale + 10.0;
        return map;
    }
}
