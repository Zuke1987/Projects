package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.sun.istack.NotNull;

//User entity with OneToOne relationship with Customer entity
//Table name, column names, constructors, and setters/getters provided


@Entity 
@Table (name="users")
public class User {
	
	@Id
	@Column(name="user_Id", nullable=false, table="users")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL) // targetEntity=Customer.class
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="users")
	private Customer customer;
	
	
	@Column(name="login", nullable=false, table="users")
	private String login;
	
	@Column(name="password", nullable=false, table="users")
	private String password;
	
	public User() {
		
	}
	
	public User(Customer customer, String login, String password) {
		super();
		this.customer = customer;
		this.login = login;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
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
	
}

