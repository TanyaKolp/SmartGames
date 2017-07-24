package com.tania;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tanya on 24.07.17.
 */
public class AgreementFormCreatorImpl implements AgreementFormCreator {

    @Override
    public String createForm(Map<String, String> params) throws IOException {
        DateFormat shortFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat fullFormat = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println(params);
        List<String> keyOrder = new ArrayList<>(Arrays.asList("no", "date", "fulldate", "name", "director",
                "basis","no","date", "period", "sumNum", "sumStr", "rewardNum", "rewardStr"));
        int i = 0;
        try {
            FileInputStream fis = new FileInputStream("result.docx");
            XWPFDocument dox = new XWPFDocument(fis);
            for (XWPFParagraph p : dox.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("#")) {
                            int index = text.indexOf("#");
                            while (index > -1) {
                                if (params.get(keyOrder.get(i)) != null) {
                                    text = text.replaceFirst("#", params.get(keyOrder.get(i)));
                                    r.setText(text, 0);
                                }
                                index = text.indexOf( "#", index+1 );
                                i++;
                            }
                        }
                    }
                }
            }
            List<String> keyOrderTable = new ArrayList<>(Arrays.asList("directorStatus", "directorShort", "directorStatus", "directorShort"));
            int j=0;
            for (XWPFTable tbl : dox.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null ) {
                                    int index = text.indexOf("#");
                                    while (index > -1) {
                                        if (params.get(keyOrderTable.get(j)) != null) {
                                            text = text.replaceFirst("#", params.get(keyOrderTable.get(j)));
                                            r.setText(text, 0);
                                        }
                                        index = text.indexOf( "#", index+1 );
                                        j++;
                                    }
                                }
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
}

