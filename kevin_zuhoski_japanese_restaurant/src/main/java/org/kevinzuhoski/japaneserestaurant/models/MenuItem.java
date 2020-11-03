package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//MenuItem entity
//Table name, column names, constructors, and setters/getters provided


@Entity
@Table (name="menu_items")
public class MenuItem {
	
	@Id
	@Column(name="menu_item_id", nullable=false, table="menu_items")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuItemId;
	
	@Column(name="item_name", nullable=false, table="menu_items")
	private String itemName;
	
	@Column(name="item_price", nullable=false, table="menu_items")
	private double itemPrice;
	
	@Column(name="item_description", nullable=false, table="menu_items")
	private String itemDescription;
	
	@Column(name="item_type", nullable=false, table="menu_items")
	private Integer itemType;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String itemName, double itemPrice, String itemDescription, Integer itemType) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
	}

	public int getMenuItemId() {
		return menuItemId;
	}
	
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	
	
	
}
