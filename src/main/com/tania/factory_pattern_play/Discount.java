package com.tania.factory_pattern_play;

import java.util.Map;

/**
 * Created by tanya on 21.11.17.
 */
public interface Discount {
    double changePrice(Map<String, Object> price);
}
