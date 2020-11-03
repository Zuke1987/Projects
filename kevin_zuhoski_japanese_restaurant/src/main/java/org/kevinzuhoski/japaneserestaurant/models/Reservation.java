package org.kevinzuhoski.japaneserestaurant.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Reservation entity with ManyToOne relationship to Customer entity and OneToOne relationship with Restaurant Entity
//Table name, column names, constructors, and setters/getters provided
//This entity will not be used in current version of application, but left here for future additions
//to application

@Entity
@Table(name="reservations")
public class Reservation {

	@Id
	@Column(name="reservation_id", nullable=false, table="reservations")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reservationId;
	
	@Column(name="reservation_date_and_time", nullable=false, table="reservations")
	private LocalDate reservationDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="reservations")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="restaurant_id", referencedColumnName="restaurant_id", nullable=false, table="reservations")
	private Restaurant restaurant;
	
	public Reservation() {
		
	}

	public Reservation(LocalDate reservationDate, Customer customer, Restaurant restaurant) {
		super();
		this.reservationDate = reservationDate;
		this.customer = customer;
		this.restaurant = restaurant;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
