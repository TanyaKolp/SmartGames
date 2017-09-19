package com.tania.poiXLS;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json4s.DefaultWriters;

import java.io.*;

/**
 * Created by tanya on 07.09.17.
 */
public class Test {
    public static void main(String[] args) {
        FileInputStream excelFile = null;
        try {
            excelFile = new FileInputStream(new File("test22.xls"));
            Workbook workbook = new HSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            PrintSetup lastRowNum = sheet.getPrintSetup();
            System.out.println(lastRowNum.getPaperSize());
            System.out.println("START =" + lastRowNum.getPageStart());
            System.out.println("H = " + lastRowNum.getFitHeight());
            System.out.println("W =" + lastRowNum.getFitWidth());
            String printArea = workbook.getPrintArea(0);
            System.out.println(printArea);
            workbook.setPrintArea(0, 0, 20, 0, 70);
            System.out.println(workbook.getPrintArea(0));
            Row r = sheet.getRow(23);
            System.out.println("ROW = " + r);
            Row lastrow = sheet.createRow(sheet.getPhysicalNumberOfRows() + 1);
            System.out.println("ROW = " + lastrow);
            System.out.println("ff = " + r.isFormatted());
            System.out.println(r.getCell(0).getStringCellValue());
            CellStyle cellStyle = r.getCell(0).getCellStyle();
//            Row ch = sheet.createRow(r.getRowNum() + 1);
//            Cell cell = ch.createCell(0);
//            cell.setCellStyle(cellStyle);
            sheet.shiftRows(22,24,1);

//            Row row = sheet.createRow(lastRowNum + 1);
//            Cell cell = row.createCell(0);
//            cell.setCellValue("QWERTYYU");

            workbook.write(new FileOutputStream("test22.xls"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
