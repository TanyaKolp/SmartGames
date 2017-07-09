package com.tania;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tania on 06.07.17.
 */
public class csvTest {
    public static void main(String[] args) throws IOException {
        String fileName = "testCSV.csv";
        String[] items1 = {"ghjgjhk", "coin", "pencil"};
        String[] items2 = {"pen", "chair", "lamp"};
        String[] items3 = {"ball", "bowl", "spectacles"};

        List<String[]> entries = new ArrayList<>();
        entries.add(items1);
        entries.add(items2);
        entries.add(items3);
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(fileName));
            writer.writeAll(entries);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
