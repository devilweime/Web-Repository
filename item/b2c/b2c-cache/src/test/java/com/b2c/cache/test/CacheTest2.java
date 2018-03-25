package com.b2c.cache.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-cache.xml"})//加载spring配置文件
public class CacheTest2 {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Test
	public void test(){
		String result = jedisCluster.set("spring", "test");
		System.out.println(result);
		String value = jedisCluster.get("spring");
		System.out.println(value);
	}
	
}
