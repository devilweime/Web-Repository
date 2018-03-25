package com.b2c.score.test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test01 {

	public static void main(String[] args) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(calendar);
	}
	
}
