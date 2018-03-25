package com.b2c.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.detail.service.IDetailService;
import com.b2c.model.Product;
import com.google.gson.Gson;

@Controller
@RequestMapping("/detail")
public class DetailController {

	@Autowired
	private IDetailService detailService;
	
	@RequestMapping("/createStaticPage/{id}")
	@ResponseBody
	public String createStaticPage(@PathVariable Integer id){
		String result = detailService.staticPageById(id);
		return result;
	}
	
	@RequestMapping("/staticPageByJson")
	public void staticPageByJson(@RequestBody String json){
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);
		detailService.staticPageByJson(product);
	}
	
}
