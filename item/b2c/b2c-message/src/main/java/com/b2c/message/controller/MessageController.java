package com.b2c.message.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b2c.message.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private RabbitTemplate rabbitTemplate; 
	
	@RequestMapping("sendCode")
	public void sendCode(String phone){
		String code =  messageService.sendCode(phone);
		rabbitTemplate.convertAndSend("code_key", code);
	}
	
}
