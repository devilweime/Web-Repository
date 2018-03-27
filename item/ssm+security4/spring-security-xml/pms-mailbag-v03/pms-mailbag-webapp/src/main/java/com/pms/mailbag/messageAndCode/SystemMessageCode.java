package com.pms.mailbag.messageAndCode;

public enum SystemMessageCode {

	MAILBAG_CODE_NOT_FOUND("P001","邮袋编号未找到"),
	
	MAILBAG_ID_NOT_FOUND("P002","邮袋ID未找到");
	
	
	private String code;
	private String messge;
	
	public String getCode(){
		return code;
	}
	
	public String getMessge(){
		return messge;
	}
	
	
	SystemMessageCode(String code,String messge){
		this.code = code;
		this.messge = messge; 
	}
	
	public static String getCodeByMessage(String message){
		
		SystemMessageCode[] baseMessageCodes = SystemMessageCode.values();
		for (SystemMessageCode baseMessageCode : baseMessageCodes) {
			String enumMessge = baseMessageCode.getMessge();
			if(enumMessge.equals(message.trim())){
				return baseMessageCode.getCode();
			}
		}
		
		return "";
	}
	
}
