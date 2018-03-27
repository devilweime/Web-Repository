package com.pms.mailbag.messageAndCode;

public enum BusinessMessageCode {
	
	
	MAILBAG_IS_UNAVAILABLE("C001","当前邮袋不可用"),
	MAILBAG_IS_BAGGING("C002","当前邮袋正在装袋"),
	MAILBAG_IS_RECEIVED("C003","当前邮袋已被揽收"),
	MAILBAG_IS_DELIVERED("C004","当前邮袋已交付"),
	MAILBAG_IS_INVALIDATED("C005","当前邮袋已作废");
	
	
	private String code;
	private String messge;
	
	public String getCode(){
		return code;
	}
	
	public String getMessge(){
		return messge;
	}
	
	
	BusinessMessageCode(String code,String messge){
		this.code = code;
		this.messge = messge; 
	}
	
	public static String getCodeByMessage(String message){
		
		BusinessMessageCode[] baseMessageCodes = BusinessMessageCode.values();
		for (BusinessMessageCode baseMessageCode : baseMessageCodes) {
			String enumMessge = baseMessageCode.getMessge();
			if(enumMessge.equals(message.trim())){
				return baseMessageCode.getCode();
			}
		}
		
		return "";
	}
	
}
