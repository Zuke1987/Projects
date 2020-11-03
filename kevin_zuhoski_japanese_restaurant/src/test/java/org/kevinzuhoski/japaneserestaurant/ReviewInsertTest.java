package org.kevinzuhoski.japaneserestaurant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Review;
import org.kevinzuhoski.japaneserestaurant.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//JUnit Test
// This test creates a review and a customer for that specific review.  The review is then saved to the DB
// we assert that the savedReview.isNotNull() to be true since it should have been saved.  

@SpringBootTest
public class ReviewInsertTest {
	
	// A ReviewService is injected with the Autowire notation.
	
	@Autowired
	private ReviewService reviewService;
	
	@Test
	public void savedReview() {
		Review review = new Review();
		review.setReviewId(0);
		review.setReview("This is a test to see if reviews are saved as expected.");
		
		Customer customer = new Customer();
		customer.setFirstName("Bob");
		customer.setLastName("Jones");
		customer.setPhoneNumber("222-222-2222");
		customer.setEmail("bjones@yahoo.com");
		customer.setAddress("222 Pond Avenue");
		customer.setCustomerId(17);
		
		review.setCustomer(customer);
		
		Review savedReview = reviewService.saveReview(review);
		
		assertThat(savedReview).isNotNull();
	}
	
	
}
