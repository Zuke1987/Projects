package org.kevinzuhoski.japaneserestaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for displaying the about page.  Any GET requests to "/about" will go to the about page
// and the proverb will be added to the model to be shown in the footer in the about page view.  

@Controller
public class AboutController {

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("proverb", "Even sea bream is not delicious when eaten in loneliness.");
		return "about";
	}
}
