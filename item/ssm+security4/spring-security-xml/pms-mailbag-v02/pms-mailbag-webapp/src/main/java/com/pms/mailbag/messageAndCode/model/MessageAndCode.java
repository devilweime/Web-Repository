package com.pms.mailbag.messageAndCode.model;

public class MessageAndCode {

	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageAndCode [code=" + code + ", message=" + message + "]";
	}
	
}
