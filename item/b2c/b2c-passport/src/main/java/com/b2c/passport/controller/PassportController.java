package com.b2c.passport.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.http.HttpResponse;
import com.b2c.commons.utils.HttpClientUtils;
import com.b2c.model.SysUser;
import com.b2c.passport.service.IPassportService;
import com.google.gson.Gson;

@Controller
public class PassportController {
	@Autowired
	private IPassportService passportService;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(SysUser user,HttpServletResponse response,HttpSession session){
		String result = "用户或密码错误！！";
		SysUser newUser = passportService.checkIsExist(user);
		if (newUser!=null) {
			//将User存入session
			session.setAttribute("user",newUser);
			Gson gson  = new Gson();
			String userJson = gson.toJson(newUser);
			HttpClientUtils instance = HttpClientUtils.getInstance();
			Map<String, String> map = new HashMap<>();
			String user_token = UUID.randomUUID().toString();//"user_token:"+
			map.put("key","user_token:"+user_token);
			map.put("value", userJson);
			instance.doGet("http://localhost:8091/b2c-cache/set", map);
			Cookie cookie = new Cookie("user_token", user_token);
			cookie.setDomain("localhost");
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			result="ok";
		}
		return result;
	}
}
