package com.tania;

import java.io.IOException;
import java.util.*;

/**
 * Created by tanya on 11.07.17.
 */
public class AdminRepirtTEST {
    public static void main(String[] args) {
        FORtestAdminXlsReportMakerService service = new FORtestAdminXlsReportMakerServiceImpl();
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        int j = 0;
        for (String s : ReportCreator.COLUMN_NAMES) {
            if (j%2==0) {
                map.put(s, 100);
            }else {
                map.put(s, "nameРОРд");
            }
            j++;
        }
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(map);
        }
        try {
            System.out.println(service.createSalesSumReport(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
