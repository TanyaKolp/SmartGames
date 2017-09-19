package com.tania.jxls_test;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by tanya on 04.09.17.
 */
public class Creator {
    String templ = "temp1.xlsx";


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
