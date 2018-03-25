package com.b2c.cache.service;

import java.util.Map;

import com.b2c.commons.pojo.CartItem;

public interface IUserCartService {

	Map<String, String> getUserCart(String userId);

}
