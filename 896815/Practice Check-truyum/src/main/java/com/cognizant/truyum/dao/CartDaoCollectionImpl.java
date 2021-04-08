package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao{
	private static Map<String,Cart> userCarts;
	private static Cart cart;
	public CartDaoCollectionImpl(){
		if(userCarts == null) {
			userCarts = new HashMap<String,Cart>();
		}
		cart = new Cart(new ArrayList<MenuItem>(),0);
	}
	public void addCartItem(String userId,long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if(!userCarts.containsKey(userId)) {
			Cart cart = new Cart(new ArrayList<MenuItem>(),0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}else {
			cart = userCarts.get(userId);
			cart.getMenuItemList().add(menuItem);
		}
	}
	public Cart getAllCartItems(String userId) throws GlobalExceptionHandler{
		if(userCarts.get(userId).getMenuItemList().isEmpty()) {
			throw new GlobalExceptionHandler();
		}
		else {
			cart = userCarts.get(userId);
			float sum = (Float) cart.getMenuItemList().stream().map(i -> i.getPrice()).reduce((float) 0,(c,e) -> c+e);
			cart.setTotal(sum);
			return cart;
		}
	}
	public void removeCartItem(String userId,long menuItemId) {
			cart = userCarts.get(userId);
			List<MenuItem> menuItem = cart.getMenuItemList();
			for(MenuItem m:menuItem) {
				if(m.getId() == menuItemId) {
					menuItem.remove(m);
					break;
				}
			}
	}
}
