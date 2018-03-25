package com.b2c.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/upload")
	public String uploadImgPage(){
		return "uploadTest";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(){
		return "addProduct";
	}
	
	@RequestMapping("/productList")
	public String productList(){
		return "productList";
	}
	
	@RequestMapping("/controller")
	public String controller(){
		return "controller";
	}
	
	@RequestMapping("/httpClient")
	public void httpClient(String username){
		System.out.println(username+"hello");
	}
}
