package org.kevinzuhoski.japaneserestaurant.models.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// CustomerDTO class for transferring customer data to separate Customer Entity from customer data transferred. 
// Validation such as @NotEmptty and Regex patterns are provided for form validation of those fields. 

public class CustomerDTO {
	
	private Integer customerId;
	
	@NotEmpty(message = "A first name is required")
	private String firstName;
	
	@NotEmpty(message = "A last name is required")
	private String lastName;
	
	@NotEmpty(message = "An address is required")
	private String address;
	
	@NotEmpty(message = "A phone number is required")
	@Pattern(regexp = "^[1-9]\\d{2}-\\d{3}-\\d{4}", message = "Please enter your phone number in the correct format")
	private String phoneNumber;
	
	@NotEmpty(message = "An email is required")
	@Email(message = "This is not a valid email")
	private String email;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
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
}