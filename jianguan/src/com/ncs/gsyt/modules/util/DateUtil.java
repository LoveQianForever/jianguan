package com.ncs.gsyt.modules.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private static final String PAGE_SHOW_FORMAT = "yyyy年MM月dd日";
	/**
	 * 判断date是否为null
	 * @param date
	 * @return
	 */
	public static boolean isNull(Date date){
		return date == null;
	}
	/**
	* 获取指定格式的日期类型，尾部自动添加当天最小时间
	*/
	public static Date getMinDate(String dtString, String format) {
		try {
			DateFormat df=new SimpleDateFormat(format);
			Date date = df.parse(dtString + " 00:00:00");
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	* 获取指定格式的日期类型，尾部自动添加当天最大时间
	*/
	public static Date getMaxDate(String dtString, String format) {
		try {
			DateFormat df=new SimpleDateFormat(format);
			Date date = df.parse(dtString + " 23:59:59");
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 根据指定格式获取日期
	 * */
	public static Date getDate(String dtString, String format) {
		try {
			DateFormat df=new SimpleDateFormat(format);
			Date date = df.parse(dtString);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	* 获取yyyy年MM月dd日日期类型
	*/
	public static Date getDefaultMaxDate(String dtString) {
		return getMaxDate(dtString, PAGE_SHOW_FORMAT);
	}
	/**
	 * 按照指定字符串格式化日期
	 * */
	public static String formatDate(String dtString, String format) {
		try {
			DateFormat df=new SimpleDateFormat(format);
			return df.format(dtString);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 按照指定字符串格式化日期
	 * */
	public static String formatDate(Date date, String format) {
		try {
			DateFormat df=new SimpleDateFormat(format);
			return df.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 按照指定字符串格式化日期
	 * */
	public static String formatDate(Date date) {
		return formatDate(date , PAGE_SHOW_FORMAT);
	}
	
	public static int getYear(){
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR) %2000;
	}
	
	
	/**
	 * 返回当前时间指定长度日期时间
	 * */
	public static Date opDate(String type, int days) {
		Date d=new Date();
		if ("add".equals(type)) {
			return new Date(d.getTime() + days*24*60*60*1000);
		} else {
			return new Date(d.getTime() - days*24*60*60*1000);
		}
	}
	
	/**
	 * 返回当前时间指定长度日期时间
	 * */
	public static Date opDate(Date d, String type, long days) {
		Date d1 = new Date();
		if ("add".equals(type)) {
			d1 = new Date(d.getTime() + days*24*60*60*1000);
			return d1;
		} else {
			d1 = new Date(d.getTime() - days*24*60*60*1000);
			return d1;
		}
		
	}
	
	/**
	 * 返回当前时间字符串
	 * */
	public static String getNow() {
		Date d = new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(d);
	}
	
	/**
	 * 返回指定长度月数时间
	 * */
	public static Date getMonthDate(int monthNum) {
		Calendar   cal=Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int dayNum = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		if (dayNum>22) {
			cal.add(Calendar.MONTH, monthNum+1);
		} else {
			cal.add(Calendar.MONTH, monthNum);
		}
		return cal.getTime();
	}
	
	/**
	 * 根据传入的日期返回增加指定长度月数时间
	 * */
	public static Date addMonthDate(Date date, int monthNum) {
		Calendar   cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, monthNum);
		return cal.getTime();
	}
	
	/**
	 * 根据传入的日期返回下月的第一天
	 * */
	public static Date getNextMonthFirstDay(Date date) {
		Date d = DateUtil.getMonthLastDay(date);
		return DateUtil.addDayDate(d, 1);
	}
	
	/**
	 * 根据传入的日期加上指定天数返回日期
	 * */
	public static Date addDayDate(Date date, int dayNum) {
		Calendar   cal=Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DATE);
		cal.set(Calendar.DATE, day+dayNum);
		return cal.getTime();
	}
	
	
	/**
	 * 得到两个日期之间的月数
	 * */
	public static int getMonthNumbers(Date date1, Date date2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12
						+ objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}
	
	/**
	 * 根据传入的日期得到月份
	 * */
	public static int getMonthByDate(Date date) {
		Calendar   cal=Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}
	
	
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */  
	public static int daysBetween(Date smdate,Date bdate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	
	
	/**
	 * 获取当前月的第一天
	 * */
	public static Date getMonthFirstDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
		Date beginTime = cal.getTime();
		return beginTime;
	}
	
	/**
	 * 获取当前月的最后一天
	 * */
	public static Date getMonthLastDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set( Calendar.DATE, 1 );
		cal.roll(Calendar.DATE, - 1 );
		Date endTime=cal.getTime();
	    
	    return endTime;
	}
	
	public static void main(String[] args) {
		//System.out.println(DateUtil.formatDate(DateUtil.getMonthDate(3), "yyy-MM-dd HH:mm:ss"));
		//System.out.println(DateUtil.getMonthByDate(DateUtil.getDate("2013-01-01", "yyyy-MM-dd")));
		//System.out.println(DateUtil.formatDate(DateUtil.getMonthLastDay(DateUtil.getDate("2013-02-26", "yyyy-MM-dd")),"yyyy-MM-dd"));
		/*System.out.println(DateUtil.getSendTime("100002"));
		System.out.println(DateUtil.getSendTime("100003"));
		System.out.println(DateUtil.getSendTime("100010"));
		System.out.println(DateUtil.getSendTime("110000"));
		System.out.println(DateUtil.getSendTime("120000"));
		System.out.println(DateUtil.getSendTime("199999"));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		System.out.println(cal.getTimeInMillis());
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.HOUR, 16);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		System.out.println(cal1.getTimeInMillis());
		System.out.println(cal1.getTimeInMillis()-cal.getTimeInMillis());*/
		//System.out.println(DateUtil.getMonthNumbers(DateUtil.getDate("2014-01", "yyyy-MM"), DateUtil.getDate("2013-01", "yyyy-MM")));
		System.out.println(DateUtil.getNextMonthFirstDay(new Date()).toString());
	}
}