package com.tania.sobes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindПересечениеOfArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2, 3, 7};
        int[] arr2 = new int[]{10, 9, 12, 3, 7};
        doWork(arr1, arr2);

        Map<String, Integer> map = new HashMap<>();
        map.put("ket", 22);
        for (String key : map.keySet()){
            System.out.println(map.get(key));
        }
    }

    private static void doWork(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            int sizeBefore = set.size();
            set.add(arr2[i]);
            if (sizeBefore == set.size()) {
                System.out.println(arr2[i]);
            }
        }

    }
}
