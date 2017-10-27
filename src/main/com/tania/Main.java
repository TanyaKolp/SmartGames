package com.tania;

import java.sql.Time;
import java.util.Date;

/**
 * Created by tanya on 11.10.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println((new Byte("10") / 100.0));
        System.out.println((new Byte("10") / 100));
        Date now = java.sql.Date.valueOf("2017-01-01");

        Time time = Time.valueOf("16:44:50");
        if (time.after(now)) {
            System.out.println("yes");
        }
        if (now.after(time)) {
            System.out.println("now yes");
        }
    }
}
