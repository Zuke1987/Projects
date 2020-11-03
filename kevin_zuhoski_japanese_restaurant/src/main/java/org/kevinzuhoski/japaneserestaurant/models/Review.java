package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Review entity with ManyToOne relationship to Customer entity
//Table name, column names, constructors, and setters/getters provided


@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	@Column(name="review_id", nullable=false, table="reviews")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reviewId;
	
	@Column(name="review", nullable=false, table="reviews")
	private String review;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="reviews")
	private Customer customer;
	
	public Review() {}

	public Review(Integer reviewId, String review, Customer customer) {
		this.reviewId = reviewId;
		this.review = review;
		this.customer = customer;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
