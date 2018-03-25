package com.b2c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.commons.pojo.Page;
import com.b2c.model.Product;
import com.b2c.service.ISearchService;
import com.google.gson.Gson;

@Controller
@RequestMapping("search")
public class SearchController {
	@Autowired
	private ISearchService searchService;
	
	@RequestMapping("synAllData")
	@ResponseBody
	public String synAllDate(){
		try {
			searchService.synAllDate();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	//get的方式
	@RequestMapping(value="/queryByMain/{pageIndex}")
	public String queryByMain(String mainSearch,@PathVariable Integer pageIndex,Model model){
		Page page = searchService.queryByMain(mainSearch,pageIndex,2);
		model.addAttribute("page",page);
		model.addAttribute("mainSearch",mainSearch);
		return "list";
	}
	//ajax
	@RequestMapping(value="/queryByMainAjax/{pageIndex}")
	public String queryByMainAjax(String mainSearch,@PathVariable Integer pageIndex,Model model){
		Page page = searchService.queryByMain(mainSearch,pageIndex,2);
		model.addAttribute("page",page);
		model.addAttribute("mainSearch",mainSearch);
		return "goods";
	}
	
	//同步数据ByJson
	@RequestMapping("/synDataByJson")
	public void synDataByJson(@RequestBody String json){
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);
		searchService.synDataByJson(product);
	}
}
