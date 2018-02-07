package com.tania.factory_pattern_play;

import com.google.common.collect.ImmutableMap;
import com.tania.factory_pattern_play.impl.DisComplex;
import com.tania.factory_pattern_play.impl.DisSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanya on 21.11.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Discount> discounts = getDiscounts();
        discounts.forEach(d ->
        d.changePrice(ImmutableMap.of()));
    }

    private static List<Discount> getDiscounts() {
        List<Discount> dis = new ArrayList<>();
        dis.add(new DisComplex());
        dis.add(new DisComplex());
        dis.add(new DisComplex());
        dis.add(new DisSimple());
        dis.add(new DisSimple());
        dis.add(new DisSimple());
        return dis;
    }

}
