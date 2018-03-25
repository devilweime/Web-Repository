package com.b2c.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/index")
	public String home(HttpServletResponse response,Model model,HttpServletRequest request){
		/*boolean isCookie = true;//不存在
		Cookie[] cookies = request.getCookies();
		for (Cookie oldCookie : cookies) {
			if ("out_cart_token".equals(oldCookie.getName())) {
				isCookie=false;
			}
		}
		if (isCookie) {//不存在则生成
			Cookie cookie = new Cookie("out_cart_token",UUID.randomUUID().toString());
			cookie.setDomain("localhost");
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);
			//model.addAttribute(cookie);
			response.addCookie(cookie);
		}*/
		return "index";
	}
}
