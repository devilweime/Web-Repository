package com.pms.mailbag.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.mailbag.dao.model.User;
import com.pms.mailbag.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/getUserInfo",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String getUserInfo(@RequestBody User user){
		
	 	String userInfo = userService.getUserInfo(user);
		
		return userInfo;
	}
	
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String updatePassword(@RequestBody Map<String, String> paramMap){
		String username = ((String) paramMap.get("username")).trim();
		String oldPassword = ((String) paramMap.get("oldPassword")).trim();
		String newPassword = ((String) paramMap.get("newPassword")).trim();
		return userService.updatePassword(username,oldPassword,newPassword);
	}
	
	
}
