package com.b2c.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.commons.pojo.AllNode;
import com.b2c.mapper.ProductCategoryMapper;
import com.b2c.model.EachCategory;
import com.b2c.model.ProductCategory;
import com.b2c.model.ProductCategoryExample;
import com.b2c.model.ProductCategoryExample.Criteria;
import com.b2c.service.IProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public List<ProductCategory> listCategoryByPid(int pid) {

		ProductCategoryExample example = new ProductCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		return productCategoryMapper.selectByExample(example);
	}

	@Override
	public List<AllNode<String>> getAllCategory(Integer pid) {
		List<ProductCategory> list = listCategoryByPid(pid);
		List<AllNode<String>> result = new ArrayList<>(list.size());
		if(list!=null && !list.isEmpty()){
			for (ProductCategory productCategory : list) {
				AllNode<String> node = new AllNode<>();
				node.setName(productCategory.getName());
				node.setId(productCategory.getId());
				if(productCategory.getIsParent()==1){
					node.setChild(getAllCategory(productCategory.getId()));
				}else{
					node.setChild(null);
				}
				result.add(node);
			}
		}
		return result;
	}

	
}
