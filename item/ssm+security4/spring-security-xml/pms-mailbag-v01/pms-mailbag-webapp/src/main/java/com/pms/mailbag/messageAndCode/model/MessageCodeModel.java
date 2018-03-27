package com.pms.mailbag.messageAndCode.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MessageCodeModel {

	private String en_message;

	private MessageAndCode messageAndCode;

	public String getEn_message() {
		return en_message;
	}

	public void setEn_message(String en_message) {
		this.en_message = en_message;
	}

	public MessageAndCode getMessageAndCode() {
		return messageAndCode;
	}

	public void setMessageAndCode(MessageAndCode messageAndCode) {
		this.messageAndCode = messageAndCode;
	}

}
