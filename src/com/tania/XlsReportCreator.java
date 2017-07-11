package com.tania;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tkolpakova on 06.07.17.
 */
public class XlsReportCreator implements ReportCreator {

    @Override
    public String create(List<Map<String, String>> data) {
        String linkFilePath = null;
        Workbook bookReport = new HSSFWorkbook();
        fillReportTable(bookReport, data);
        wtiteToFile("testFile.xls", bookReport);
        return linkFilePath;
    }

    private void fillReportTable(Workbook book, List<Map<String, String>> data) {

        Sheet sheet = book.createSheet("Отчёт для бухгалтерии");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        Set<String> namesOfColumns = data.get(0).keySet();
        createTableHeader(book, sheet, namesOfColumns);
        //PrintSetup printSetup = sheet.getPrintSetup();
        // printSetup.setLandscape(true);
        int countRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> columns = data.get(i);
            Row row = sheet.createRow(countRows++);
            Cell cellNo = row.createCell(0);
            sheet.setColumnWidth(cellNo.getColumnIndex(), 5 * 256);
            cellNo.setCellValue(i + 1);

            int j = 1; /////////
            for (String name : VALUES_NAMES) {
                Cell cellColumn = row.createCell(j);////////////
                cellColumn.setCellValue(columns.get(name));/////////
                sheet.setColumnWidth(cellColumn.getColumnIndex(), 22 * 256);
                j++;
            }
        }
    }


    private void createTableHeader(Workbook book, Sheet sheet, Set<String> namesOfColumns) {
        CellStyle titleTableStyle = createStyleTable(book);

//		Создаём шапку таблицы
        Row header = sheet.createRow(0);
        header.setHeightInPoints(25);
        String[] colNames = new String[]{"№", "Заведение", "Бренд", "ИНН", "Номер заказа",
                "Тип оплаты", "Сумма оплаты", "Дата оплаты", "Время оплаты",
                "Процентная ставка банка", "Процентной ставка BAK", "Комиссии банка", "Комиссии BAK"};
//		Создаём, подписываем и настраиваем ячейки шапки
        int i = 0;
        for (String columnName : COLUMN_NAMES) {
            Cell columnCell = header.createCell(i);
            columnCell.setCellValue(columnName);
            columnCell.setCellStyle(titleTableStyle);
            i++;
        }
    }

    private static CellStyle createStyleTable(Workbook book) {
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

    private void wtiteToFile(String path, Workbook workbook) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
