package com.tania;

import com.google.common.collect.ImmutableMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 14.08.17.
 */
public class TestFigny {
    public static void main(String[] args) {
        double price = 10.0;
        int count = 4;
        int amount = 3;
        int payAmount = 2;
        int a = count / amount;
        System.out.println(a);
        double sum = a * price * payAmount + price * (count - a * amount);
        System.out.println(sum);
        BigDecimal orderSum = BigDecimal.valueOf(200.10);
        Integer orderAmount = 20;
        BigDecimal minSum = BigDecimal.valueOf(10.2);
        Integer minCount = 10;
        boolean b = condition(orderSum, orderAmount, minSum, minCount);
        System.out.println(b);

    }

    private static boolean condition(BigDecimal orderSum, Integer orderAmount, BigDecimal minSum, Integer minCount) {
        if (minSum != null) {
            if (minCount != null) {
                return ((orderSum.compareTo(minSum) == 0 || orderSum.compareTo(minSum) > 0) && orderAmount >= minCount);
            } else {
                return (orderSum.compareTo(minSum) == 0 || orderSum.compareTo(minSum) > 0);
            }
        } else if (minCount != null) {
            return orderAmount >= minCount;
        }
        return false;
    }

    private static Collection getList(String asd) {
        List list = new ArrayList();
        list.add(asd);
        list.add(asd);
        list.add(asd);
        return list;
    }


}
