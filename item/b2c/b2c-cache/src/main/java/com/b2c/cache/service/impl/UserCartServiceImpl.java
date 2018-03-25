package com.b2c.cache.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.cache.service.IUserCartService;
import com.b2c.commons.pojo.CartItem;
import com.b2c.mapper.ProductMapper;
import com.b2c.mapper.UserCartMapper;
import com.b2c.model.Product;
import com.b2c.model.UserCart;
import com.b2c.model.UserCartExample;
import com.b2c.model.UserCartExample.Criteria;
import com.google.gson.Gson;
@Service
public class UserCartServiceImpl implements IUserCartService{

	@Autowired
	private UserCartMapper userCartMapper;
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Map<String, String> getUserCart(String userId) {
		UserCartExample example = new UserCartExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(new Integer(userId));
		List<UserCart> simpleCart = userCartMapper.selectByExample(example);
		Map<String,String> inCart = new HashMap<>();
		Gson gson = new Gson();
		if (simpleCart!=null && !simpleCart.isEmpty()) {
			for (UserCart userCart : simpleCart) {
				Product product = productMapper.selectByPrimaryKey(userCart.getProductId());
				CartItem cartItem = new CartItem();
				cartItem.setCount(userCart.getCount());
				cartItem.setProduct(product);
				String cartItemJson = gson.toJson(cartItem);
				inCart.put(product.getId().toString(), cartItemJson);
			}
		}
		return inCart;
	}

}
