package com.b2c.cart.service;

import com.b2c.commons.pojo.CartItem;

public interface ICartService {

	CartItem getCartItem(Integer productId, Integer count);

}
