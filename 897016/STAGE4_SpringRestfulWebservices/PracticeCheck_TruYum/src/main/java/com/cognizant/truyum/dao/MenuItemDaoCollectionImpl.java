package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;


@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (List<MenuItem>) context.getBean("menuItems");
		System.out.println("Menu Items: "+menuItemList);
		
	}
	//overriding the methods
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) 
					|| menuItem.getDateOfLaunch().before(new Date())) && menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId()==menuItem.getId()) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
		MenuItem menuItem2=getMenuItem(menuItem.getId());
		System.out.println(menuItem2);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		return menuItem;
	}

}
