package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Delivery entity with OneToOne relationship with Order, Customer, and Bill Entity
//Table name, column names, constructors, and setters/getters provided
// This entity will not be used in current version of application, but left here for future additions
// to application

@Entity
@Table(name="deliveries")
public class Delivery {

	@Id
	@Column (name="delivery_id", nullable=false, table="deliveries")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deliveryId;
	
	@OneToOne
	@JoinColumn(name="order_id", referencedColumnName="order_id", nullable=false, table="deliveries")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="deliveries")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="bill_id", referencedColumnName="bill_id", nullable=false, table="deliveries")
	private Bill bill;
	
	public Delivery() {
		
	}

	public Delivery(Order order, Customer customer, Bill bill) {
		super();
		this.order = order;
		this.customer = customer;
		this.bill = bill;
	}

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
}
