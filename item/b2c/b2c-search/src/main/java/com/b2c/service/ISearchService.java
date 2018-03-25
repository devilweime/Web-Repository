package com.b2c.service;

import java.util.List;

import com.b2c.commons.pojo.Page;
import com.b2c.model.Product;

public interface ISearchService {

	void synAllDate();

	Page queryByMain(String mainSearch, Integer pageIndex, Integer rows);
	void synDataByJson(Product product);

}
