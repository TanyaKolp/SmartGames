package com.tania.reportcreator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by tanya on 10.07.17.
 */
public class FORtestAdminXlsReportMakerServiceImpl implements FORtestAdminXlsReportMakerService {
    @Override
    public String createSalesSumReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        String linkFilePath;
        if (!data.isEmpty()) {
            fillSalesSumReportTable(workbook, data);
            linkFilePath = Long.valueOf(System.nanoTime()).toString();
            writeToFile(linkFilePath, workbook);
        } else {
            return null;
        }
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
    public String createItemReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        fillItemReportTable(workbook, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString();
        linkFilePath = linkFilePath+".xls";
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }


    @Override
    public String createCategoryReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        fillCategoryReportTable(workbook, data);

        String linkFilePath = Long.valueOf(System.nanoTime()).toString();
        writeToFile(linkFilePath, workbook);

        return linkFilePath;
    }


    @Override
    public String createServiceReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        String linkFilePath;
        if (!data.isEmpty()) {
            fillServiceReportTable(workbook, data);
            linkFilePath = Long.valueOf(System.nanoTime()).toString();
            writeToFile(linkFilePath, workbook);
        } else {
            return null;
        }
        return linkFilePath;
    }

    @Override
    public String createSalesDetailReport(List<LinkedHashMap<String, Object>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        String linkFilePath;
        if (!data.isEmpty()) {
            fillSalesDetailTable(workbook, data);
            linkFilePath = Long.valueOf(System.nanoTime()).toString();
            writeToFile(linkFilePath, workbook);
        } else {
            return null;
        }
        return linkFilePath;
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
        fillDataToCalendarReport(data, sheet);
    }

    private void createBrandHeader(Workbook book, Sheet sheet, LinkedHashMap<String, Object> header) {
        if (header.containsKey("HEADER")) {
            createCalendarHeader(sheet, header, book);
        } else {
            CellStyle titleTableStyle = createStyleTable(book);
            Row headerRow = sheet.createRow(0);
            Cell headerCell;
            headerCell = headerRow.createCell(0);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Имя заведения");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(1);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Общая сумма продаж");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(2);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Скидка");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(3);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Сумма продаж без скидки");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(4);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Дополнительный налог");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(5);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Сумма дополнительного налога");
            sheet.autoSizeColumn(headerCell.getColumnIndex());

            headerCell = headerRow.createCell(6);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue("Количество посетителей");
            sheet.autoSizeColumn(headerCell.getColumnIndex());
        }
    }

    /**
     * создает шапку для дневных, недельных и месячных отчетов
     */
    private void createCalendarHeader(Sheet sheet, LinkedHashMap<String, Object> header, Workbook book) {
        CellStyle titleTableStyle = createStyleTable(book);
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        int i = 2;
        for (String column : header.keySet()) {
            if (column.equals("HEADER")) {
                Cell storeName = headerRow.createCell(0);
                storeName.setCellStyle(titleTableStyle);
                storeName.setCellValue("Имя заведения");
                sheet.autoSizeColumn(storeName.getColumnIndex());
            }
            if (column.equals("TOTAL")) {
                Cell total = headerRow.createCell(1);
                total.setCellStyle(titleTableStyle);
                total.setCellValue("Всего");
                sheet.autoSizeColumn(total.getColumnIndex());
            }
            headerCell = headerRow.createCell(i);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue(column);
            sheet.autoSizeColumn(headerCell.getColumnIndex());
            i++;
        }
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
            sheet.autoSizeColumn(saleTypeHeader.getColumnIndex());

            Cell priceHeader = headerRow.createCell(1);
            priceHeader.setCellStyle(createStyleTable(workbook));
            priceHeader.setCellValue("Цена");
            sheet.autoSizeColumn(priceHeader.getColumnIndex());

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
                    price.setCellValue(Float.valueOf(prices.get(key).toString()));
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
                        dataCell.setCellValue(Float.valueOf(values.get(key).toString()));
                    } catch (NumberFormatException e) {
                        dataCell.setCellValue(values.get(key).toString());
                    }
                    i++;
                }
            }
            //total row
            Row totalRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
            Cell totalName = totalRow.createCell(0);
            totalName.setCellValue("Total");
            Cell formulaCell;
            for (int i = 1; i < header.length; i++) {
                String colName = CellReference.convertNumToColString(i);
                String startCell = colName + 2;
                String stopCell = colName + data.size();
                String sumFormula = String.format("SUM(%s:%s)", startCell, stopCell);
                formulaCell = totalRow.createCell(i);
                formulaCell.setCellType(Cell.CELL_TYPE_FORMULA);
                formulaCell.setCellFormula(sumFormula);
            }
        }
    }

    private void fillItemReportTable(Workbook workbook, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = workbook.createSheet("ItemReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        LinkedHashMap<String, Object> map = data.get(0);
        if (map.get("HEADER") != null) {
            createCalendarHeader(sheet, map, workbook);
            fillDataToCalendarReport(data, sheet);
        } else {
            createSummaryItemHeader(workbook, sheet);
            Map<String, Object> mapValue;
            Row dataRow;
            Cell dataCell;
            for (int i = 0; i < data.size(); i++) {
                mapValue = data.get(i);
                dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
                dataCell = dataRow.createCell(0);
                if (mapValue.get("itemNm").toString().equals("Total")) {
                    dataCell.setCellValue("Всего");
                } else {
                    dataCell.setCellValue(mapValue.get("itemNm").toString());
                }
                dataCell = dataRow.createCell(1);
                dataCell.setCellValue(mapValue.get("catNm").toString());

                dataCell = dataRow.createCell(2);
                dataCell.setCellValue(Integer.valueOf(mapValue.get("count").toString()));

                dataCell = dataRow.createCell(3);
                dataCell.setCellValue(Float.valueOf(mapValue.get("price").toString()));

                dataCell = dataRow.createCell(4);
                dataCell.setCellValue(Float.valueOf(mapValue.get("discount").toString()));

                dataCell = dataRow.createCell(5);
                dataCell.setCellValue(Float.valueOf(mapValue.get("sales").toString()));
            }
        }
    }

    /**
     * заполняет таблицу дневных, недельных и месячных отчетов
     */
    private void fillDataToCalendarReport(List<LinkedHashMap<String, Object>> data, Sheet sheet) {
        Row dataRow;
        Map<String, Object> mapValue;
        for (int i = 0; i < data.size(); i++) {
            dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
            mapValue = data.get(i);
            int j = 0;
            Cell dataCell;
            for (String columnName : mapValue.keySet()) {
                if (columnName.equals("SUB_TITLE")) {
                    continue;
                }
                dataCell = dataRow.createCell(j);
                if (mapValue.get(columnName) != null) {
                    try {
                        dataCell.setCellValue(Float.valueOf(mapValue.get(columnName).toString()));
                    } catch (NumberFormatException e) {
                        dataCell.setCellValue(mapValue.get(columnName).toString());
                    }
                } else {
                    dataCell.setCellValue(0);
                }
                j++;
            }
        }
    }

    private void createSummaryItemHeader(Workbook workbook, Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        headerCell = headerRow.createCell(0);
        CellStyle titleTableStyle = createStyleTable(workbook);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Тип блюда");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(1);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Категория");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(2);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Количество Продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(3);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Общая сумма продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(4);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Скидка");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(5);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Сумма продаж без скидки");
        sheet.autoSizeColumn(headerCell.getColumnIndex());
    }

    private void fillCategoryReportTable(Workbook workbook, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = workbook.createSheet("CategoryReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        LinkedHashMap<String, Object> map = data.get(0);
        if (map.get("HEADER") != null) {
            createCalendarHeader(sheet, map, workbook);
            fillDataToCalendarReport(data, sheet);
        } else {
            createSummaryCategoryHeader(workbook, sheet);
            Map<String, Object> mapValue;
            Row dataRow;
            Cell dataCell;
            for (int i = 0; i < data.size(); i++) {
                mapValue = data.get(i);
                dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
                dataCell = dataRow.createCell(0);
                if (mapValue.get("catCd").toString().isEmpty()) {
                    dataCell.setCellValue("Всего");
                } else {
                    dataCell.setCellValue(mapValue.get("catCd").toString());
                }
                dataCell = dataRow.createCell(1);
                dataCell.setCellValue(Integer.valueOf(mapValue.get("count").toString()));

                dataCell = dataRow.createCell(2);
                dataCell.setCellValue(Float.valueOf(mapValue.get("sales").toString()));
            }
        }
    }

    private void createSummaryCategoryHeader(Workbook workbook, Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        headerCell = headerRow.createCell(0);
        CellStyle titleTableStyle = createStyleTable(workbook);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Категория");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(1);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Количество Продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(2);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Общая сумма продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());
    }

    private void fillServiceReportTable(Workbook workbook, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = workbook.createSheet("ServiceSalesReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        LinkedHashMap<String, Object> map = data.get(0);
        if (map.get("HEADER") != null) {
            createCalendarForServiceHeader(sheet, map, workbook);
            fillDataToCalendarReport(data, sheet);
        } else {
            createSummaryServiceHeader(workbook, sheet);
            Row dataRow;
            Cell dataCell;
            for (LinkedHashMap<String, Object> mapValue : data) {
                dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
                dataCell = dataRow.createCell(0);
                if (mapValue.get("title") != null) {
                    if (mapValue.get("title").toString().equals("ToTal")) {
                        dataCell.setCellValue("Всего");
                    } else {
                        dataCell.setCellValue(mapValue.get("title").toString());
                    }
                } else {
                    dataCell.setCellValue("-");
                }
                dataCell = dataRow.createCell(1);
                dataCell.setCellValue(Integer.valueOf(mapValue.get("orderCnt").toString()));

                dataCell = dataRow.createCell(2);
                dataCell.setCellValue(Float.valueOf(mapValue.get("sales").toString()));

                dataCell = dataRow.createCell(3);
                dataCell.setCellValue(Float.valueOf(mapValue.get("averageSales").toString()));
            }
        }
    }

    private void createSummaryServiceHeader(Workbook workbook, Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        headerCell = headerRow.createCell(0);
        CellStyle titleTableStyle = createStyleTable(workbook);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Подразделение");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(1);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Количество заказов");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(2);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Общая сумма продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(3);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Среднее число продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());
    }

    private void createCalendarForServiceHeader(Sheet sheet, LinkedHashMap<String, Object> header, Workbook workbook) {
        CellStyle titleTableStyle = createStyleTable(workbook);
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        int i = 2;
        for (String column : header.keySet()) {
            //TODO refactor
            if (column.equals("HEADER")) {
                Cell storeName = headerRow.createCell(0);
                storeName.setCellStyle(titleTableStyle);
                storeName.setCellValue("Подразделение");
                sheet.autoSizeColumn(storeName.getColumnIndex());
            }
            if (column.equals("TOTAL")) {
                Cell total = headerRow.createCell(1);
                total.setCellStyle(titleTableStyle);
                total.setCellValue("Всего");
                sheet.autoSizeColumn(total.getColumnIndex());
            }
            if (column.equals("SUB_TITLE")) {
                continue;
            }
            headerCell = headerRow.createCell(i);
            headerCell.setCellStyle(titleTableStyle);
            headerCell.setCellValue(column);
            sheet.autoSizeColumn(headerCell.getColumnIndex());
            i++;
        }
    }

    private void fillSalesDetailTable(Workbook workbook, List<LinkedHashMap<String, Object>> data) {
        Sheet sheet = workbook.createSheet("SalesDetailReport");
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        LinkedHashMap<String, Object> map = data.get(0);
        createSalesDetailHeader(sheet, map, workbook);
        Row dataRow;
        Cell dataCell;
        for (LinkedHashMap<String, Object> mapValue : data) {
            dataRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
            int i = 0;
            for (String key : mapValue.keySet()) {
                if (key.equals("id") || key.equals("orderSt")) {
                    continue;
                }
                dataCell = dataRow.createCell(i);
                try {
                    dataCell.setCellValue(Float.valueOf(mapValue.get(key).toString()));
                } catch (NumberFormatException e) {
                    dataCell.setCellValue(mapValue.get(key).toString());
                }
                i++;
            }
        }
    }

    private void createSalesDetailHeader(Sheet sheet, LinkedHashMap<String, Object> headers, Workbook workbook) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        headerCell = headerRow.createCell(0);
        CellStyle titleTableStyle = createStyleTable(workbook);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Дата продажи");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(1);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Номер Заказа");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(2);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Время продажи");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(3);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Общая сумма продаж");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(4);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Скидка");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(5);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Сумма продаж без скидки");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(6);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Налоги");
        sheet.autoSizeColumn(headerCell.getColumnIndex());

        headerCell = headerRow.createCell(7);
        headerCell.setCellStyle(titleTableStyle);
        headerCell.setCellValue("Сумма дополнительного налога");
        sheet.autoSizeColumn(headerCell.getColumnIndex());
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
