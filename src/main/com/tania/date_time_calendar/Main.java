package com.tania.date_time_calendar;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by tanya on 09.11.17.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String time = "22:32";
        DateFormat timeFmt = new SimpleDateFormat("HH:mm");
        Calendar todaysTime = new GregorianCalendar();

        todaysTime.setTime(timeFmt.parse(time));
        System.out.println(todaysTime.get(Calendar.HOUR_OF_DAY));
        System.out.println(todaysTime.get(Calendar.MINUTE));
        System.out.println(todaysTime.getTime());
        System.out.println("******");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }
}
