package com.tania;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 10.07.17.
 */
public class FORtestAdminXlsReportMakerServiceImpl implements FORtestAdminXlsReportMakerService {
    @Override
    public String createSalesReport(List<LinkedHashMap<String, Object>> data) {
        return null;
    }

    @Override
    public String createSalesSumReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        fillSalesSumReportTable(workbook, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString();
        linkFilePath = linkFilePath + ".xls";
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }

    @Override
    public String createBrandReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        fillBrandReportTable(workbook, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString();
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }

    @Override
    public String createItemReport(List<LinkedHashMap<String, Object>> data) {
        return null;
    }

    @Override
    public String createCategoryReport(List<LinkedHashMap<String, Object>> data) {
        return null;
    }

    @Override
    public String createServiceReport(List<LinkedHashMap<String, Object>> data) {
        return null;
    }

    @Override
    public String createCardApprovalReport(List<LinkedHashMap<String, Object>> data) {
        return null;
    }


    private void createSalesSumTableHeader(Workbook workbook, Sheet sheet) {

    }

    public String createXlsReport(List<Map<String, String>> data, List<String> headers) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        // fillReportTable(workbook, headers, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString();
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }

    private void fillBrandReportTable(Workbook book, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = book.createSheet("BrandReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        LinkedHashMap<String, Object> map = data.get(0);
        createBrandHeader(book, sheet, map);
        //PrintSetup printSetup = sheet.getPrintSetup();
        // printSetup.setLandscape(true);
        int countRows = sheet.getPhysicalNumberOfRows();
        Row dataRow;
        Map<String, Object> valueMap;
        for (int i = 0; i < data.size(); i++) {
            dataRow = sheet.createRow(countRows);
            valueMap = data.get(i);
            int j = 0;
            Cell dataCell;
            for (String columnName : valueMap.keySet()) {
                dataCell = dataRow.createCell(j);
                if (valueMap.get(columnName) != null) {
                    dataCell.setCellValue(valueMap.get(columnName).toString());
                } else {
                    dataCell.setCellValue(0);
                }
                j++;
            }
        }
    }

    private void createBrandHeader(Workbook book, Sheet sheet, LinkedHashMap<String, Object> header) {
        CellStyle titleTableStyle = createStyleTable(book);
        Row headerRow = sheet.createRow(0);

        if (header.containsKey("HEADER")) {
            Cell headerCell;
            int i = 2;
            for (String column : header.keySet()) {
                if (column.equals("HEADER")) {
                    Cell storeName = headerRow.createCell(0);
                    storeName.setCellStyle(titleTableStyle);
                    storeName.setCellValue("Имя заведения");
                }
                if (column.equals("TOTAL")) {
                    Cell total = headerRow.createCell(1);
                    total.setCellStyle(titleTableStyle);
                    total.setCellValue("Всего");
                }
                headerCell = headerRow.createCell(i);
                headerCell.setCellStyle(titleTableStyle);
                headerCell.setCellValue(column);
                i++;
            }
        } else {
            setStyleForHeaderCell(headerRow);
            Cell headerCell;

            headerCell = headerRow.createCell(1);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Общая сумма продаж");

            headerCell = headerRow.createCell(2);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Скидка");

            headerCell = headerRow.createCell(3);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Сумма продаж без скидки");

            headerCell = headerRow.createCell(4);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Дополнительный налог");

            headerCell = headerRow.createCell(5);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Сумма дополнительного налога");

            headerCell = headerRow.createCell(6);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Количество посетителей");
        }
    }

    private void setStyleForHeaderCell(Row headerRow) {
        Cell headerCell;
        headerCell = headerRow.createCell(0);
//        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Имя заведения");
    }

    private void fillSalesSumReportTable(Workbook workbook, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = workbook.createSheet("SalesSumReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        if (data.size() == 1) {
            LinkedHashMap<String, Object> prices = data.get(0);
            //шапка "Тип продаж" "Цена"
            Row headerRow = sheet.createRow(0);
            Cell saleTypeHeader = headerRow.createCell(0);
            saleTypeHeader.setCellStyle(createStyleTable(workbook));
            saleTypeHeader.setCellValue("Тип продаж");

            Cell priceHeader = headerRow.createCell(1);
            priceHeader.setCellStyle(createStyleTable(workbook));
            priceHeader.setCellValue("Цена");
            //заполняем таблицу
            String[] types = new String[]{"Общая сумма продаж", "Скидка", "Сумма продаж без скидки",
                    "- Наличные", "- Банковская карта", "- Прочее",
                    "Дополнительный налог", "Сумма дополнительного налога", "Количество посетителей"};  //значения для первой колонки
            int i = 0;
            Row row;
            Cell type;
            Cell price;
            for (String key : prices.keySet()) {
                row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                type = row.createCell(0);
                type.setCellValue(types[i]);
                price = row.createCell(1);
                if (prices.get("sales") != null) {
                    System.out.println(prices.get(key));
                    price.setCellValue(Long.valueOf(prices.get(key).toString()));
                } else {
                    price.setCellValue(0);
                }
                i++;
            }
        } else {
            //шапка таблицы
            String[] header = new String[]{"Дата", "Общая сумма продаж", "Скидка", "Сумма продаж без скидки",
                    "Наличные", "Банковская карта", "Прочее", "Дополнительный налог",
                    "Сумма дополнительного налога", "Количество посетителей"};
            Row headerRow = sheet.createRow(0);
            Cell headerCell;
            for (int i = 0; i < header.length; i++) {
                headerCell = headerRow.createCell(i);
                headerCell.setCellStyle(createStyleTable(workbook));
                headerCell.setCellValue(header[i]);
                sheet.autoSizeColumn(headerCell.getColumnIndex());
            }
            //заполняем таблицу
            Row dataRow;
            Cell dataCell;
            for (LinkedHashMap<String, Object> values : data) {
                dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
                int i = 0;
                for (String key : values.keySet()) {
                    dataCell = dataRow.createCell(i);
                    try {
                        dataCell.setCellValue(Long.valueOf(values.get(key).toString()));
                    } catch (NumberFormatException e) {
                        dataCell.setCellValue(values.get(key).toString());
                    }
                    i++;
                }
            }
        }
        //total
        Row totalRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
        Cell formulaCell;
        for (int i = 1; i < 10; i++) {
            String colName = CellReference.convertNumToColString(i);
            String startCell = colName + 2;
            String stopCell = colName + data.size();
            String sumFormula = String.format("SUM(%s:%s)", startCell, stopCell);
            formulaCell = totalRow.createCell(i);
            formulaCell.setCellType(Cell.CELL_TYPE_FORMULA);
            formulaCell.setCellFormula(sumFormula);
        }
    }

    private void createHeaderByArray(Workbook workbook, Sheet sheet, String[] array) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        for (int i = 0; i < array.length; i++) {
            headerCell = headerRow.createCell(i);
            headerCell.setCellStyle(createStyleTable(workbook));
            headerCell.setCellValue(array[i]);
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

    private void writeToFile(String path, Workbook workbook) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        workbook.write(out);
        out.close();
    }


}
