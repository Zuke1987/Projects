package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Payment entity with OneToOne relationship with Customer, Order, and Bill entity
//Table name, column names, constructors, and setters/getters provided
//This entity will not be used in current version of application, but left here for future additions
//to application


@Entity
@Table(name="payments")
public class Payment {

	@Id
	@Column(name="user_Id", nullable=false, table="payments")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId;
	
	@Column(name="paymentType", nullable=false, table="payments")
	private String paymentType;
	
	@OneToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="payments")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="order_id", referencedColumnName="order_id", nullable=false, table="payments")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="bill_id", referencedColumnName="bill_id", nullable=false, table="payments")
	private Bill bill;
	
	public Payment() {
		
	}

	public Payment(String paymentType, Customer customer, Order order, Bill bill) {
		super();
		this.paymentType = paymentType;
		this.customer = customer;
		this.order = order;
		this.bill = bill;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
	
	
}
