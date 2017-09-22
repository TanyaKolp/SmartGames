package com.tania.reportcreator;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by tanya on 10.07.17.
 */
public interface FORtestAdminXlsReportMakerService {
    String createSalesSumReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createBrandReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createItemReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createCategoryReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createServiceReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createSalesDetailReport(List<LinkedHashMap<String, Object>> data) throws IOException;

    String createCardApprovalReport(List<LinkedHashMap<String, Object>> data);

}
