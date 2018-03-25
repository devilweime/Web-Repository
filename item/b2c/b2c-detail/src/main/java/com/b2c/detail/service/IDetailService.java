package com.b2c.detail.service;

import com.b2c.model.Product;

public interface IDetailService {

	String staticPageById(Integer id);

	void staticPageByJson(Product product);


}
