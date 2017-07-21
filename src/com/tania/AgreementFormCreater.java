package com.tania;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by tanya on 21.07.17.
 */
public class AgreementFormCreater {
    public String createForm(Map<String, String> params) throws IOException {
        String linkFilePath = null;
        fillForm(params);


        return linkFilePath;
    }

    private void fillForm(Map<String, String> params) throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun tmpRun = getParagraphStyle(title, 10, true);
        tmpRun.setText("ПРИЛОЖЕНИЕ 1");

        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun subTitleRun = getParagraphStyle(subTitle, 10, false);
        StringBuilder subTitleValue = new StringBuilder();
        subTitleValue.append("к Соглашению о партнерстве № Б-");
        subTitleValue.append("100"); //номер соглашения
        subTitleValue.append(" от ");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy г.");
        subTitleValue.append(dateFormat.format(new Date()));
        subTitleRun.setText(subTitleValue.toString());




        writeToFile(document);

    }

    private String writeToFile(XWPFDocument document) throws IOException {
        String linkFilePath = "";
        String filename = "ТЕСТ";
        FileOutputStream fos = new FileOutputStream(new File(filename + ".doc"));
        document.write(fos);
        fos.close();

        return linkFilePath;
    }

    private XWPFRun getParagraphStyle(XWPFParagraph paragraph, int fontSize, boolean isBold) {
        XWPFRun xwpfRun = paragraph.createRun();
        xwpfRun.setFontFamily("Arial");
        xwpfRun.setFontSize(fontSize);
        xwpfRun.setBold(isBold);

        return xwpfRun;
    }

}
