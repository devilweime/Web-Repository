package com.pms.mailbag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.mailbag.dao.mapper.UserExtendMapper;
import com.pms.mailbag.dao.model.User;
import com.pms.mailbag.service.UserService;
import com.pms.mailbag.utils.Des3;


@Controller
public class PassportController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserExtendMapper userExtendMapper;
	
	@RequestMapping(value="/j_spring_security_check")
	public String j_spring_security_check(){
		return "admin";
	}
	
	@RequestMapping(value="/login")
	public String login(String error,Model model){
		if(error != null && !"".equals(error)){
			model.addAttribute("error", "用户名或密码错误");
		}
		return "login";
	}
	
	@RequestMapping(value="/loginout/return")
	public String loginout(HttpSession session){
		
		//TODO cookie
		//TODO 用户登录记录
		session.setAttribute("loginUser", null);
		session.setMaxInactiveInterval(0);
		
		return "login";
	}
	
	
	
	
}
