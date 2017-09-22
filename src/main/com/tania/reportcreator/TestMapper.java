package com.tania.reportcreator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 21.07.17.
 */
public interface TestMapper {
    // Sales for accounting report
    List<LinkedHashMap<String, Object>> getSalesForAccountingReport(Map<Object, Object> paramMap);
}
