package com.pms.mailbag.messageAndCode;

import java.util.HashMap;
import java.util.Map;

public class MessageAndCode {

	private static Map<Object, Object> messageAndCode;
	
	static{
		if(messageAndCode == null){
			messageAndCode = new HashMap<Object, Object>();
		}
		
		ParamterMessage[] paramterMessages = ParamterMessage.values();
		ParamterCode[] paramterCodes = ParamterCode.values();
		for (int i = 0; i < paramterMessages.length; i++) {
			messageAndCode.put(paramterMessages[i], paramterCodes[i]);
		}
		
		System.out.println(messageAndCode);
	}
	
	public static void main(String[] args) {
		
	}
	
}
