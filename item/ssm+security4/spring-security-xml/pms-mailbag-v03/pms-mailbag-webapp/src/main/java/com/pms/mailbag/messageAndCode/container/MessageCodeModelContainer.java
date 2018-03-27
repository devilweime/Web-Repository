package com.pms.mailbag.messageAndCode.container;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.pms.mailbag.messageAndCode.model.MessageAndCode;

public class MessageCodeModelContainer {

	private String path;
	
	private Map<String, MessageAndCode> container;

	public Map<String, MessageAndCode> getContainer() {
		
		
		return container;
	}

	public void setContainer(Map<String, MessageAndCode> container) {
		this.container = container;
	}
	
	
	public MessageCodeModelContainer(){
		
	}
	
	@PostConstruct
	private void createContainer() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		this.container = new HashMap<String, MessageAndCode>();
		
		Properties properties = new Properties();
		//InputStreamReader inStream = new InputStreamReader(new FileInputStream("src\\main\\java\\com\\pms\\mailbag\\messageAndCode\\template\\messageAndcode.properties"), "UTF-8");
		//InputStreamReader inStream = new InputStreamReader(new FileInputStream("classpath:com/pms/mailbag/messageAndCode/template/messageAndcode.properties"), "UTF-8");
		//InputStreamReader inStream = new InputStreamReader(new FileInputStream(this.path), "UTF-8");
		File file = ResourceUtils.getFile(this.path);
		InputStreamReader inStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
		properties.load(inStream);
		Set<Entry<Object,Object>> entrySet = properties.entrySet();
		Gson gson = new Gson();
		for (Entry<Object, Object> entry : entrySet) {
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			MessageAndCode messageAndCode = gson.fromJson(value,MessageAndCode.class);
			container.put(key, messageAndCode);
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		MessageCodeModelContainer messageCodeModelContainer = new MessageCodeModelContainer();
		Map<String, MessageAndCode> container2 = messageCodeModelContainer.getContainer();
		System.out.println(container2);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
