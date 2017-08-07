package com.tania;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tanya on 24.07.17.
 */
public class AgreementFormCreatorImpl implements AgreementFormCreator {

    @Override
    public String createForm(Map<String, String> params) throws IOException {
        DateFormat shortFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat fullFormat = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println(params);
        try {
            FileInputStream fis = new FileInputStream("result.docx");
            XWPFDocument dox = new XWPFDocument(fis);
            for (XWPFParagraph p : dox.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        fillForm(params, r);
                    }
                }
            }

            for (XWPFTable tbl : dox.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                fillForm(params, r);
                            }
                        }
                    }
                }
            }
            dox.write(new FileOutputStream("TEST.docx"));
            System.out.println("ok ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void fillForm(Map<String, String> params, XWPFRun r) {
        String text = r.getText(0);
        System.out.println(text);
        if (params.containsKey(text)) {
            text = text.replaceFirst(text, params.get(text));
            r.setStrikeThrough(false);
            r.setText(text, 0);
        }
    }

}

