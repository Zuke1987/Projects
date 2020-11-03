package org.kevinzuhoski.japaneserestaurant.models.dto;

//ReviewDTO class for transferring Review data to separate Review Entity from Review data transferred. 


public class ReviewDTO {
	private Integer reviewId;
	
	private String review;
	
	private CustomerDTO customer;

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
