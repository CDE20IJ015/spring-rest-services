package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService {
	
	@Autowired
	CartDao cartDao;
	
	public void addCartItem(String userId,long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public Cart getAllCartItem(String userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItem(String userId,long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
