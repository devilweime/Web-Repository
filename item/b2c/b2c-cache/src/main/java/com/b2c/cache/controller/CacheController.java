package com.b2c.cache.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.b2c.cache.service.IUserCartService;
import com.b2c.commons.pojo.CartItem;
import com.b2c.commons.pojo.shoppingCart;
import com.b2c.model.SysUser;
import com.google.gson.Gson;
import com.sun.tools.jdi.VoidTypeImpl;

import redis.clients.jedis.JedisCluster;

@Controller
public class CacheController {

	@Autowired
	private JedisCluster jedisCluster;

	@Autowired
	private IUserCartService userCartService;
	
	@RequestMapping("/set")
	@ResponseBody
	public String set(String key, String value) {
		String result = jedisCluster.set(key, value);
		return result;
	}

	@RequestMapping("/get")
	@ResponseBody
	public String get(String key) {
		String value = jedisCluster.get(key);
		return value;
	}

	@RequestMapping("/del")
	public Long del(String key) {
		Long count = jedisCluster.del(key);
		return count;
	}

	/* 未登录购物车 */
	@RequestMapping(value = "cartHset")
	public void cartHset(@RequestBody shoppingCart cart) {
		//Gson
		Gson gson = new Gson();
		CartItem cartItem = cart.getCartItem();
		// TODO
		Map<String, String> hgetAll = jedisCluster.hgetAll(cart.getCartKey());
		String productId = cartItem.getProduct().getId().toString();
		String value = hgetAll.get(productId);
		if (!"".equals(value) && value != null) {
			CartItem oldCartItem = gson.fromJson(hgetAll.get(productId),CartItem.class);
			cartItem.setCount(oldCartItem.getCount()+cartItem.getCount());
		}
		String json = gson.toJson(cartItem);
		jedisCluster.hset(cart.getCartKey(), cartItem.getProduct().getId().toString(), json);
		System.out.println(cart.getCartKey());
	}

	@RequestMapping(value = "cartHgetAll", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String cartHgetAll(String key) {// key---out_cart_token:....
		Map<String, String> cartMap = jedisCluster.hgetAll(key);
		// Collection<String> values = cartMap.values();
		return geShowCartJson(cartMap);
	}

	private String geShowCartJson(Map<String, String> cartMap) {
		Gson gson = new Gson();
		List<CartItem> list = new ArrayList<>();
		Set<Entry<String, String>> entrySet = cartMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			CartItem cartItem = gson.fromJson(entry.getValue(), CartItem.class);
			list.add(cartItem);
		}
		String json = gson.toJson(list);
		json = json.replaceAll("\\\\\\\\\\\\\\\\", "/");
		return json;
	}
	
	//登录与未登录的结合
	@RequestMapping(value = "getCart", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getCart(String inCartkey,String outCartkey){
		String json ="";
		Map<String, String> cartMap = getCartMapByKey(inCartkey, outCartkey);
		if (cartMap!=null && !cartMap.isEmpty()) {
			json = geShowCartJson(cartMap);
		}
		return json;
	}

	private Map<String, String> getCartMapByKey(String inCartkey, String outCartkey) {
		Map<String, String> outCart = null;
		Map<String, String> inCart = null;
		Gson gson = new Gson();
		if (outCartkey!=null && !"".equals(outCartkey.trim())) {
			//取出out集合
			if (jedisCluster.exists(outCartkey)) {
				outCart = jedisCluster.hgetAll(outCartkey);
			}
		}
		if (inCartkey!=null && !"".equals(inCartkey.trim()) && !"[]".equals(inCartkey.trim())) {
			//取出in的集合
			if (jedisCluster.exists(inCartkey)) {
				inCart = jedisCluster.hgetAll(inCartkey);
			}else{
				//取数据库数据
				String userId = inCartkey.split(":")[1];
				inCart = userCartService.getUserCart(userId);
				
			}
		}
		
		//合并数据
		if (outCart!=null && !outCart.isEmpty() && inCart!=null && !inCart.isEmpty()) {
			Set<Entry<String,String>> inSet = inCart.entrySet();
			Set<Entry<String, String>> outSet = outCart.entrySet();
			for (Entry<String, String> inEntry : inSet) {
				for (Entry<String, String> outEntry : outSet) {
					if (inEntry.getKey().equals(outEntry.getKey())) {
						CartItem inCartItem = gson.fromJson(inEntry.getValue(), CartItem.class);
						CartItem outCartItem = gson.fromJson(outEntry.getValue(), CartItem.class);
						outCartItem.setCount(inCartItem.getCount()+outCartItem.getCount());
						String itemJson = gson.toJson(inCartItem);
						outCart.put(outEntry.getKey(), itemJson);
					}
				}
			}
			//合并字段不相同数据
			inCart.putAll(outCart);
			//只保留相同数据
			jedisCluster.hmset(outCartkey, inCart);
			//清除redis数据
			jedisCluster.del(outCartkey);
			outCart=null;
			//TODO 返回数据,清除cookie(登陆后)
			return inCart;
		}
		
		//两种不相同状况
		//未登录
		if (outCart!=null && !outCart.isEmpty() && inCart==null || inCart.isEmpty()) {
			return outCart;
		}else if (outCart==null || outCart.isEmpty() && inCart!=null && !inCart.isEmpty()) {
			//已登录，但无outCart
			return inCart;
		}
		return null;
	} 
	
	//登录验证取值
	@RequestMapping(value="loginCheck",produces="application/json;charset=utf-8")
	@ResponseBody
	public String loginCheck(HttpServletRequest request){
		String callbackFunc = request.getParameter("callback");
		Cookie[] cookies = request.getCookies();
		String user_token ="";
		for (Cookie cookie : cookies) {
			if ("user_token".equals(cookie.getName())) {
				user_token = "user_token:"+cookie.getValue();
			}
		}
		String userJson = jedisCluster.get(user_token);
		Gson gson = new Gson();
		SysUser user = gson.fromJson(userJson, SysUser.class);
		user.setPassword(null);
		String json = gson.toJson(user);
		return callbackFunc+"("+json+")";
	}
	
	

}
