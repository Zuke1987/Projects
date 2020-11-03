package org.kevinzuhoski.japaneserestaurant.models;

//import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;

//Customer entity
//Table name, column names, constructors, and setters/getters provided

@Entity 
@Table (name="customers")
public class Customer {
	
	@Id
	@Column (name="customer_id", nullable=false, table="customers")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(name="first_name", nullable=false, table="customers")
	private String firstName;
	
	@Column(name="last_name", nullable=false, table="customers")
	private String lastName;
	
	@Column(name="address", nullable=false, table="customers")
	private String address;
	
	@Column(name="phone_number", nullable=false, table="customers")
	private String phoneNumber;
	
	@Column(name="email", nullable=false, table="customers")
	private String email;
	

	public Customer() {
		
	}
	
	
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email; 
	}

	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}

