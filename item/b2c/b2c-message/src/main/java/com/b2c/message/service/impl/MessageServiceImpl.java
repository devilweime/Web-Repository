package com.b2c.message.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aliyuncs.exceptions.ClientException;
import com.b2c.commons.utils.MessageUtils;
import com.b2c.message.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {

	@Value("${SMS.signName}")
	private String signName;
	@Value("${SMS.templateCode}")
	private String templateCode;
	
	
	@Override
	public String sendCode(String phone) {
		
		/*生成6位随机数*/
		String original = "0123456789";
		int num = 6 ;//确定几位数
		char[] code = new char[num]; 
		for (int i = 0; i < num; i++) {
			int random = (int)(Math.random()*10);
			code[i]=original.charAt(random);
		}
		String codeStr = new String(code);
		//发送信息
		String templateParam = "{\"code\":\""+codeStr+"\"}";
		try {
			MessageUtils.sendMessage(phone, signName, templateCode, templateParam);
		} catch (ClientException e) {
			e.printStackTrace();
			return "";
		}
		
		return codeStr;
	}

}
