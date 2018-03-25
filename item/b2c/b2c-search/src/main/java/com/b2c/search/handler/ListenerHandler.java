package com.b2c.search.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.b2c.commons.utils.HttpClientUtils;
import com.b2c.model.Product;
import com.b2c.service.ISearchService;
import com.google.gson.Gson;

public class ListenerHandler {
	
	@Autowired
	private ISearchService searchService;
	
	public void listen(String json) {
		
		//HttpClientUtils instance = HttpClientUtils.getInstance();
		//同步到索引
		//instance.doPost("http://localhost:8082/b2c-search/search/synDataByJson", json);
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);
		searchService.synDataByJson(product);
	}
}

