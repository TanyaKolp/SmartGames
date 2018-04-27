package com.tania.reportcreator;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tkolpakova on 06.07.17.
 */
public class CsvReportCreator implements ReportCreator {

    @Override
    public String create(List<Map<String, String>> data) {
        String fileName = "testCSV.csv";
        List<String[]> rows = new ArrayList<String[]>();
        rows.add(COLUMN_NAMES);
        int i = 0; // номер строки
        for (Map<String, String> map : data) {
            String[] row = new String[VALUES_NAMES.length+1];
            row[0] = String.valueOf(i+1);
            for (int j = 0; j < VALUES_NAMES.length; j++) {
                row[j+1] = map.get(VALUES_NAMES[j]);
            }
            rows.add(row);
            i++;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(rows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
