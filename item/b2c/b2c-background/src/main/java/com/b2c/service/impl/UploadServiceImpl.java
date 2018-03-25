package com.b2c.service.impl;

import java.io.File;
import java.io.IOException;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.b2c.commons.utils.FastDFSUtils;
import com.b2c.service.UploadService;
@Service
public class UploadServiceImpl implements UploadService{
	@Value("${IMAGE_SERVER_BASE_URL}")
	private String httpUrl;
	
	@Override
	public String uploadFile(MultipartFile file) {
		FastDFSUtils fastDFSUtils;
		String conf = "classpath:properties"+File.separator+"fastdfs.properties";
		String imgUrl = "";
		try {
			fastDFSUtils = new FastDFSUtils(conf);
			String filename = file.getOriginalFilename();
			String extName = filename.substring(filename.lastIndexOf(".")+1);
			imgUrl = fastDFSUtils.uploadFileByBytes(file.getBytes(), extName);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return httpUrl+File.separator+imgUrl;
	}

}
