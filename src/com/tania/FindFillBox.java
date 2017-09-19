package com.tania;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by tanya on 07.08.17.
 */
public class FindFillBox {
    public String createForm(Map<String, String> params) throws IOException {
        System.out.println(params);
        Set<String> boxList = new HashSet<>();
        try {
            FileInputStream fis = new FileInputStream("result.docx");
            XWPFDocument dox = new XWPFDocument(fis);
            for (XWPFParagraph p : dox.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        findBox(params, r, boxList);
                    }
                }
            }

            for (XWPFTable tbl : dox.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                findBox(params, r, boxList);
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
        System.out.println(boxList);
        return null;
    }

    private void findBox(Map<String, String> params, XWPFRun r, Set<String> boxList) {
        String text = r.getText(0);
        System.out.println(text);
        if (r.isStrikeThrough()) {
            boxList.add(text);
        }
    }
}
