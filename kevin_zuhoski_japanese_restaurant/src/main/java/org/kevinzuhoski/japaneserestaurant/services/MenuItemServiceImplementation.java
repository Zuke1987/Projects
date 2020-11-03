package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.MenuItem;
import org.kevinzuhoski.japaneserestaurant.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImplementation implements MenuItemService {
	
	private MenuItemRepository menuItemRepository;
	
	// Injects the MenuItemRepository into the MenuItemServiceImplementation using constructor injection
	
	@Autowired
	public void MenuItemServiceImplementation(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}
	
	// Overrides the findAllMenuItems method from the MenuItemService and returns the findAll() method
	// of the menuItemRepository

	@Override
	public List<MenuItem> findAllMenuItems() {
		return menuItemRepository.findAll();
	}

}
