package com.tania.factory_pattern_play.impl;

import com.tania.factory_pattern_play.Discount;

import java.util.Map;

/**
 * Created by tanya on 21.11.17.
 */
public class DisComplex implements Discount {

    @Override
    public double changePrice(Map<String, Object> price) {
        System.out.println("FROM complex");
        return Integer.valueOf(price.get("count").toString()) % 2 == 0 ?
                Double.valueOf(price.get("price").toString()) / 2 :
                Double.valueOf(price.get("price").toString());
    }
}
