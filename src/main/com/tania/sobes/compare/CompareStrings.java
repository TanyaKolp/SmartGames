package com.tania.sobes.compare;

import java.util.HashMap;
import java.util.Map;

/**
 * Даны 2 строки. вернуть true , если одну строку можно получить
 * из другой лишь 1 редактированием (удаление, вставка, замена)
 * (zxc, zxc) - false.
 * (zxc, zx) - true
 */
public class CompareStrings {
    public static void main(String[] args) {
        System.out.println("******Compare 2 strings******");
        System.out.print("Enter the first: ");
//        Scanner sc = new Scanner(System.in);
//        String first = sc.next();
        System.out.print("Enter the second: ");
//        String second = sc.next();

//        System.out.println("Result: " + compare(first, second));
        ReloadMethd rm = new ReloadMethd();
        rm.method(null);
        Map<String, Integer> map = new HashMap();
        map.put(null,2);
        map.put("0",null);
        System.out.println(map);
        Object s1 = new String("qwe");
        Object s2 = new String("qwe");
        System.out.print(s1 == s2);
    }

    private static boolean compare(String first, String second) {

        if (first.equals(second)) return false;
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        if (first.length() == second.length()) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (firstArr[i] != secondArr[i]) {
                    count++;
                }
            }
            return count == 1;
        } else {

            if (Math.abs(first.length() - second.length()) > 1) return false;
            if (first.length() - second.length() > 0) {
                for (int i = 0; i < second.length(); i++) {
                    if (firstArr[i] != secondArr[i]) {
                        return first.substring(i + 1)
                                .equals(second.substring(i));
                    }
                }
            } else {
                for (int i = 0; i < first.length(); i++) {
                    if (firstArr[i] != secondArr[i]) {
                        return second.substring(i + 1)
                                .equals(first.substring(i));
                    }
                }
            }
        }
        return true;
    }
}
