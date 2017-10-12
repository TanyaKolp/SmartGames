package com.tania.jxls_test;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 04.09.17.
 */
public class JXSLtest {

    public static void main(String[] args) {
//        List<Data> data = new ArrayList();
//        List<Map<String,Object>> data = new ArrayList();
        List<Map<String, Object>> data = new ArrayList();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "kdfh");
        map.put("key", "kjkl");
        map.put("name", "nameYRA");
//        Data key = new Data("djs","fkldsj");
        data.add(map);
        data.add(map);
        List<Map<String, Object>> data2 = new ArrayList();
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "kdfh");
        map2.put("key", "kjkl");
        data2.add(map2);
        Context context = new Context();
        context.putVar("data", data);

        context.putVar("in", data2);
        try (InputStream is = context.getClass().getResourceAsStream("/Комплектация номенклатуры.xls")) {
            try (OutputStream os = new FileOutputStream("newTTests.xlsx")) {
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
        }

    }

    protected String writeToFile(String templateFilePath, Context context) {
        String fileName = String.format("%s.xls", Long.valueOf(System.nanoTime()).toString());
        String filePath = "tests";
        String linkFilePath = null;

        try (InputStream is = context.getClass().getResourceAsStream(templateFilePath)) {
            try (OutputStream os = new FileOutputStream(filePath)) {
                JxlsHelper.getInstance().processTemplate(is, os, context);
                linkFilePath = String.format("../admin/download/%s", fileName);
            }
        } catch (IOException e) {
        }
        return linkFilePath;
    }
}
