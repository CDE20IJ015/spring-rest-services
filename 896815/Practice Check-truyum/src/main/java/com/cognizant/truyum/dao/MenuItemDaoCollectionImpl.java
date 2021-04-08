package com.cognizant.truyum.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl(){
		if(menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem m1= new MenuItem(1,"Sandwitch",125,true,new Date(10-10-2020),"Starter",true);
			MenuItem m2= new MenuItem(2,"Burger",125,false,new Date(10-10-2020),"Starter",true);
			MenuItem m3= new MenuItem(3,"French Fries",125,true,new Date(10-10-2020),"Starter",true);
			MenuItem m4= new MenuItem(4,"Pizza",125,true,new Date(10-10-2020),"Starter",true);
			menuItemList.add(m1);
			menuItemList.add(m2);
			menuItemList.add(m3);
			menuItemList.add(m4);
		}
	}
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
