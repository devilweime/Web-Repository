package com.b2c.cart.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.cart.service.ICartService;
import com.b2c.commons.pojo.CartItem;
import com.b2c.commons.pojo.shoppingCart;
import com.b2c.commons.utils.HttpClientUtils;
import com.google.gson.Gson;

@Controller
public class CartController {
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value="test",produces="application/json;charset=utf-8")
	@ResponseBody
	public String test(Integer productId,Integer count,HttpServletRequest request){
		String callbackFunc = request.getParameter("callback");
		CartItem cartItem = cartService.getCartItem(productId,count);
		shoppingCart inCart = null;
		shoppingCart outCart = null;
		String outCartKey ="";
		String inCartKey ="";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("out_cart_token".equals(cookie.getName())) {
				//未登录购物车数据
				outCart = new shoppingCart();
				outCart.setCartItem(cartItem);
				outCartKey = cookie.getValue();
				outCart.setCartKey(cookie.getName()+":"+outCartKey);
			}
			if ("in_cart_token".equals(cookie.getName())) {
				//登录购物车数据
				inCart = new shoppingCart();
				inCart.setCartItem(cartItem);
				inCartKey = cookie.getValue();
				inCart.setCartKey(cookie.getName()+":"+inCartKey);
			}
		}
		HttpClientUtils instance = HttpClientUtils.getInstance();
		Gson gson = new Gson();
		String json = "";
		if (!"".equals(inCartKey)) {//已登录购物车
			json =gson.toJson(inCart);
		}else {//未登录购物车
			json = gson.toJson(outCart);
		}
		instance.doPost("http://localhost:8091/b2c-cache/cartHset", json);
		return callbackFunc+"({\"name\":\"wgw\"})";
	}
	
	@RequestMapping("gotoCart")
	public String gotoCart(){
		return "shoppingCart";
	}
	
	@RequestMapping(value="test2",produces="application/json;charset=utf-8")
	@ResponseBody
	public String test2(String key ,HttpServletRequest request){
		String callbackFunc = request.getParameter("callback");
		System.out.println(key);
		return callbackFunc+"({\"state\":\"ok\"})";
	}
	
	
	//跳转到购物车
	@RequestMapping(value="showCart",produces="text/html;charset=utf-8")
	@ResponseBody
	public String showCart(HttpServletRequest request){
		//key
		String outCartkey ="";
		String inCartkey ="";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("out_cart_token".equals(cookie.getName())) {
				String value = cookie.getValue();
				outCartkey = "out_cart_token:"+value;
			}if ("in_cart_token".equals(cookie.getName())) {
				String value = cookie.getValue();
				inCartkey = "in_cart_token:"+value;
			}
		}
		HttpClientUtils instance = HttpClientUtils.getInstance();
		//String doGet = instance.doGet("http://localhost:8091/b2c-cache/cartHgetAll?key="+outCartkey);
		Map<String, String> param = new HashMap<>();
		param.put("inCartkey",inCartkey);
		param.put("outCartkey",outCartkey);
		String doGet = instance.doGet("http://localhost:8091/b2c-cache/getCart", param );
		return doGet;
	}
	
}
