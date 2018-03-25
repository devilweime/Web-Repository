package com.b2c.rabbitmq.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitMQTest {
	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring\\applicationContext-rabbitmq.xml");
		RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
		template.convertAndSend("Hello, Rabbitmq!");
		Thread.sleep(1000);
		ctx.destroy();
	}
}
