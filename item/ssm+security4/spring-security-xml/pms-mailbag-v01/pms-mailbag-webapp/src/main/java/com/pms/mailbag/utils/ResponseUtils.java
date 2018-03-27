package com.pms.mailbag.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.pms.mailbag.messageAndCode.container.MessageCodeModelContainer;
import com.pms.mailbag.messageAndCode.extraction.BaseEnCode;
import com.pms.mailbag.messageAndCode.model.MessageAndCode;
import com.pms.mailbag.response.BaseResponse;

public class ResponseUtils {

	public static BaseResponse getResponse(Object data, String message) {
		
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);
		
		boolean success = false;
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext(); 
		MessageCodeModelContainer messageCodeModelContainer = (MessageCodeModelContainer) wac.getBean("MessageCodeModelContainer");
		Map<String, MessageAndCode> container = messageCodeModelContainer.getContainer();
		Set<Entry<String,MessageAndCode>> entrySet = container.entrySet();
		for (Entry<String, MessageAndCode> entry : entrySet) {
			if(entry.getKey().equals(message.trim())){
				MessageAndCode messageAndCode = entry.getValue();
				baseResponse.setCode(messageAndCode.getCode());
				baseResponse.setMessage(messageAndCode.getMessage());
				success = true;
			}
		}
		if(!success){
			//throw new RuntimeException("该异常未被定义");
			baseResponse.setCode("10000");
			baseResponse.setMessage(message);
		}
		return baseResponse;
	}
	
	
	public static BaseResponse getResponse(Object data){
		
		if(data == null){
			//data = "暂无数据";
			data = "";
		}
		String message = BaseEnCode.No_MESSAGE_SUCCEESS;
		return getResponse(data, message);
		
	}
	
	public static BaseResponse getResponse(Object data,Exception exception){
		String message = exception.getMessage();
		return getResponse(data, message);
	}
	
	
	public static BaseResponse getResponse(Exception exception){
		String data = "";
		return getResponse(data, exception);
	}
	
	
	
	public static BaseResponse getResponse(String message){
		BaseResponse baseResponse = new BaseResponse();
		Object data = "";
		baseResponse = getResponse(data);
		baseResponse.setMessage(message);
		return baseResponse;
	}

}
