package com.b2c.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.b2c.login.service.IUserService;
import com.b2c.model.SysUser;

@Controller
@RequestMapping("login")
public class LoginCotroller {

	@Autowired
	private IUserService userService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(SysUser user,HttpSession session){
		SysUser newUser = userService.checkUser(user);
		session.setAttribute("user", newUser);
		//增加积分
		rabbitTemplate.convertAndSend(newUser.getId());
		return "redirect:http://localhost:8081/b2c-front/page/index";
	}
	
}
