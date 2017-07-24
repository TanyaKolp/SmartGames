package com.tania;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanya on 21.07.17.
 */
public class DocTest {
    public static void main(String[] args) throws Exception {
        AgreementFormCreater app = new AgreementFormCreater();
        AgreementFormCreator creator = new AgreementFormCreatorImpl();
        Map<String, String> params =new HashMap<>();
        params.put("no", "100");
        params.put("name", "Name");
        params.put("director", "Директор");
        params.put("directorShort", "Директор HN");
        params.put("directorStatus", "Генеральный деректор");
        params.put("basis", "Устав");
        params.put("period", "ГОД");
        params.put("sumNum", "1 000 000");
        params.put("sumStr", "число");
        params.put("rewardNum", "2 000");
        params.put("rewardStr", "число");
        params.put("date", "234324");
        params.put("fulldate", "234324");

        //app.createForm(params);
        creator.createForm(params);
    }
}
