package com.b2c.register.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.model.SysUser;
import com.b2c.register.handler.ListenerHandler;
import com.b2c.register.service.IUserService;
import com.google.gson.Gson;
import com.sun.tools.doclets.internal.toolkit.MemberSummaryWriter;

@Controller
@RequestMapping("register")
public class RegisterController {

	@Autowired
	private IUserService userService; 
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ListenerHandler listenerHandler;
	
	@RequestMapping("toRegister")
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping("register")
	public String register(SysUser user){
		SysUser regUser = userService.register(user);
		//上傳注册邮件到mq
		Gson gson = new Gson();
		String json = gson.toJson(regUser);
		rabbitTemplate.convertAndSend(json);
		return "goto";
	}
	
	//激活账号
	@RequestMapping(value="activate/{id}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String active(@PathVariable Integer id,String activateUuid,HttpSession session){
		String info = userService.updateState(id,activateUuid);
		if ("success".equals(info)) {
			String msg = "<script>alert('激活成功！！');location.href='http://localhost:8086/b2c-login/login/toLogin';</script>";
			
			return msg;
		}else {
			return "<script>alert('激活失败！！');location.href='http://localhost:8086/b2c-login/login/toLogin';</script>";
		}
	}
	
	@RequestMapping(value="checkCode",produces="text/html;charset=utf-8")
	@ResponseBody
	public String checkCode(String phoneCode,HttpSession session){
		listenerHandler.setSession(session);
		String code = (String) session.getAttribute("code");
		if(phoneCode.equals(code)){
			return "<font color='green'>验证成功</font>" ;
		}
		return "<font color='red'>验证失败</font>";
	}
	
}
