package com.b2c.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.swing.event.CaretListener;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.commons.pojo.AllNode;
import com.b2c.commons.utils.HttpClientUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/front")
public class FrontController {

	@RequestMapping("rollImageFirst")
	@ResponseBody
	public String rollImage() {
		HttpClientUtils instance = HttpClientUtils.getInstance();
		String doGet = instance.doGet("http://localhost:8080/b2c-background/rollImage/firstLayer");
		return doGet;
	}

	@RequestMapping(value = "/allCategory", produces = "application/json;charset=UTF-8")
	public String allCategory(Model model) {
		HttpClientUtils instance = HttpClientUtils.getInstance();
		String doGet = instance.doGet("http://localhost:8080/b2c-background/productCategory/allCategory/0");
		Gson gson = new Gson();
		List<AllNode<String>> catList = gson.fromJson(doGet, new TypeToken<List<AllNode<String>>>() {
		}.getType());
		model.addAttribute("catList", catList);
		return "index";
	}

	@RequestMapping("/index")
	public String home(Model model) {
		// 转发的数据
		HttpClientUtils instance = HttpClientUtils.getInstance();
		String doGet = instance.doGet("http://localhost:8080/b2c-background/productCategory/allCategory/0");
		Gson gson = new Gson();
		List<AllNode<String>> catList = gson.fromJson(doGet, new TypeToken<List<AllNode<String>>>() {
		}.getType());
		model.addAttribute("catList", catList);
		return "index";// 渲染网页
	}
}
