package com.b2c.detail.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.b2c.commons.utils.HttpClientUtils;
import com.b2c.detail.service.IDetailService;
import com.b2c.model.Product;
import com.google.gson.Gson;

public class ListenerHandler {
	@Autowired
	private IDetailService detailService;
	public void listen(String json) {
		//HttpClientUtils instance = HttpClientUtils.getInstance();
		//生成静态页面
		//instance.doPost("http://localhost:8083/b2c-detail/detail/staticPageByJson", json);
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);
		detailService.staticPageByJson(product);
	}
}

