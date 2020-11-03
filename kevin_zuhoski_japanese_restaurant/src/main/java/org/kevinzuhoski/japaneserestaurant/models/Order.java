package org.kevinzuhoski.japaneserestaurant.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Order entity with OneToOne relationship to Customer and Restaurant, and a OneToMany relationship to menuItem
//Table name, column names, constructors, and setters/getters provided


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="order_id", nullable=false, table="orders")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name="order_date", nullable=false, table="orders")
	private Date orderDate;
	
//	@Column(name="order_type", nullable=false, table="orders")
//	private String orderType;
	
	@OneToOne 
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="orders")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="restaurant_id", referencedColumnName="restaurant_id", nullable=false, table="orders")
	private Restaurant restaurant;
	
//	@OneToMany(targetEntity = MenuItem.class)
//	private List<MenuItem> menuItems;
		
	public Order() {
		
	}
	
	public Order(Date orderDate, Customer customer, Restaurant restaurant) {
		super();
		this.orderDate = orderDate;
//		this.orderType = orderType;
		this.customer= customer;
		this.restaurant = restaurant;
	}

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
//	public String getOrderType() {
//		return orderType;
//	}
//	
//	public void setOrderType(String orderType) {
//		this.orderType = orderType;
//	}

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

//	public OrderMenu getOrderMenu() {
//		return orderMenu;
//	}
//
//	public void setOrderMenu(OrderMenu orderMenu) {
//		this.orderMenu = orderMenu;
//	}
	
	
	
}

