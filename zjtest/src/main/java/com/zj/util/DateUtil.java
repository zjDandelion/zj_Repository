package com.zj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * @ClassName: DateUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author
 * @date 2018年5月22日 下午3:23:22
 *
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String PATTERN_DATETIME_STANRD = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE_STANRD = "yyyy-MM-dd";
    public static final String PATTERN_TIME_STANRD = "HH:mm:ss";

    /**
     * 将日期格式化为指定pattern的字符串 ，如果指定pattern不存在，使用默认pattern，格式为:"yyyy-MM-dd hh:mm:ss"
     * @param date
     * @param pattern
     * @return
     * @author
     * @date
     */
    public static String format(Date date, String pattern){
        if(date == null){
            return null;
        }
        String usePattern = null;
        try {
            if(StringUtils.isNotEmpty(pattern)){
                usePattern = pattern;
            }else{
                usePattern = PATTERN_DATETIME_STANRD;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(usePattern);
            return sdf.format(date);
        } catch (Exception e) {
            logger.error("Format Date:" + date + ", usePattern:{}" + usePattern, e);
            return null;
        }
    }

    /**
     * 将日期格式化为"yyyy-MM-dd"形式的字符串
     * @param date
     * @return
     * @author
     * @date
     */
    public static String formatDate(Date date){
        return format(date, PATTERN_DATE_STANRD);
    }

    /**
     * 将日期格式化为"HH:mm:ss"形式的字符串
     * @param date
     * @return
     * @author
     * @date
     */
    public static String formatTime(Date date){
        return format(date, PATTERN_TIME_STANRD);
    }

    /**
     * 根据指定Pattern解析字符串中的日期 ，如果指定pattern不存在，使用默认pattern，格式为:"yyyy-MM-dd hh:mm:ss"
     * @param dateStr
     * @param pattern
     * @return
     * @author
     * @date
     */
    public static Date parse(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        String usePattern = null;
        try {
            dateStr = dateStr.trim();
            if (StringUtils.isNotEmpty(pattern)) {
                usePattern = pattern;
            } else if (dateStr.length() == 10) {
                usePattern = PATTERN_DATE_STANRD;
            } else if (dateStr.length() == 8) {
                usePattern = PATTERN_TIME_STANRD;
            } else {
                usePattern = PATTERN_DATETIME_STANRD;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(usePattern);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("Parse Date:" + dateStr + ", usePattern:" + usePattern, e);
            return null;
        }
    }

    /**
     * 将指定Pattern为"yyyy-MM-dd"字符串解析为Date类型
     */
    public static Date parseDate(String dateStr) {
        return parse(dateStr, PATTERN_DATE_STANRD);
    }

    /**
     * 将指定Pattern为"HH:mm:ss"字符串解析为Date类型
     */
    public static Date parseTime(String dateStr) {
        return parse(dateStr, PATTERN_TIME_STANRD);
    }

    /**
     * 获取当前日期 new Date()
     * @return
     * @author
     * @date
     */
    public static Date getSysDate(){
        return new Date();
    }

    /**
     * 获取yyyy-MM-dd 格式当前日期
     * @return
     * @author
     * @date
     */
    public static String getCurDateStr(){
        return formatDate(getSysDate());
    }

    /**
     * 获取当前时间 HH:mm:ss SSS000
     * @return
     * @author
     * @date
     */
    public static String getCurTimeStr() { SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS000");
        String curTimeStr = sdf.format(getSysDate());
        return curTimeStr;
    }

    /**
     * 日-月-年（28-Jan-2018)
     * @param src
     * @return
     * @author
     * @date
     */
    public static String getDateStr(Date src) {
        if (src == null) {
            src = new Date();
        }
        Calendar cd = Calendar.getInstance();
        cd.setTime(src);
        String yearStr = cd.get(Calendar.YEAR) + "";// 获取年份
        int month = cd.get(Calendar.MONTH);// 获取月份
        int day = cd.get(Calendar.DATE);// 获取日
        String dayStr = day < 10 ? "0" + day : day + "";
        String[] monthEnArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        String monthEn = monthEnArray[month];
        String dateStr = dayStr + "-" + monthEn + "-" + yearStr;
        return dateStr;
    }

    /**
     * March.25,2018|March.1,2018
     * @param src
     * @return
     * @author
     * @date
     */
    public static String getEnMonDayYear(Date src) {
        if (src == null) {
            src = new Date();
        }
        Calendar cd = Calendar.getInstance();
        cd.setTime(src);
        String yearStr = cd.get(Calendar.YEAR) + "";// 获取年份
        int month = cd.get(Calendar.MONTH);// 获取月份
        String day = cd.get(Calendar.DATE) + "";// 获取日
        String[] monthEnArray = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String monthEn = monthEnArray[month];
        String dateStr = monthEn + "." + day + "," + yearStr;
        return dateStr;
    }

    /**
     * 返回 d1 - d2 之间相差的月份数
     * @param d1
     * @param d2
     * @return
     * @author
     * @date
     */
    public static int monthsBetween(Date d1, Date d2) {
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(d1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(d2);
        int c = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12
                + (cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH));
        return c;
    }

    /**
     * 返回 d1 - d2 之间相差的天数
     * @param d1
     * @param d2
     * @return
     * @author
     * @date
     */
    public static int daysBetween(Date d1, Date d2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(d2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 判断当前时间是否在指定时间date之前
     * @param date
     * @return
     * @author
     * @date
     */
    public static boolean isAfterNow(Date date) {
        try {
            Date now = getSysDate();
            return now.before(date);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否周末
     * @param theDay
     * @return
     * @author
     * @date
     */
    public static boolean isWeekend(Calendar theDay) {
        int dayOfWeek = theDay.get(Calendar.DAY_OF_WEEK);

        return (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY);
    }

    /**
     * 根据日历字段(Calendar.YEAR, Calendar.MONTH...etc)和相应增量（正数为加负数为减）修改指定日期
     * @param d
     * @param type
     * @param number
     * @return
     * @author
     * @date
     */
    public static Date incrDateByFieldType(Date d, String type, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        switch (type) {
            case "YEAR":
                calendar.add(Calendar.YEAR, number);
                break;
            case "MONTH":
                calendar.add(Calendar.MONTH, number);
                break;
            case "DAY":
                calendar.add(Calendar.DAY_OF_MONTH, number);
                break;
            case "HOUR":
                calendar.add(Calendar.HOUR_OF_DAY, number);
                break;
            case "MINUTE":
                calendar.add(Calendar.MINUTE, number);
                break;
            default:
                break;
        }
        return calendar.getTime();
    }

    /**
     * 取本月第一天
     * @return
     * @author
     * @date
     */
    public static String getFirstDayOfMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_STANRD);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String firstDay = sdf.format(c.getTime());
        return firstDay;
    }

    /**
     * 获取中文周名称
     * @param date
     * @return
     * @author
     * @date
     */
    public static String getCNWeekName(Date date) {
        if (date == null)
            return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String[] weeksCN = new String[] { "周六", "周日", "周一", "周二", "周三", "周四", "周五" };
        int day = c.get(Calendar.DAY_OF_WEEK);
        return weeksCN[day % 7];
    }

    /**
     * 得到日期的星期数字[周一:1,周二：2,...周日：7]
     * @param date
     * @return
     * @author
     * @date
     */
    public static int getDayOfWeek(Date date) {
        if (date == null) {
            return 0;
        }
        int[] days = new int[] { 6, 7, 1, 2, 3, 4, 5 };
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return days[c.get(Calendar.DAY_OF_WEEK) % 7];
    }

    /**
     * long 时间 转成 seccod（秒
     * @param time
     * @return
     * @author
     * @date
     */
    public static int convertMills2Second(long time) {
        if (time <= 0) {
            return 0;
        }

        return new Long(time / 1000).intValue();
    }

    /**
     * 补充日期到参数日期的午夜(23:59:59)
     * @param src
     * @return
     * @author
     * @date
     */
    public static final Date patchDateToMidnight(Date src) {
        if (src == null) {
            return src;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(src);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 时间格式为HH:mm	其他格式无效
     * @param s1	HH:mm
     * @param s2	HH:mm
     * @return	0、等于	1、大于	-1、小于
     * @author
     * @date
     */
    public static int compTime(String s1, String s2) {
        try {
            if (s1.indexOf(":") < 0 || s1.indexOf(":") < 0) {
                logger.error("Date Pattern Err...");
            } else {
                String[] array1 = s1.split(":");
                int total1 = Integer.valueOf(array1[0]) * 3600 + Integer.valueOf(array1[1]) * 60;
                String[] array2 = s2.split(":");
                int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60;
                if (total1 - total2 == 0) {
                    return 0;
                } else if (total1 - total2 > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } catch (NumberFormatException e) {

            logger.error("compTime err...msg:{}", e.getMessage());
        }
        return 0;
    }

    /**
     * getAgeByBirth:通过生日计算年龄. <br/>
     * @param birthday
     * @param oneDay
     * @return
     * @author
     * @date
     */
    public static int getAgeByBirth(Date birthday, Date oneDay) {
        int age = 0;
        try {
            Calendar theDay = Calendar.getInstance();
            theDay.setTime(oneDay);// 指定一天

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(theDay)) {// 如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = theDay.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (theDay.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {// 兼容性更强,异常后返回数据
            return 0;
        }
    }

}
