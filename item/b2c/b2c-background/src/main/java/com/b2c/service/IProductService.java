package com.b2c.service;

import java.util.List;

import com.b2c.model.Product;

public interface IProductService {

	void addProduct(Product product);

	List<Product> getProductList();

	void delBatch(String ids);

	void deById(Integer id);

	Product getProductById(Integer id);

	void updateProduct(Product product);

}
