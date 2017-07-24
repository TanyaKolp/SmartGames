package com.tania;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

    private void fillForm(Map<String, String> data) throws IOException {
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
        subTitleValue.append(data.get("no")); //номер соглашения
        subTitleValue.append(" от ");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy г.");
        subTitleValue.append(dateFormat.format(new Date()));
        subTitleRun.setText(subTitleValue.toString());

        XWPFParagraph act = document.createParagraph();
        act.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun actRun = getParagraphStyle(act, 10, true);
        actRun.setText("\nАКТ\n" +
                "об оказанных услугах по Соглашению о партнерстве");

        act = document.createParagraph();
        act.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
        actRun = getParagraphStyle(act, 10, false);
        actRun.setText("г. Москва            " + dateFormat.format(new Date()));

        XWPFParagraph first = document.createParagraph();
        first.setAlignment(ParagraphAlignment.BOTH);

        StringBuilder firstParagraph = new StringBuilder();
        firstParagraph.append("\nОбщество с ограниченной ответственностью «БАК Интернэшнл», именуемое в дальнейшем «Партнер-1», " +
                "в лице Генерального директора Болтрукевича Павла Викторовича, действующего на основании Устава, с одной стороны, и ");
        firstParagraph.append(data.get("name"));
        firstParagraph.append(", именуемое в дальнейшем «Партнер-2», в лице ");
        firstParagraph.append(data.get("directorName"));
        firstParagraph.append(", действующего на основании ");
        firstParagraph.append(data.get("basis"));
        firstParagraph.append(",  с другой стороны, в совместном наименовании – «Стороны», " +
                "а по отдельности «Сторона», составили настоящий Акт о нижеследующем.");

        XWPFRun firstRun = getParagraphStyle(first, 10, false);
        firstRun.setText(firstParagraph.toString());

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run;

        ArrayList<String> documentList = new ArrayList<String>();
        StringBuilder one = new StringBuilder();
        one.append("Партнер-1 в соответствии с Соглашением о партнёрстве № Б-");
        one.append(data.get("no"));
        DateFormat dateFormatY = new SimpleDateFormat("/yy");
        DateFormat dateFormatYY = new SimpleDateFormat("dd.MM.yyyy года ");
        one.append(dateFormatY.format(new Date()));
        one.append(" от ");
        one.append(dateFormatYY.format(new Date()));
        one.append(" в период ");
        one.append(data.get("period"));
        one.append(" в полном объеме и надлежащем порядке оказал услуги по предоставлению Партнеру 2 возможности использования" +
                " системы автоматизации клиентского сервиса «ELIOT», в том числе для осуществления Пользователями Платежей по оплате товаров, работ и услуг, предоставляемых Партнером-2. " +
                "Партнер-2 не имеет никаких претензий к услугам, оказанным Партнером-1. ");

        // one.append(dateFormatYY.format(new Date()));
        StringBuilder two = new StringBuilder();
        two.append("Общая сумма денежных средств, перечисленных Пользователями Партнеру-2 с использованием Сервиса за указанный период, составила: ");
        two.append(data.get("sumNm"));
        String sum = "(" + data.get("sumStr") + ")";
        two.append(sum);
        two.append(" руб.");
        StringBuilder three = new StringBuilder();
        three.append("Вознаграждение Партнера-1 за оказанные услуги составляет ");
        three.append(data.get("sum2Nm"));
        String sum2 = " (" + data.get("sum2Str") + ")";
        three.append(sum2);
        three.append(" руб.");
        documentList.add(one.toString());
        documentList.add(two.toString());
        documentList.add(three.toString());
        documentList.add("Стороны претензий друг к другу не имеют.");
        documentList.add("Настоящий Акт составлен в двух экземплярах по одному для каждой Стороны.");


        CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
        //Next we set the AbstractNumId. This requires care.
        //Since we are in a new document we can start numbering from 0.
        //But if we have an existing document, we must determine the next free number first.
        cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));

/* Bullet list
  CTLvl cTLvl = cTAbstractNum.addNewLvl();
  cTLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
  cTLvl.addNewLvlText().setVal("•");
*/

///* Decimal list
        CTLvl cTLvl = cTAbstractNum.addNewLvl();
        cTLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL_ZERO);
        cTLvl.addNewLvlText().setVal("%.");
        cTLvl.addNewStart().setVal(BigInteger.valueOf(1));
//*/

        XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);
        XWPFNumbering numbering = document.createNumbering();
        BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);
        BigInteger numID = numbering.addNum(abstractNumID);


        for (String string : documentList) {
            paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.BOTH);
            CTPPr ppr = paragraph.getCTP().getPPr();
            if (ppr == null) ppr = paragraph.getCTP().addNewPPr();
            CTSpacing spacing = ppr.isSetSpacing() ? ppr.getSpacing() : ppr.addNewSpacing();
            spacing.setAfterLines(BigInteger.valueOf(1));
            run = getParagraphStyle(paragraph, 10, false);
            paragraph.setNumID(numID);
            run.setText(string);
        }


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
