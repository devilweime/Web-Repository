package com.b2c.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.apache.taglibs.standard.tlv.JstlBaseTLV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.b2c.commons.pojo.AllNode;
import com.b2c.model.ProductCategory;
import com.b2c.service.IProductCategoryService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryContoller {

	@Autowired
	private IProductCategoryService productCategoryService;
	
	@RequestMapping("/list/{pid}")
	@ResponseBody
	public List<ProductCategory> listCategoryByPid(@PathVariable("pid") int pid){
		return productCategoryService.listCategoryByPid(pid);
	}
	/*jstl传输方式*/
	/*@RequestMapping("/allCategory/{pid}")
	@ResponseBody
	public List<AllNode<String>> allCategory(@PathVariable Integer pid,Model model){
		List<AllNode<String>> result = productCategoryService.getAllCategory(pid);
		return result;
	}*/
	
	/*jsonp的方式*/
	@RequestMapping(value="/allCategory/{pid}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String allCategory(@PathVariable Integer pid,Model model,HttpServletRequest request){
		List<AllNode<String>> result = productCategoryService.getAllCategory(pid);
		Gson gson = new Gson();
		String json = gson.toJson(result);
		String callbackFunc = request.getParameter("callback");
		if (StringUtils.isEmpty(callbackFunc)) {
			return json;
		}
		return callbackFunc+"("+json+")";
	}
}
