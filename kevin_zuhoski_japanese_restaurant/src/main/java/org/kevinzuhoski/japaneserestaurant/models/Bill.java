package org.kevinzuhoski.japaneserestaurant.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Bill entity with OneToOne relationship with Order entity
// Table name, column names, constructors, and setters/getters provided

@Entity
@Table(name="bills")
public class Bill {
	
	@Id
	@Column(name="bill_id", nullable=false, table="bills")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer billId;
	
	@OneToOne
	@JoinColumn(name="order_id", referencedColumnName="order_id", nullable=false, table="bills")
	private Order order;
	
	@Column(name="bill_total", nullable=false, table="bills")
	private double billTotal;
	
	@Column(name="discount", table="bills") // nullable=true is the default and discount can be null since not every 
	// bill has a discount
	private double discount;
	
	@Column(name="bill_date", nullable=false, table="bills")
	private LocalDate billDate;
	
	public Bill() {
		
	}

	public Bill(Order order, double billTotal, double discount, LocalDate billDate) {
		super();
		this.order = order;
		this.billTotal = billTotal;
		this.discount = discount;
		this.billDate = billDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	
	
	
}
