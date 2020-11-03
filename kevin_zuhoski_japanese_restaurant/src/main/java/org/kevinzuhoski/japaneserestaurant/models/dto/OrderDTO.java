package org.kevinzuhoski.japaneserestaurant.models.dto;

import javax.persistence.Column;

//OrderDTO class for transferring Order data to separate Order Entity from Order data transferred. 


public class OrderDTO {
	private Integer menuItemId;
	
	private String itemName;
	
	private double itemPrice;
	
	private String itemDescription;
	
	private Integer itemType;
	
	private Integer quantity;
	
	public OrderDTO() {
		
	}

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
