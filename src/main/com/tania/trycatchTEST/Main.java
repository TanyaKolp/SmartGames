package com.tania.trycatchTEST;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanya on 18.09.17.
 */
public class Main {
    public static int mTry() {
        try {
            int i = 1;
            /**
             * yyyy - year
             * MM - month
             * dd -day
             * HH - hour
             * mm - minute
             * ss -seconds
             * */
            if (i == 1) {
                throw new Exception();
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String format = df.format(new Date());
            System.out.println(format);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mTry());
    }
}
