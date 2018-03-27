package com.pms.mailbag.response;

public class BaseResponse {
	
	public  final static String SUCCESS_CODE = "0";
	
	public final static String OPERATION_SUCCEESS = "operation success";
	
	public  final static String NO_MESSAGE = "";
	
	private String code;
	
	private Object data;
	
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
