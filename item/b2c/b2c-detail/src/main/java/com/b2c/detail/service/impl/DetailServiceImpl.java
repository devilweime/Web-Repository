package com.b2c.detail.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.b2c.detail.service.IDetailService;
import com.b2c.mapper.ProductMapper;
import com.b2c.model.Product;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class DetailServiceImpl implements IDetailService,ServletContextAware{
	
	private ServletContext servletContext;
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}
	
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	@Override
	public String staticPageById(Integer id) {
		Product product = productMapper.selectByPrimaryKey(id);
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		
			try {
				Template template = configuration.getTemplate("product_detail.ftl");
				Map<String,Object> map = new HashMap<>();
				map.put("product", product);
				Writer out = new FileWriter(servletContext.getRealPath("\\product")+File.separator+product.getId()+".html");
				template.process(map, out);
			} catch (IOException e) {
				e.printStackTrace();
				return "error";
			} catch (TemplateException e) {
				e.printStackTrace();
				return "error";
			}
		return "success";
	}

	@Override
	public void staticPageByJson(Product product) {
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		try {
			Template template = configuration.getTemplate("product_detail.ftl");
			Map<String, Object> map = new HashMap<>();
			map.put("product", product);
			Writer out = new FileWriter(servletContext.getRealPath("\\product")+File.separator+product.getId()+".html");
			template.process(map, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	
}
