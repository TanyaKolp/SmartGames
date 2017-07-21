package com.tania;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by tanya on 21.07.17.
 */
public class DocTest {
    public void newWordDoc(String filename, String fileContent)
            throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        tmpParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText(fileContent);
        tmpRun.setFontSize(18);
        FileOutputStream fos = new FileOutputStream(new File(filename + ".doc"));
        document.write(fos);
        fos.close();
    }
    public static void main(String[] args) throws Exception {
        DocTest app = new DocTest();
        app.newWordDoc("testfile", "Hello World!");
    }
}
