package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.MenuItem;

// This MenuItemService interface contains a method to find all of the menu items

public interface MenuItemService {
	public List<MenuItem> findAllMenuItems();
}
