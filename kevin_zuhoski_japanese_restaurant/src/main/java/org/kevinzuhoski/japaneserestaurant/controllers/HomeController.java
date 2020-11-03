package org.kevinzuhoski.japaneserestaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for displaying the home page.  Any GET requests to "/" will go to the home page
//and the proverb will be added to the model to be shown in the footer in the home page view.  

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("proverb", "Eat it raw before all else, then grill it, and boil it last of all.");
		
		return "home";
	}
}
