package com.tania;

import java.util.List;
import java.util.Map;

/**
 * Created by tkolpakova on 06.07.17.
 */
public interface ReportCreator {
    final String[] COLUMN_NAMES = new String[] {"№", "Заведение", "Бренд", "ИНН", "Номер заказа",
            "Тип оплаты", "Сумма оплаты", "Дата оплаты", "Время оплаты",
            "Процентная ставка банка", "Процентная ставка BAK", "Комиссия банка", "Комиссия BAK"};
    final String[] VALUES_NAMES = new String[] {"storeName", "brandName", "storeINN", "orderNo",
            "paymentType", "paymentSum", "paymentDate", "paymentTime",
            "bankInterestRate", "BAKInterestRate", "bankCommission", "BAKCommission"};

    String create(List<Map<String, String>> data);
}
