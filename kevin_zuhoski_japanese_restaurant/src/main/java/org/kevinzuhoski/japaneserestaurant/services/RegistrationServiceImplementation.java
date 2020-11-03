package org.kevinzuhoski.japaneserestaurant.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kevinzuhoski.japaneserestaurant.exceptions.UserException;
import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.UserDTO;
import org.kevinzuhoski.japaneserestaurant.repositories.CustomerRepository;
import org.kevinzuhoski.japaneserestaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class RegistrationServiceImplementation implements RegistrationService {
	
	private UserRepository userRepository;
	private CustomerRepository customerRepository;
	
	// Injects a UserRepository and a CustomerRepository into the RegistrationServiceImplementation
	// using constructor injection
	
	@Autowired
	public void RegistrationServiceImplementation(UserRepository userRepository, CustomerRepository customerRepository) {
		this.userRepository = userRepository;
		this.customerRepository = customerRepository;
	}

	// Overrides the registerUser method from the RegistrationService
	// Finds a user by login and a customer associated with that user by email.  If the userFound List contains
	// an element (size > 0), a message that the username already exists is added to response and "success" is set to false. If the customer associated
	// with that user is found "success" is set to false, and a message is added to response.  If the username and customer
	// associated with that user does not exist, a user and customer are created, the user's customer field
	// is set to the created user, the user is saved in the database and "success" is set to true
	
	@Override
	public void registerUser(UserDTO userDTO) throws UserException {
		//find user
		List<User> userFound = userRepository.findByLogin(userDTO.getLogin());
		List<Customer> customerFound = customerRepository.findCustomerByEmail(userDTO.getCustomer().getEmail());
				
		if(userFound.size()>0) {
			throw new UserException("This username already exists");
		}else if(customerFound.size()>0){
			throw new UserException("This customer is already in the system");
		}else {
			User userEntity = new User();
			userEntity.setLogin(userDTO.getLogin());
			userEntity.setPassword(userDTO.getPassword());
			
			Customer customerEntity = new Customer();
			customerEntity.setFirstName(userDTO.getCustomer().getFirstName());
			customerEntity.setLastName(userDTO.getCustomer().getLastName());
			customerEntity.setPhoneNumber(userDTO.getCustomer().getPhoneNumber());
			customerEntity.setAddress(userDTO.getCustomer().getAddress());
			customerEntity.setEmail(userDTO.getCustomer().getEmail());
			
			userEntity.setCustomer(customerEntity);
			
			userRepository.save(userEntity);
		}	
	}

}
