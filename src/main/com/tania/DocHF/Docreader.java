package com.tania.DocHF;

import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.model.fields.merge.MailMerger;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanya on 03.08.17.
 */
public class Docreader {
    // Объект класса MyDataManager для работы с данными
    // Данные из фала *.xslx
    private List<HashMap> clientsRows;
    // Дополнительные данные из БД
    private List<HashMap> additionalData;

    // Инициирует создание файлов MS Word
    public void createDocs() {
        // Создаем объект класса MyDataManager для работы с данными
        // Извлекаем данные из файла MS Excel
        // <editor-fold defaultstate="collapsed" desc="Catch clauses">
        //</editor-fold>
        // Создаем файл MS Word и заполняем его
        addDataBlock();

    }

    // Создает файл MS Word и заполняет его
    private void addDataBlock() {
        int num = 0;
        // Считываем информацию о каждом клменте
        try {
            num++;
            // Извлекаем данные о существующем объекте MS Word
            WordprocessingMLPackage wordMLPackage =
                    WordprocessingMLPackage
                            .load(new File("result22.docx"));
            // Создаем объект для вставки значений в поля слияния
            List<Map<DataFieldName, String>> data = new ArrayList<Map<DataFieldName, String>>();
            // Получаем дополнительные данные о клиенте из базы
            // Заполняем значения для полей слияния
            Map<DataFieldName, String> map = new HashMap<DataFieldName, String>();
            map.put(new DataFieldName("Kundenname"), "MYname");
//            map.put(new DataFieldName("ADDRESS"), "MY_addressпо руссс");
            data.add(map);
            // Создаем новый объект MS Word на основе существующего и
            // значений полей слияния
            MailMerger.performMerge(wordMLPackage, map, true);
            // Сохраняем объект в файл
            wordMLPackage.save(new File("RESULT-fileпловы.docx"));
            // <editor-fold defaultstate="collapsed" desc="Catch clauses">
        } catch (InvalidFormatException ex) {
        } catch (Docx4JException ex) {
            // </editor-fold>
        }
    }
}
