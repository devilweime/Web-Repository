package com.b2c.cache.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class CacheTest1 {

	@Test
	public void test(){
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.48.128", 6379));
		nodes.add(new HostAndPort("192.168.48.128", 6380));
		nodes.add(new HostAndPort("192.168.48.128", 6381));
		nodes.add(new HostAndPort("192.168.48.128", 6382));
		nodes.add(new HostAndPort("192.168.48.128", 6383));
		nodes.add(new HostAndPort("192.168.48.128", 6384));
		
		JedisCluster cluster = new JedisCluster(nodes);
		String result = cluster.set("test", "hhh");
		System.out.println(result);
		String value = cluster.get("test");
		System.out.println(value);
	}
	
}
