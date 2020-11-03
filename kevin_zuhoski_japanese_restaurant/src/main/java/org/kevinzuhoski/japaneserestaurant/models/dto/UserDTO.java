package org.kevinzuhoski.japaneserestaurant.models.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//UserDTO class for transferring User data to separate User Entity from User data transferred. 
// @NotNull and regex patterns provided for form validation purposes. 


public class UserDTO {
	private Integer userId;
	
	@Valid
	private CustomerDTO customer;
	
	@NotNull(message = "You must enter a login")
	@Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$", message="Please create a login between 3 and 15 characters that contains letters, numbers, hyphens, or underscores")
	private String login;
	
	@NotNull(message = "Please create a password")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:;=?@#|'<>.-^*()%!])(?=\\S+$).{8,32}$", message = "Please enter a password between 8 and 32 characters that contains letters, numbers, and special characters")
	private String password;
	
	@NotNull(message = "You must confirm your password")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:;=?@#|'<>.-^*()%!])(?=\\S+$).{8,32}$",  message = "Please enter a password between 8 and 32 characters that contains letters, numbers, and special characters")
	private String confirmPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
