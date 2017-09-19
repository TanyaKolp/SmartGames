package com.tania;

import org.docx4j.wml.CTSdtDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanya on 14.08.17.
 */
public class TestFigny {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat(" hh-mm-ss");
        System.out.println(dateFormat.format(new Date()));
        System.out.println();
        Date d = new Date();
        long l = System.currentTimeMillis();
        Date ss = new Date();
        ss.setTime(l);
        d.setTime(l - 60000);

        System.out.println(dateFormat.format(ss) + " -- "+l);
        System.out.println(dateFormat.format(d));
    }

}
