package com.b2c.model;

import java.util.List;

public class EachCategory {
	private ProductCategory category;
	private List<ProductCategory> list;//次级菜单
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public List<ProductCategory> getList() {
		return list;
	}
	public void setList(List<ProductCategory> list) {
		this.list = list;
	}
}
