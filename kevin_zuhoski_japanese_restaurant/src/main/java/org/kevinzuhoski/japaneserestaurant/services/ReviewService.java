package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Review;

// ReviewService with CRUD methods for Review objects.  

public interface ReviewService {
	public List<Review> getAllReview();
	public List<Review> getAllReviewByCustomer(Customer customer);
	public Review getReviewById(Integer id);
	public Review saveReview(Review review);
	public void deleteReview(Integer id);
}
