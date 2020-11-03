package org.kevinzuhoski.japaneserestaurant.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.kevinzuhoski.japaneserestaurant.exceptions.UserException;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.UserDTO;
import org.kevinzuhoski.japaneserestaurant.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	private RegistrationService registrationService;
	
	// Injecting the registrationService into the RegistrationController through constructor injection.
	
	@Autowired
	public void RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	// Maps any GET requests to "/registration." If there are any GET requests to the registration page
	// the correct proverb will be added to the model to be shown in the footer, and a UserDTO object
	// is added to the model to hold the data that will be passed when the registration form is submitted.
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("proverb", "You can’t eat the mochi in the picture.");
		model.addAttribute("user", new UserDTO());
		return "registration";
	}
	// Mapping for the POST request for when the registration form is submitted.  If there are errors
	// with validation the registration page will be shown again.  If not we check if the the password entered
	// in the password field matches the password in the confirm password field.  If they do not match
	// we set the "success" attribute to false, and show the registration page with the appropriate errors.  
	// If they do match the password is encrypted and the user password is set to the encrypted password.
	//  The user is then registered and if it's successful the appropriate message is displayed.  If not "success" is set to false
	// and the user is returned to the registration page.
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult theBindingResult, Model model) {
		
		if(theBindingResult.hasErrors()) {
			
			return "registration";
		}else {
			
			try {
				if(!user.getPassword().equals(user.getConfirmPassword())) {
					model.addAttribute("success", false);
					model.addAttribute("message", "Your passwords do not match");
				}else {
					BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
					String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
					
					user.setPassword(encryptedPassword);
								
					registrationService.registerUser(user);
					
					model.addAttribute("success", true);
					model.addAttribute("message", "You have been successfully registered");
				}
			} catch (UserException exception) {
				model.addAttribute("success", false);
				model.addAttribute("message", exception.getMessage());
			}
			
			return "registration";
		}
	}
}