package com.tania;

import java.util.*;

/**
 * Created by tanya on 11.07.17.
 */
public class AdminRepirtTEST {
    public static void main(String[] args) {
        AdminXlsReportMakerService reportMakerService = new AdminXlsReportMakerServiceImpl();
        Map<String, String> map = new HashMap<String,String>();
        for (String s : ReportCreator.COLUMN_NAMES) {
            map.put(s, s);
        }
       // map.put("",null);
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(map);
        }
        List<String> headers = new ArrayList<>(Arrays.asList(ReportCreator.COLUMN_NAMES));
        reportMakerService.createXlsReport(data, headers);
    }
}
