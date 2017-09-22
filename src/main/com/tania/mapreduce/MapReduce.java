package com.tania.mapreduce;

import java.util.*;

/**
 * Created by tanya on 28.08.17.
 */
public class MapReduce {
    public static void main(String[] args) {
        String[] lines = new String[]{
                "How many vocals do", "",
                "these two lines have?"
        };

        Map<String, String> result = new HashMap<>();
        List<KeyValueObj> mapResult = new ArrayList<>();
        for (String line : lines) {
            List<KeyValueObj> map = map(line);
            if (map != null) {
                mapResult.addAll(map);
            }
        }
    }

    private static List<KeyValueObj> map(String line) {
        if (line.isEmpty()) {
            return null;
        }
        char[] chars = line.toCharArray();
        List<KeyValueObj> result = new ArrayList<>();
        for (char ch : chars) {
            result.add(new KeyValueObj(ch, 1));
        }
        return result;
    }

    private static List<KeyValueObj> groupByKey(List<KeyValueObj> mapResult) {
        List<KeyValueObj> result = new ArrayList<>();

        mapResult.sort(new Comparator<KeyValueObj>() {
            @Override
            public int compare(KeyValueObj o1, KeyValueObj o2) {
                if (o1.key < o2.key) {
                    return -1;
                } else if (o1.key > o2.key) {
                    return 1;
                }
                return 0;
            }
        });

        return result;
    }

    private static void reduce() {

    }
}

