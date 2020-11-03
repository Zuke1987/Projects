package org.kevinzuhoski.japaneserestaurant.repositories;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CustomerRepository with two methods to find a customer by their email, and by their first and last name

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public List<Customer> findCustomerByEmail(String email);
	public List<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
}
