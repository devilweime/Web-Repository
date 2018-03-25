package com.b2c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.b2c.service.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("/img")
	@ResponseBody
	public String uploadImg(MultipartFile file){
		String imgUrl = uploadService.uploadFile(file);
		return imgUrl;
	}
	
}
