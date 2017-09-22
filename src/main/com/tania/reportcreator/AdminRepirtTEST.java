package com.tania.reportcreator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tania.reportcreator.FORtestAdminXlsReportMakerService;
import com.tania.reportcreator.FORtestAdminXlsReportMakerServiceImpl;
import com.tania.reportcreator.ReportCreator;

import java.io.IOException;
import java.util.*;

/**
 * Created by tanya on 11.07.17.
 */
public class AdminRepirtTEST {
    public static void main(String[] args) {
        FORtestAdminXlsReportMakerService service = new FORtestAdminXlsReportMakerServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        List<LinkedHashMap<String, Object>> o = null;

        System.out.println(o.size());
        System.out.println(o);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        int j = 0;
        for (String s : ReportCreator.COLUMN_NAMES) {
            if (j % 2 == 0) {
                map.put(s, 100);
            } else {
                map.put(s, "nameРОРд");
            }
            j++;
        }
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(map);
        }
        try {
            System.out.println(service.createItemReport(o));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
