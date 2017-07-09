package com.tania;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tkolpakova on 06.07.17.
 */
public class AccountingReport {
    private Map<String, ReportCreator> reportCreators = new HashMap<>();

    public AccountingReport() {
        reportCreators.put("xls", new XlsReportCreator());
        reportCreators.put("csv", new CsvReportCreator());
        reportCreators.put("pdf", new PdfReportCreator());
    }

    public AccountingReport(Map<String, ReportCreator> reportCreators) {
        this.reportCreators = reportCreators;
    }

    public String createReport(List<Map<String, String>> data, String typeOfReport) {
        ReportCreator reportCreator = reportCreators.get(typeOfReport);
        if (reportCreator != null) {
            String linkFilePath = reportCreator.create(data);
            return linkFilePath;
        }
        return null;
    }
}
