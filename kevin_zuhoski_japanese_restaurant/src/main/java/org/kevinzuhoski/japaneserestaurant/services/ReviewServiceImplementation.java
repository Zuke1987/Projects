package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Review;
import org.kevinzuhoski.japaneserestaurant.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Implementation of ReviewService with overidden methods.   

@Service
public class ReviewServiceImplementation implements ReviewService {
	
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImplementation(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReview() {
		return reviewRepository.findAll();
	}

	@Override
	public List<Review> getAllReviewByCustomer(Customer customer) {
		return reviewRepository.findByCustomer(customer);
	}

	@Override
	public Review saveReview(Review review) {
		return reviewRepository.save(review);		
	}

	@Override
	public Review getReviewById(Integer id) {
		return reviewRepository.findByReviewId(id);
	}

	@Override
	public void deleteReview(Integer id) {
		reviewRepository.deleteById(id);		
	}

}
