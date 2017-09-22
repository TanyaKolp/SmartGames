package com.tania.reportcreator;

import com.tania.exersises.Mydata;
import com.tania.exersises.Mydatasec;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.jxls.area.XlsArea;
import org.jxls.command.EachCommand;
import org.jxls.common.AreaRef;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanya on 01.08.17.
 */
public class DocCreator {
    public String create() {
        try {
            Workbook myExcelBook = WorkbookFactory.create(new FileInputStream("doc1.xls"));
            Sheet sheet = myExcelBook.getSheetAt(0);
            for (int j = 0; j < sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        Object value = null;
                        if (cell.getCellType() == 1) {
                            value = cell.getNumericCellValue();
                            if (value.toString().equals("test")) {
                                cell.setCellValue("yra");
                            }
                        }

                    }
                }
            }
            myExcelBook.write(new FileOutputStream("doc1.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void test() {
        List<Mydata> mydatas = new ArrayList<>();
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("tret", 10, "jkh"));
        mydatas.add(new Mydata("kjh", 789, "qwret"));
//        mydatas.add(new Mydata("kljlk", 2, "desr"));
//        mydatas.add(new Mydata("kljlk", 2, "desr"));
//        mydatas.add(new Mydata("qwet", 10, "gretgr"));
        List<Mydatasec> invoice = new ArrayList<>();
        invoice.add(new Mydatasec("invo", 100, "dfkjld"));
        try (InputStream is = Mydata.class.getResourceAsStream("/document_template.xls")) {
            try (OutputStream os = new FileOutputStream("grid_output2.xls")) {
                Context context = new Context();
//                context.putVar("headers", Arrays.asList("Name", "BirthDate", "Id"));

                context.putVar("product", mydatas);
                context.putVar("unit", mydatas);
//                context.putVar("party", mydatas);
                context.putVar("invoice", invoice);
//                context.putVar("data", new Mydata("kjdshf",34,"djskl"));
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void qwer() {
        List<Mydata> mydatas = new ArrayList<>();
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("kljlk", 2, "desr"));
        mydatas.add(new Mydata("qwet", 10, "gretgr"));
        try (InputStream is = Mydata.class.getResourceAsStream("/my_template.xls")) {
            try (OutputStream os = new FileOutputStream("grid_output2.xls")) {
                Transformer transformer = TransformerFactory.createTransformer(is, os);
                XlsArea xlsArea = new XlsArea("Template!A1:G15", transformer);
                XlsArea departmentArea = new XlsArea("Template!A2:G12", transformer);
                EachCommand departmentEachCommand = new EachCommand("department", "departments", departmentArea);

                xlsArea.addCommand(new AreaRef("Template!A2:F12"), departmentEachCommand);
                Context context = new Context();
                context.putVar("departments", mydatas);
                xlsArea.applyAt(new CellRef("Down!A1"), context);
                xlsArea.processFormulas();
                departmentEachCommand.setDirection(EachCommand.Direction.RIGHT);
                xlsArea.reset();
                xlsArea.applyAt(new CellRef("Right!A1"), context);
                xlsArea.processFormulas();
                transformer.write();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
