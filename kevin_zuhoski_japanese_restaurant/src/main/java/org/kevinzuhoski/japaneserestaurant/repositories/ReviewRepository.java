package org.kevinzuhoski.japaneserestaurant.repositories;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ReviewRepository

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	public List<Review> findByCustomer(Customer customer);
	public Review findByReviewId(Integer reviewId);
	
}
