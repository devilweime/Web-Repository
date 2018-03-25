package com.b2c.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.cart.service.ICartService;
import com.b2c.commons.pojo.CartItem;
import com.b2c.mapper.ProductMapper;
import com.b2c.model.Product;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private ProductMapper productMapper;

	@Override
	public CartItem getCartItem(Integer productId, Integer count) {
		Product product = productMapper.selectByPrimaryKey(productId);
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		return cartItem;
	}
	
	
	
}
