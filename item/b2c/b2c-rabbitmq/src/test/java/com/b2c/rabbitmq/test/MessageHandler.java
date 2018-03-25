package com.b2c.rabbitmq.test;

public class MessageHandler {
	public void listen(String msg) {
		System.out.println("接收到消息："+msg);
	}
}

