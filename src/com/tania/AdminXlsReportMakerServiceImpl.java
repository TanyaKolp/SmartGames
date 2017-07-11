package com.tania;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 10.07.17.
 */
public class AdminXlsReportMakerServiceImpl implements AdminXlsReportMakerService {

    @Override
    public String createXlsReport(List<Map<String, String>> data, List<String> headers) {
        Workbook workbook = new HSSFWorkbook();
        fillReportTable(workbook, headers, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString()+".xls";
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }

    @Override
    public String createBrandReport(Map<Object, Object> result) {
        return null;
    }

    @Override
    public String createItemReport() {
        return null;
    }

    @Override
    public String createCategoryReport() {
        return null;
    }

    @Override
    public String createServiceReport() {
        return null;
    }

    @Override
    public String createCardApprovalReport() {
        return null;
    }

    private String createXls(List<String> tableHeader, List<Map<String, String>> data) {
        String linkFilePath = null;
        Workbook workbook = new HSSFWorkbook();
        fillReportTable(workbook, tableHeader, data);
        return linkFilePath;
    }

    private void fillReportTable(Workbook book, List<String> tableHeader, List<Map<String, String>> data) {
        Sheet sheet = book.createSheet("Report");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        createTableHeader(book, sheet, tableHeader);
        //PrintSetup printSetup = sheet.getPrintSetup();
        // printSetup.setLandscape(true);
        int countRows = sheet.getPhysicalNumberOfRows();
        Row dataRow;
        Map<String ,String> valuesMap;
        for (int i = 0; i < data.size(); i++) {
            dataRow = sheet.createRow(countRows);
            valuesMap =data.get(i);
            int j = 0;
            for (String columnName : tableHeader) {
                Cell dataCell = dataRow.createCell(j);
                if(valuesMap.get(columnName)!=null) {
                    dataCell.setCellValue(valuesMap.get(columnName));
                }else {
                    dataCell.setCellValue("0");
                }
                j++;
            }
        }
    }


    private void createTableHeader(Workbook book, Sheet sheet, List<String> headers) {
        CellStyle titleTableStyle = createStyleTable(book);
//		Создаём строку шапки таблицы
        Row header = sheet.createRow(0);
        header.setHeightInPoints(25);
//		Создаём, подписываем и настраиваем ячейки шапки
        int i = 0;
        for (String columnName : headers) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(columnName);
            headerCell.setCellStyle(titleTableStyle);
            sheet.setColumnWidth(headerCell.getColumnIndex(), 22 * 256);
            i++;
        }
    }

    private CellStyle createStyleTable(Workbook book) {
        Font titleFont = book.createFont();
        titleFont.setFontHeightInPoints((short) 10);
        titleFont.setBold(true);
        titleFont.setFontName("Times New Roman");

        CellStyle titleStyle = book.createCellStyle();
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setFont(titleFont);

        return titleStyle;
    }

    private void writeToFile(String path, Workbook workbook) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.close();
            System.out.println("file="+path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
