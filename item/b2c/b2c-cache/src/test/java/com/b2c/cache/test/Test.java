package com.b2c.cache.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		String str="\\\\b\\\\";
		System.out.println(str);
		str.replaceAll("\\\\\\\\", "/");
		System.out.println(str);
		String str1 ="str";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(str1+i);
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("json:"+json);
	}
}
