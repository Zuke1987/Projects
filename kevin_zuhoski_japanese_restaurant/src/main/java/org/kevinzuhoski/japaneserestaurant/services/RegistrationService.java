package org.kevinzuhoski.japaneserestaurant.services;

import java.util.Map;

import org.kevinzuhoski.japaneserestaurant.exceptions.UserException;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.models.dto.UserDTO;

/**
 * This interface contains methods for CRUD functions related to registration.
 * @author kevinzuhoski
 *
 */
public interface RegistrationService {
	
	/**
	 * This method checks if a user exists or not and if the user does not exist it will register the user.
	 * @param user
	 */
	public void registerUser(UserDTO user) throws UserException;
}
