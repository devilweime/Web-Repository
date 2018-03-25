package com.b2c.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.model.RollImage;
import com.b2c.service.IRollImageService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/rollImage")
public class RollImageController {
	@Autowired
	private IRollImageService rollImageService; 
	
	@RequestMapping("/firstLayer")
	@ResponseBody
	public String firstLayer(){
		List<RollImage> list = rollImageService.getImageList();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}

}
