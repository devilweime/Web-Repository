package com.b2c.rabbitmq.handler;

import com.b2c.commons.utils.HttpClientUtils;

public class ListenerHandler {
	public void listen(String json) {
		
		HttpClientUtils instance = HttpClientUtils.getInstance();
		//同步到索引
		instance.doPost("http://localhost:8082/b2c-search/search/synDataByJson", json);
		//生成静态页面
		instance.doPost("http://localhost:8083/b2c-detail/detail/staticPageByJson", json);
	}
}

