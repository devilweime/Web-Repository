package com.b2c.service;

import java.util.List;
import java.util.Map;

import com.b2c.commons.pojo.AllNode;
import com.b2c.model.EachCategory;
import com.b2c.model.ProductCategory;

public interface IProductCategoryService {

	List<ProductCategory> listCategoryByPid(int pid);

	List<AllNode<String>> getAllCategory(Integer pid);

}
