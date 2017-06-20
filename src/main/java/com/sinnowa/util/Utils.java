package com.sinnowa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yiyuan on 17/5/8.
 */
public class Utils {
    public static Date getStartTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return  cal.getTime();
    }

    public static Date getTimeBeforeTwoHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)-2);
        return  cal.getTime();
    }

    public static Object[] getStartEndDate(String json){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String str = "2017-05-24 21:14:29";
        Date baseDate,startDate=null,endDate=null;
        try {
            baseDate = sdf.parse(json);
            startDate = Utils.getStartTimeOfDay(baseDate);
            endDate = Utils.getEndTimeOfDay(baseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Object[] objects = new Object[]{startDate,endDate};
        return objects;
    }

    public static Object[] getNewSampleDate(String json){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date baseDate = new Date();
        try {
            baseDate = sdf.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Object[] objects = new Object[]{baseDate,new Date()};
        return objects;
    }
}
