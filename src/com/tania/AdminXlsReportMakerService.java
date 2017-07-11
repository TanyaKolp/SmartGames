package com.tania;

import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 10.07.17.
 */
public interface AdminXlsReportMakerService {
    String createXlsReport(List<Map<String, String>> data, List<String> headers);

    String createBrandReport(Map<Object, Object> result);

    String createItemReport();

    String createCategoryReport();

    String createServiceReport();

    String createCardApprovalReport();

}
