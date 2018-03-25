package com.b2c.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.b2c.commons.utils.HttpClientUtils;
import com.b2c.model.Product;
import com.b2c.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping(method = RequestMethod.POST, value = "/addProduct")
	public void addProduct(Product product, HttpServletResponse response) {

		// 修改
		if (product != null && product.getId() != null && product.getId() != 0) {
			productService.updateProduct(product);
		}
		// 添加
		if (product == null || (product != null && product.getId() == null || product.getId() == 0)) {
			try {
				productService.addProduct(product);
				response.getWriter().write("ok");
				/*//httpClient同步solr索引
				Gson gson = new Gson();
				String json = gson.toJson(product);
				HttpClientUtils instance = HttpClientUtils.getInstance();
				//同步到索引
				instance.doPost("http://localhost:8082/b2c-search/search/synDataByJson", json);
				//生成静态页面
				instance.doPost("http://localhost:8083/b2c-detail/detail/staticPageByJson", json);*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/productList/{pageIndex}")
	public String productList(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		if (pageIndex == null || pageIndex == 0) {
			pageIndex = 1;
		}
		PageHelper.startPage(pageIndex, 2);
		List<Product> list = productService.getProductList();
		PageInfo<Product> pageInfo = new PageInfo<>(list, 5);
		model.addAttribute("pageInfo", pageInfo);
		return "productList";
	}

	@RequestMapping("/delBatch/{ids}")
	public String delBatch(@PathVariable("ids") String ids) {
		productService.delBatch(ids);
		return "redirect:/product/productList/1";
	}

	@RequestMapping("/delById/{id}")
	public String deById(@PathVariable("id") Integer id) {
		productService.deById(id);
		return "redirect:/product/productList/1";
	}

	@RequestMapping("/toUpdateProduct/{id}")
	public String toUpdateProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "updateProduct";
	}
}
