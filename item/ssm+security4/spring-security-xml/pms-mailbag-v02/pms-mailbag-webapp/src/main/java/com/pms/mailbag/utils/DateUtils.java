package com.pms.mailbag.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String convertYMD(Date date){
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		
		return format.format(date);
	}
	
	public static String convertYMD(Date date,int day){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//calendar.set(Calendar.DATE,day);
		calendar.add(Calendar.DATE,day);
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		return format.format(time);
	}
	
	
	public static String convertYMD(String date,int day) throws ParseException{
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat("yy-MM-dd").parse(date));
			calendar.add(Calendar.DATE,day);
			Date createDate = calendar.getTime();
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
			return format.format(createDate);
		}
	
	public static void main(String[] args) throws ParseException {
		String convertYMD = convertYMD(new Date());
		System.out.println(convertYMD);
		
		String convertYMD2 = convertYMD(new Date(),4);
		System.out.println(convertYMD2);
		
		String convertYMD3 = convertYMD("2018-02-09",9);
		System.out.println(convertYMD3);
	}
	
	
}
