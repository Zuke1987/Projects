package org.kevinzuhoski.japaneserestaurant.controllers;

import javax.validation.Valid;

import org.kevinzuhoski.japaneserestaurant.models.Inquiry;
import org.kevinzuhoski.japaneserestaurant.models.dto.InquiryDTO;
import org.kevinzuhoski.japaneserestaurant.services.ContactService;
import org.kevinzuhoski.japaneserestaurant.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	private ContactService contactService;
	
	// Injecting the contactService into the ContactController through constructor injection
	
	@Autowired
	public void ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	// Any GET requests to the contact page will display the contact view with certain attributes 
	// added to the model. The proverb is for displaying that particular proverb in the footer.  The
	//Inquiry data will be binded to the inquiry object on contact form submission.  getAllInquiryReason() is
	// to get the listOfInquiryReasons that will be used in the contact page th:each loop to display all of
	// the inquiry reasons in the dropdown menu.
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("proverb", "Luck exists in the leftovers.");
		model.addAttribute("inquiry", new InquiryDTO());
		model.addAttribute("listOfInquiryReasons", contactService.getAllInquiryReason());
		return "contact";
	}
	// Mapping for POST request of inquiry submission. Validates the data passed in the inquiry form
	// submission.  If there are errors in the data bound to the inquiry object we will get the inquiry reasons to display on the contact
	// page and display the page.  If there are no errors the an inquiry is created in the database
	// from the information submitted in the form and the contact page is displayed again with
	// all inquiry reasons in the dropdown menu.  
	
	
	@RequestMapping(value = "/submitInquiry", method = RequestMethod.POST)
	public String submitInquiry(@Valid @ModelAttribute("inquiry") InquiryDTO inquiry, BindingResult theBindingResult, Model model) {
		
		if(theBindingResult.hasErrors()) {
			model.addAttribute("listOfInquiryReasons", contactService.getAllInquiryReason());
			return "contact";
		} else {
			
			boolean savedContact = contactService.createInquiry(inquiry);
			
			if(savedContact) {
				model.addAttribute("message", "The contact form has been saved.");
			}else {
				model.addAttribute("message", "The contact form has not been saved.");
			}
			
			model.addAttribute("listOfInquiryReasons", contactService.getAllInquiryReason());
			model.addAttribute("success", savedContact);
			
			
			return "contact";
		}
		
		
	}
}

