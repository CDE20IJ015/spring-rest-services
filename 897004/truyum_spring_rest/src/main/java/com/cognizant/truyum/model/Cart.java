package com.cognizant.truyum.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public Cart(String userId, List<MenuItem> menuItems) {
		super();
		this.userId = userId;
		this.menuItems = menuItems;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String userId;
	private List<MenuItem> menuItems;
}
