package com.tania;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tkolpakova on 06.07.17.
 */
public class Xlsformula implements ReportCreator {

    @Override
    public String create(List<Map<String, String>> data) {
        String linkFilePath = null;
        Workbook bookReport = new HSSFWorkbook();
        fillReportTable(bookReport, data);
        wtiteToFile("FORMULAFile.xls", bookReport);
        return linkFilePath;
    }

    private void fillReportTable(Workbook book, List<Map<String, String>> data) {
        String startCell;
        Sheet sheet = book.createSheet("Отчёт");
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
            Cell cell;
            int j = 1; /////////
            for (String name : VALUES_NAMES) {
                Cell cellColumn = row.createCell(j);////////////
                cellColumn.setCellValue(columns.get(name));/////////
                sheet.setColumnWidth(cellColumn.getColumnIndex(), 22 * 256);
                j++;
            }
        }
        //total
        Row totalRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
        Cell cell;
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            String colNamestart = CellReference.convertNumToColString(i);
            startCell = colNamestart + 2;
            System.out.println("startCell=" + startCell);

            String stopCell = colNamestart + data.size();
            String sumFormula = String.format("SUM(%s:%s)", startCell, stopCell);
            cell = totalRow.createCell(i);
            cell.setCellType(Cell.CELL_TYPE_FORMULA);
            cell.setCellFormula(sumFormula);
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
