package com.cyt.music.impl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author: chenyantao
 * @since: 2016-8-20  下午7:17:38
 * @Description:日期,时间工具类
 * @file: DateUtil.java
 */
public class DateUtil {
	
	/**
	 * 将时间转化为指定格式
	 * @param date
	 * @return
	 */
	public static Long getLongDateTime(Date date) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.valueOf(sd.format(date));
	}

	/**
	 * 获取当前日期 yyyy-mm-dd
	 */
	public static  String getNowDate(){
		Date d=new Date();//获取时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//转换格式
		return sdf.format(d);
	}

	public static void main(String[] args) {
		System.out.println(getNowDate());
	}
}
