package com.tania.readCSV;



import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tanya on 03.10.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader("units.csv"), ',')) {
            String[] strings = reader.readNext();
            List<BakStoreUnit> bakStoreUnits = mapToCSV(reader, BakStoreUnit.class, strings);
            System.out.println(bakStoreUnits);
            System.out.println(bakStoreUnits.get(0).getGroup());
        }
    }

    public static <T> List<T> mapToCSV(CSVReader csvContent, Class<T> mapToClass, String[] strings) {
        CsvToBean<T> csvToBean = new CsvToBean<T>();

//        Map<String, String> columnMapping = new HashMap<>();
        List<String> n = new ArrayList();

        Arrays.stream(mapToClass.getDeclaredFields()).forEach(field ->
                n.add(field.getName()));
        ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(mapToClass);
        strategy.setColumnMapping(strings);

        return csvToBean.parse(strategy, csvContent);
    }
}
