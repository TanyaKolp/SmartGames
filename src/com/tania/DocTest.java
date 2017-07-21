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
    public static void main(String[] args) throws Exception {
        AgreementFormCreater app = new AgreementFormCreater();
        app.createForm(null);
    }
}
