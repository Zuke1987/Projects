package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Restaurant entity 
//Table name, column names, constructors, and setters/getters provided
//This entity will not be used in current version of application, but left here for future additions
//to application

@Entity
@Table(name="restaurants")
public class Restaurant {
	
	@Id
	@Column(name="restaurant_id", nullable=false, table="restaurants")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantId;
	
	private String address;
	
	public Restaurant() {
		
	}

	public Restaurant(String address) {
		super();
		this.address = address;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
