package com.tania;

import java.util.*;

/**
 * Created by tania on 04.07.17.
 */
public class AAA {
    private static final String a = "sadsa";
    public Integer i;

    public AAA(Integer i) {
        this.i = i;
    }

    public Integer inc(Integer iparam) {
        if (iparam > 10) {
            return iparam;
        }
        return inc(++iparam);
    }

    public static void main(String[] args) {
        AAA a = new AAA(0);
        System.out.println(a.i);
        Map<String, Long> test = new HashMap<>();
        test.put("l", 123L);
        long realLong = Long.parseLong("123");
        System.out.println(realLong);
        String falseLong = Long.toString(test.get("l"));
        System.out.println(falseLong);
        List<LinkedHashMap<String, Object>> calendarList = new ArrayList<>();
        for (String s : ReportCreator.VALUES_NAMES) {
            LinkedHashMap<String, Object> adsf = new LinkedHashMap<>();
            adsf.put(s, s);
            calendarList.add(adsf);
        }
        PdfReportCreator reportCreator = new PdfReportCreator();
        List< Map<String, String>> aa  = new ArrayList<>();
        reportCreator.create(aa);
    }
}
