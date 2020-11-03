package org.kevinzuhoski.japaneserestaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for displaying the menu page.  Any GET requests to "/menu" will go to the menu page
//and the proverb will be added to the model to be shown in the footer in the menu page view.  

@Controller
public class MenuController {

	@RequestMapping("/menu")
	public String menu(Model model) {
		model.addAttribute("proverb", "It is the man who drinks the first bottle of sake, then the second bottle drinks the first, and finally it is the sake that drinks the man.");
		return "menu";
	}
}
