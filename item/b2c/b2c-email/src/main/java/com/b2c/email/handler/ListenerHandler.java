package com.b2c.email.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.b2c.model.SysUser;
import com.google.gson.Gson;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class ListenerHandler {

	@Autowired
	private JavaMailSenderImpl sender;
	
	public void listen(String json){
		Gson gson = new Gson();
		SysUser user = gson.fromJson(json, SysUser.class);
		String chain = "http://localhost:8085/b2c-register/register/activate/"+user.getId()+"?activateUuid="+user.getActivateUuid();
		StringBuffer emailMsg = new StringBuffer();
		emailMsg.append("激活账号链接：<a href=\"");
		emailMsg.append(chain);
		emailMsg.append("\">");
		emailMsg.append(chain);
		emailMsg.append("</a>");
		SimpleMailMessage ssm = new SimpleMailMessage();
		ssm.setTo(user.getEmail());
		ssm.setSubject("商城激活邮件");
		ssm.setText(emailMsg.toString());
		sender.send(ssm);
	}

	public void setSender(JavaMailSenderImpl sender) {
		this.sender = sender;
	}
	
}
