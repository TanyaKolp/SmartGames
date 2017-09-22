package com.tania;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by tanya on 24.07.17.
 */
public class DocEditor {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Приложение 1.docx");
            XWPFDocument dox = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = dox.getParagraphs();
            for (XWPFParagraph p : paragraphs) {
                TextSegement textSegement = p.searchText("%", new PositionInParagraph(0, 0, 0));
                if (textSegement != null) {
                    System.out.println( p.getText());

                    System.out.println("Test="+ p.getText(textSegement));
                    System.out.println( "char="+   textSegement.getBeginPos().getChar());
                    System.out.println("endrun="+textSegement.getEndRun());
                    System.out.println("beginchar="+textSegement.getBeginChar());
                }
            }
            for (XWPFParagraph p : dox.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("%")) {
                            text = text.replace("%", "haystack");
                            r.setText(text, 0);
                        }
                    }
                }
            }
            dox.write(new FileOutputStream("result.docx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
