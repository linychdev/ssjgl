/*
 * @(#)DateUtils.java 2016年9月29日下午3:43:17
 * dat2.0_common
 * Copyright 2016 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.common.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

/**
 * DateUtils 日期工具类
 * @author linych
 * @version 1.0
 *
 */
public final class DateUtils {
    /**
     * Logger
     */
    protected final static Logger LOG = LogUtils.getLogger();

    /** 23时 */
    private static final int HOUR_23 = 23;

    /** 59分 */
    private static final int MINUTE_59 = 59;

    /** 59秒 */
    private static final int SECOND_59 = 59;
    
    /** 星期 */
    private static final String[] WEEK_DAYS = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    
    /**
     * 禁止实例化
     */
    private DateUtils() {
        throw new AssertionError("工具类禁止实例化！");
    }
    
    /**
     * 得到当前日期 yyyy年MM月dd日（周一）
     * @return
     */
    public static String getShowDate() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar cal = Calendar.getInstance();
        String date = sdf.format(cal.getTime());
        date += "（" + WEEK_DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1] + "）";
        return date;
    }
    
    /**
     * 获得当天的截止时间 "2015-04-29 23:59:59"
     * @return 当天的截止时间
     */
    public static Date getTodayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, HOUR_23);
        calendar.set(Calendar.MINUTE, MINUTE_59);
        calendar.set(Calendar.SECOND, SECOND_59);
        return calendar.getTime();
    }
    
    /**
     * 获得传入日期的截止时间 "2015-04-29 23:59:59"
     * @return 传入日期的的截止时间
     */
    public static Date getDateEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, HOUR_23);
        calendar.set(Calendar.MINUTE, MINUTE_59);
        calendar.set(Calendar.SECOND, SECOND_59);
        return calendar.getTime();
    }

    /**
     * 获得日期 格式为2014226
     * @return String
     */
    public static String getSimpleDate() {
        Calendar cal = Calendar.getInstance();//使用日历类  
        int year = cal.get(Calendar.YEAR);//得到年  
        int month = cal.get(Calendar.MONTH) + 1;//得到月，因为从0开始的，所以要加1  
        int day = cal.get(Calendar.DAY_OF_MONTH);//得到天
        String date = String.valueOf(year) + String.valueOf(month) + String.valueOf(day);
        return date;
    }

    /**
     * 获得日期 格式为2014226
     * @return String
     */
    public static String getFormateSimpleDate() {
        Calendar cal = Calendar.getInstance();//使用日历类  
        int year = cal.get(Calendar.YEAR);//得到年  
        String month = getMonthOrDayFormat(cal.get(Calendar.MONTH) + 1);//得到月，因为从0开始的，所以要加1  
        String day = getMonthOrDayFormat(cal.get(Calendar.DAY_OF_MONTH));//得到天
        String date = String.valueOf(year) + String.valueOf(month) + String.valueOf(day);
        return date;
    }
    
    /**
     * 获得时间 格式为12:00:00
     * @return String
     */
    public static String getHms() {
        Calendar cal = Calendar.getInstance();//使用日历类  
        int hour = cal.get(Calendar.HOUR_OF_DAY);//得到小时 
        int minute = cal.get(Calendar.MINUTE);//得到分钟
        int second = cal.get(Calendar.SECOND);//得到分钟
        DecimalFormat df = new DecimalFormat("00");
        String hourString = df.format(hour);
        String minuteString = df.format(minute);
        String secondString = df.format(second);
        return hourString + ":" + minuteString + ":" + secondString;
    }
    /**
     * 获得时间 格式为12:00:00
     * @param date 传入的日期
     * @return String
     */
    public static String getHms(Date date) {
        Calendar cal = Calendar.getInstance();//使用日历类  
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);//得到小时 
        int minute = cal.get(Calendar.MINUTE);//得到分钟
        int second = cal.get(Calendar.SECOND);//得到分钟
        DecimalFormat df = new DecimalFormat("00");
        String hourString = df.format(hour);
        String minuteString = df.format(minute);
        String secondString = df.format(second);
        return hourString + ":" + minuteString + ":" + secondString;
    }
    
    /**
     * 获得时间 格式为 hh:mm
     * @param date 传入日期
     * @return String
     */
    public static String getHm(Date date) {
        Calendar cal = Calendar.getInstance();//使用日历类  
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);//得到小时 
        int minute = cal.get(Calendar.MINUTE);//得到分钟
        DecimalFormat df = new DecimalFormat("00");
        String hourString = df.format(hour);
        String minuteString = df.format(minute);
        return hourString+":"+minuteString;
    }

    /**
     * 得到前一天的开始时间
     * @return 前一天的开始时间
     */
    public static Date getYesterdayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();

    }

    /**
     * 得到前一天的截止时间
     * @return 前一天的截止时间
     */
    public static Date getYesterdayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, HOUR_23);
        calendar.set(Calendar.MINUTE, MINUTE_59);
        calendar.set(Calendar.SECOND, SECOND_59);
        return calendar.getTime();

    }

    /**
     * 判断指定日期是否在开始和结束日期之间
     * @param theDate 要判断的日期
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 指定日期是否在开始和结束日期之间
     */
    public static boolean isTheDateBetweenStartDateAndEndDate(Date theDate, Date startDate, Date endDate) {
        return startDate.before(theDate) && theDate.before(endDate);
    }
    
    /**
     * 获得当前时间
     * @return
     */
    public static Timestamp getCurrentDate(){
        return new Timestamp(System.currentTimeMillis());
    }
    
    
    /**
     * 获得当天的开始时间 "2015-04-29 00:00:00"
     * @return 当天的开始时间
     */
    public static Date getTodayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     * 获得传入日期的开始时间 "2015-04-29 00:00:00"
     * @return 出入日期的开始时间
     */
    public static Date getDateBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     * 根据传入日期和要加的月数返回新日期
     * @param date
     * @param n
     * @return
     */
    public static Timestamp addMonths(Timestamp date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, +n);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        return timestamp;
    }
    
    /**
     * 根据传入日期和要加的天数返回新日期
     * @param date
     * @param n
     * @return
     */
    public static Timestamp addDays(Timestamp date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        return timestamp;
    }

    /**
     * 根据传入日期和要加的分钟数返回新日期
     * @param date
     * @param n
     * @return
     */
    public static Timestamp addMinutes(Timestamp date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, +n);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        return timestamp;
    }
    
    /**
     * 根据传入日期和要加的天数返回新日期
     * @param date
     * @param n
     * @return
     */
    public static Date addDays(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        return calendar.getTime();
    }
    
    /**
     * @param dateStr 日期
     * @param pattern 模板
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(pattern)) {
            return null;
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error("日期转换出现错误");
        }
        return date;
    }

    /**
     * 格式化日期
     * @param date 日期
     * @param pattern 格式模板
     * @return 转换后的日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    /**
     * 格式化日期中年份
     * @param year 年
     * @return
     */
    public static String getYearFormat(int year) {
        DecimalFormat yearFormat = new DecimalFormat("0000");
        return yearFormat.format(year);
    }
    /**
     * 格式化日期中月份或日
     * @param monthOrDay 月或日
     * @return
     */
    public static String getMonthOrDayFormat(int monthOrDay) {
        DecimalFormat monthOrDayFormat = new DecimalFormat("00");
        return monthOrDayFormat.format(monthOrDay);
    }
    
    /**
     * 获得当前日期 yyyyMM
     * @return
     */
    public static String getCurrentYearAndMonth() {
        Calendar cal = Calendar.getInstance();
        return formatDate(cal.getTime(),"yyyyMM");
    }

    /**
     * 获得ods开始的整点时间
     * @param odsStartTime ods开始时间
     * @return
     */
    public static Date getDateOfOdsBegin(Integer odsStartTime) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, odsStartTime);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date currentDate = cal.getTime();
        return currentDate;
    }
    
    /**
     * 获取运行监控日期的开始时间
     * @param date Date类型日期
     * @param timeParse "19:00:00"格式的字符串
     * @return 运行监控时间的开始时间
     */
    public static Date getMonitorDateBegin(Date date, String timeParse){
        
        String[] ss = timeParse.split(":");
        String hour24 = ss[0]; 
        String minute = ss[1]; 
        String second = ss[2]; 
        
        Calendar monitorCal = Calendar.getInstance();
        monitorCal.setTime(date);
        monitorCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour24));
        monitorCal.set(Calendar.MINUTE, Integer.parseInt(minute));
        monitorCal.set(Calendar.SECOND, Integer.parseInt(second));
       
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        if(cal.before(monitorCal) || cal.equals(monitorCal)){
            monitorCal.add(Calendar.DAY_OF_MONTH, -1);
        }
        return monitorCal.getTime();
    }
    
    /**
     * 获取运行监控日期的结束时间
     * @param date Date类型日期
     * @param timeParse "19:00:00"格式的字符串
     * @return 运行监控时间的开始时间
     */
    public static Date getMonitorDateEnd(Date date, String timeParse){
        
        String[] ss = timeParse.split(":");
        String hour24 = ss[0]; 
        String minute = ss[1]; 
        String second = ss[2];
        
        Calendar monitorCal = Calendar.getInstance();
        monitorCal.setTime(date);
        monitorCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour24));
        monitorCal.set(Calendar.MINUTE, Integer.parseInt(minute));
        monitorCal.set(Calendar.SECOND, Integer.parseInt(second));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        if(cal.after(monitorCal)){
            monitorCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        monitorCal.add(Calendar.SECOND, -1);
        return monitorCal.getTime();
    }
    
    /**
     * 补全日期类型
     * @param date 格式为 YY-MM-DD
     * @return 返回 YY-MM-DD hh:mm:ss（hh:mm:ss为当前的 时分秒）
     */
    public static Date getDateAll(Date date) {
        Calendar cal = Calendar.getInstance();//使用日历类  
        int hour = cal.get(Calendar.HOUR_OF_DAY);//得到小时 
        int minute = cal.get(Calendar.MINUTE);//得到分钟
        int second = cal.get(Calendar.SECOND);//得到分钟
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        cal2.set(Calendar.HOUR_OF_DAY, hour);
        cal2.set(Calendar.MINUTE, minute);
        cal2.set(Calendar.SECOND, second);
        return cal2.getTime();
    }
    
    /**
     * 获取指定日期的 day
     * @param date 指定日期
     * @return
     */
    public static Integer getDay(Date date){
    	Calendar cal = Calendar.getInstance();//使用日历类  
    	cal.setTime(date);
    	int day = cal.get(Calendar.DAY_OF_MONTH);
    	return day;
    }
    
    
    /**
     * 根据时间和要加的数字返回年份
     * @param date 时间
     * @param n 要加的数字
     * @return
     */
    public static int addYears(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.get(Calendar.YEAR);
    }
}
