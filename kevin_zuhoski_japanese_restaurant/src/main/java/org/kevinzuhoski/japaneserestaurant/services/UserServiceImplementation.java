package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
	
	private UserRepository userRepository;
	
	// Injects a userRepository into a userServiceImplementation using constructor injection
	
	@Autowired
	public void UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Overridden method from UserService
	// Finds a user by their login which is their username.  If the user is found that user is returned
	
	@Override
	public User getUserByUsername(String username) {
		List<User> userFound = userRepository.findByLogin(username);
		
		if(userFound.size() > 0) {
			return userFound.get(0);
		}else {
			return null;
		}
		
	}

}
