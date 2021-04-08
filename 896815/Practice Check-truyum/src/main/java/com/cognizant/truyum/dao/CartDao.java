package com.cognizant.truyum.dao;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.Cart;

@Component
public interface CartDao {
	void addCartItem(String userId,long menuItemnId);
	Cart getAllCartItems(String userId) throws GlobalExceptionHandler;
	void removeCartItem(String userId,long menuItemId);
}
