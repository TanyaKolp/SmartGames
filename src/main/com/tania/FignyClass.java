package com.tania;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by tanya on 17.11.17.
 */

public class FignyClass {
    private String ema;
    private String qwe;
    private Integer nn;

    @Override
    public String toString() {
        return ema + " - " + qwe +" - "+nn;
    }

    public String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }

    public String getQwe() {
        return qwe;
    }

    public void setQwe(String qwe) {
        this.qwe = qwe;
    }

    public Integer getNn() {
        return nn;
    }

    public void setNn(Integer nn) {
        this.nn = nn;
    }

    public Map<String, String> doSth(Map<String, String> str) {

        str = ImmutableMap.of("dodo", "dodo");

        changeLinkAgain(str);

        System.out.println("in do ***");
        System.out.println(str);
        return str;
    }

    private void changeLinkAgain(Map<String, String> str) {
        System.out.println("******");
        System.out.println(str);
        str = ImmutableMap.of("hh","hh");
        System.out.println("in change ******");
        System.out.println(str);
    }
}

