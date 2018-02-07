package com.tania.factory_pattern_play.impl;

import com.tania.factory_pattern_play.Discount;

import java.util.Map;

/**
 * Created by tanya on 21.11.17.
 */
public class DisSimple implements Discount {
    @Override
    public double changePrice(Map<String, Object> price) {
        System.out.println("FROM simple");
        return Double.valueOf(price.get("price").toString()) * 0.9;
    }
}
