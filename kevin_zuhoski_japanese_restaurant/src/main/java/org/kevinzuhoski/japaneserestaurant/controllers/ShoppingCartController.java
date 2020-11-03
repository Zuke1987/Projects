package org.kevinzuhoski.japaneserestaurant.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.kevinzuhoski.japaneserestaurant.models.MenuItem;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.OrderDTO;
import org.kevinzuhoski.japaneserestaurant.services.MenuItemService;
import org.kevinzuhoski.japaneserestaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController {
	
	private UserService userService;
	private MenuItemService menuItemService;
	
	// Injecting of a UserService and a MenuItemService into the ShoppingCartController through
	// constructor injection
	
	@Autowired
	public void ShoppingCartController(UserService userService, MenuItemService menuItemService) {
		this.userService = userService;
		this.menuItemService = menuItemService;
	}
	
	@RequestMapping("/shoppingcart")
	public String home(Model model, HttpSession session) {
		String nameOfUserLoggedIn = getNameOfUserLoggedIn();
		List<MenuItem> allMenuItems = menuItemService.findAllMenuItems();
		
		model.addAttribute("proverb", "One Japanese plum a day is an escape from that one day struggle.");
		model.addAttribute("menuEntrees", getMenuItemByType(allMenuItems, 1));
		model.addAttribute("menuBeverages", getMenuItemByType(allMenuItems, 2));
		
		session.setAttribute("loggedin", true);
		session.setAttribute("nameOfUserLoggedIn", nameOfUserLoggedIn);
		
		return "shoppingcart";
	}
	
	private List<MenuItem> getMenuItemByType(List<MenuItem> allMenuItems, Integer type){
		return allMenuItems.stream().filter(item -> item.getItemType()==type).collect(Collectors.toList());
	}
	
	private String getNameOfUserLoggedIn() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		User userFound = userService.getUserByUsername(userName);
		
		return userFound.getCustomer().getFirstName() + " " + userFound.getCustomer().getLastName();
	}
}
