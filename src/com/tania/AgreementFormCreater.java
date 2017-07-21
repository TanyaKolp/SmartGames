package com.tania;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tanya on 21.07.17.
 */
public class AgreementFormCreater {
    public String createForm(Map<String, String> params) throws IOException {
        String linkFilePath = null;
        fillForm(params);
        XWPFDocument document = new XWPFDocument();

        writeToFile(document);

        return linkFilePath;
    }

    private void fillForm(Map<String, String> params) {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        tmpParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText("ПРИЛОЖЕНИЕ 1");
        tmpRun.setFontSize(10);
    }

    private String writeToFile(XWPFDocument document) throws IOException {
        String linkFilePath = "";
        String filename = "ТЕСТ";
        FileOutputStream fos = new FileOutputStream(new File(filename + ".doc"));
        document.write(fos);
        fos.close();

        return linkFilePath;
    }

}
