package com.learning.tkzc.string;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTest {

    @Test
    public void test01() throws ParseException {

        String a = "aa.log.2020-02-04";
        int len = a.lastIndexOf(".");

        System.out.println(len);
        String str = a.substring(len);
        System.out.println(str);

        SimpleDateFormat date = new SimpleDateFormat(".yyyy-MM-dd");
        Date date2 = date.parse(str);
        System.out.println(date2);

    }


    @Test
    public void test02() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -1);
        System.out.println(now.getTime());

        Calendar compareCal = Calendar.getInstance();
        compareCal.clear();
        compareCal.set(Calendar.YEAR, now.get(Calendar.YEAR));
        compareCal.set(Calendar.MONTH, now.get(Calendar.MONTH));
        compareCal.set(Calendar.DATE, now.get(Calendar.DATE));
        compareCal.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
        System.out.println(compareCal.getTime());

    }

}
