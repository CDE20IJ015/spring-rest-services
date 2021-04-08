package com.cognizant.truyum.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	private static List<MenuItem> menuItemList = context.getBean("menuItems",ArrayList.class);
	
	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemList;
		
	}
	 public List<MenuItem> getMenuItemListCustomer(){ 
		List<MenuItem> menuItemListCust = new ArrayList<>();
		menuItemListCust = menuItemList.stream()
										.filter(a -> a.getDateOfLaunch().before(new Date()) && a.isActive())
										.collect(Collectors.toList());
	  	return menuItemListCust;
	  
	 } 
	 public void modifyMenuItem(MenuItem menuitem) {
		for(MenuItem mi:menuItemList) {
			if(mi.getId() == menuitem.getId()) {
				mi.setName(menuitem.getName());
				mi.setPrice(menuitem.getPrice());
				mi.setActive(menuitem.isActive());
				mi.setDateOfLaunch(menuitem.getDateOfLaunch());
				mi.setCategory(menuitem.getCategory());
				mi.setFreeDelivery(menuitem.isFreeDelivery());
				break;
			}
		}
	 } 
	 public MenuItem getMenuItem(long menuItemId) { 
		 MenuItem menuItem = menuItemList.stream().filter(i -> i.getId() == menuItemId).findAny().orElse(null);
		 return menuItem;
	 }
}
