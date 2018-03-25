package com.b2c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b2c.model.SysUser;
import com.b2c.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/register")
	public String register(SysUser user){
		userService.register(user);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(SysUser user,Model model){
		SysUser newUser = userService.checkUser(user);
		if (newUser!=null) {
			return "redirect:/product/productList/1";
		}
		model.addAttribute("msg", "登录失败！！");
		return "login";
	}
	
}
