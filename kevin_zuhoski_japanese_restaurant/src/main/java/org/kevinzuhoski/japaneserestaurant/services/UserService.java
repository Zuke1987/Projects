package org.kevinzuhoski.japaneserestaurant.services;

import org.kevinzuhoski.japaneserestaurant.models.User;

// UserService interface that contains a method to get a user by using their username

public interface UserService {
	public User getUserByUsername(String username);
}
