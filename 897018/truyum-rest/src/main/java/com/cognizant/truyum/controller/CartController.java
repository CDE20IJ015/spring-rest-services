package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId,@PathVariable long menuItemId) {
		
		cartService.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/{userId}")
	public Cart getAllCartItem(@PathVariable String userId) throws CartEmptyException {
		return cartService.getAllCartItem(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable String userId,@PathVariable long menuItemId) {
		cartService.removeCartItem(userId, menuItemId);
	}
}
