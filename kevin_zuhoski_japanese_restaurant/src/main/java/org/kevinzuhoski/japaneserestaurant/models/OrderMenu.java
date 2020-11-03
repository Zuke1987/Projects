package org.kevinzuhoski.japaneserestaurant.models;

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

// OrderMenu entity with a OneToOne relationship to menuItem and a ManyToOne relationship to Order. 
//Table name, column names, constructors, and setters/getters provided

@Entity
@Table(name="order_menu")
public class OrderMenu {
	@Id
	@Column(name="order_menu_id", nullable=false, table="order_menu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderMenuId;
	
	@OneToOne 
	@JoinColumn(name="menu_item_id", referencedColumnName="menu_item_id", nullable=false, table="order_menu")
	private MenuItem menuItem;
	
	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName="order_id", nullable=false, table="order_menu")
	private Order order;
	
	@Column(name="quantity", nullable=false, table="order_menu")
	private Integer quantity;
	
	public OrderMenu() {}

	public OrderMenu(Integer orderMenuId, MenuItem menuItem, Order order, Integer quantity) {
		super();
		this.orderMenuId = orderMenuId;
		this.menuItem = menuItem;
		this.order = order;
		this.quantity = quantity;
	}

	public Integer getOrderMenuId() {
		return orderMenuId;
	}

	public void setOrderMenuId(Integer orderMenuId) {
		this.orderMenuId = orderMenuId;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
