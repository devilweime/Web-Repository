package com.pms.mailbag.messageAndCode;

public enum BaseMessageCode {

	SUCCEESS("0",""),
	
	UNEXPECTED_ERROR("10000","发生我们预料之外的异常，请反馈给我们");
	
	
	
	
	private String code;
	private String messge;
	
	public String getCode(){
		return code;
	}
	
	public String getMessge(){
		return messge;
	}
	
	
	BaseMessageCode(String code,String messge){
		this.code = code;
		this.messge = messge; 
	}
	
	public static String getCodeByMessage(String message){
		
		BaseMessageCode[] baseMessageCodes = BaseMessageCode.values();
		for (BaseMessageCode baseMessageCode : baseMessageCodes) {
			String enumMessge = baseMessageCode.getMessge();
			if(enumMessge.equals(message.trim())){
				return baseMessageCode.getCode();
			}
		}
		
		return "";
	}
	
}
