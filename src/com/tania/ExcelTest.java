package com.tania;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tania on 06.07.17.
 */
public class ExcelTest {

    public static void main(String[] args) {
        AccountingReport acc = new AccountingReport();
        Map<String, String> map = new HashMap<String,String>();
        for (String s : ReportCreator.VALUES_NAMES) {
            map.put(s, s);
        }
        List<Map<String, String>> data = new ArrayList< Map<String, String>>();
        for (int i = 0; i < 100; i++) {
            data.add(map);

        }
        String xls = acc.createReport(data, "xls");
        System.out.println("xls writtten " + xls);
        String csv = acc.createReport(data, "csv");
        System.out.println("csv writtten " + csv);
        String pdf = acc.createReport(data, "pdf");
        System.out.println("pdf writtten " + pdf);
    }
}
