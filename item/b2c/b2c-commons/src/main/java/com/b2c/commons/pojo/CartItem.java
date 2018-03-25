package com.b2c.commons.pojo;

import com.b2c.model.Product;

public class CartItem {

	private Product product;
	private Integer count;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
