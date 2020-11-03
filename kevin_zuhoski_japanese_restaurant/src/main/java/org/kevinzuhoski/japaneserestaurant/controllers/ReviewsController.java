package org.kevinzuhoski.japaneserestaurant.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Review;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.ReviewDTO;
import org.kevinzuhoski.japaneserestaurant.services.ReviewService;
import org.kevinzuhoski.japaneserestaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Controller for displaying the reviews page.  Any GET requests to "/reviews" will go to the reviews page
//and the proverb will be added to the model to be shown in the footer in the reviews page view.  

@Controller
public class ReviewsController {
	
	private ReviewService reviewService;
	private UserService userService;
	
	@Autowired
	public ReviewsController(ReviewService reviewService, UserService userService) {
		this.reviewService = reviewService;
		this.userService = userService;
	}
	
	@RequestMapping("/reviews")
	public String reviews(Model model, HttpSession session) {
		boolean userLoggedIn =  session.getAttribute("loggedin")!=null ? (boolean)session.getAttribute("loggedin") : false;
		
		List<Review> allReviews = reviewService.getAllReview();

		if(userLoggedIn) {
			Customer customerLoggedIn = getCustomerLoggedIn();
			List<Review> reviews =  reviewService.getAllReviewByCustomer(customerLoggedIn);
			
			model.addAttribute("allReviewsByUserLoggedIn", reviews);
			model.addAttribute("loggedin", true);
		}else {
			model.addAttribute("loggedin", false);
		}	
		
		model.addAttribute("review", new ReviewDTO());
		model.addAttribute("allReviews", allReviews);
		model.addAttribute("proverb", "A samurai, even when he has not eaten, uses his toothpick.");
		
		return "reviews";
	}
	
	//Maps the request for the reviews-view which will display the reviews for a specific user / customer that 
	// is currently logged in.  
	
	@RequestMapping("/reviews-view")
	public String reviewsById(@RequestParam("myreviews") Integer id, Model model, HttpSession session) {
		System.out.println("ID REVIEW:"+id);
		
		
		boolean userLoggedIn =  session.getAttribute("loggedin")!=null ? (boolean)session.getAttribute("loggedin") : false;
		
		List<Review> allReviews = reviewService.getAllReview();

		if(userLoggedIn) {
			Customer customerLoggedIn = getCustomerLoggedIn();
			List<Review> reviews =  reviewService.getAllReviewByCustomer(customerLoggedIn);
			
			model.addAttribute("allReviewsByUserLoggedIn", reviews);
			model.addAttribute("loggedin", true);
		}else {
			model.addAttribute("loggedin", false);
		}
		
		Review theReview = reviewService.getReviewById(id);
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setReviewId(theReview.getReviewId());
		reviewDTO.setReview(theReview.getReview());
		
		
		model.addAttribute("review", reviewDTO);
		model.addAttribute("allReviews", allReviews);
		model.addAttribute("proverb", "A samurai, even when he has not eaten, uses his toothpick.");
			
		
		return "reviews";
	}
	// Maps the request for the create-review and delete-review.  
	
	@RequestMapping(value="/create-review", method = RequestMethod.POST)
	public String createReview(@ModelAttribute("review") ReviewDTO reviewDTO){	
		Customer customerLoggedIn = getCustomerLoggedIn();
		
		Review review = new Review();
		review.setReview(reviewDTO.getReview());
		review.setCustomer(customerLoggedIn);
		
		if(reviewDTO.getReviewId()!=null) {
			review.setReviewId(reviewDTO.getReviewId());
		}
		
		reviewService.saveReview(review);
				
		return "redirect:reviews?myreviews";
	}
	
	@RequestMapping("/delete-review")
	public String deleteReview(@RequestParam("id") Integer id){	
		
		reviewService.deleteReview(id);
		
		return "redirect:reviews?myreviews";
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
