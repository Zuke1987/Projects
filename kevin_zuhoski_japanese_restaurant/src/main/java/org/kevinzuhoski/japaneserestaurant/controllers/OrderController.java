package org.kevinzuhoski.japaneserestaurant.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.OrderDTO;
import org.kevinzuhoski.japaneserestaurant.services.OrderService;
import org.kevinzuhoski.japaneserestaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller for displaying the order page.  If there is a GET request to the order page, first 
// it checks if the user is logged in by getting the "loggedin" attribute for the current session.
// If the user is logged they will be redirected to the "shoppingcart" page. If they are not logged in
// the login page will be displayed again with the correct proverb in the footer.

@Controller
public class OrderController {
	
	private OrderService orderService;
	private UserService userService;
	
	@Autowired
	public void OrderController(OrderService orderService, UserService userService) {
		this.orderService = orderService;
		this.userService = userService;
	}
	
	@RequestMapping("/order")
	public String order(Model model, HttpSession session) {
		String page = "login";
		boolean userLoggedIn =  session.getAttribute("loggedin")!=null ? (boolean)session.getAttribute("loggedin") : false;

		if(userLoggedIn) {
			return "redirect:shoppingcart";
		}
		
		model.addAttribute("proverb", "Wishing to eat the fugu, but wishing to live too.");
		return page;
	}
	// This is the mapping for the menu-order page and handles when a customer places an order.  First, we get the 
	// customer that is logged in then save the order that was placed for the customer that is currently logged in.  
	//  A message is placed in the response that is returned.  The message depends on whether the order was placed 
	// successfully or not. A ResponseEntity is returned that includes the header, body, and status of the response.  
	
	@RequestMapping(value="/menu-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> menuOrder(@RequestBody List<OrderDTO> order) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		Customer customerLoggedIn = getCustomerLoggedIn();
		
		boolean savedOrder = orderService.saveOrderMenu(order, customerLoggedIn);
		
		if(savedOrder) {
			response.put("success", Boolean.TRUE);
			response.put("message", "Your order has been placed.");
		}else {
			response.put("success", Boolean.FALSE);
			response.put("message", "There was an error submitting your order.");
		}
				
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	// This method gets the user or principal that is currently logged in through the security context.  It the returns the 
	// customer associated with those user credentials.  
	private Customer getCustomerLoggedIn() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		User userFound = userService.getUserByUsername(userName);
		
		return userFound.getCustomer();
	}
}