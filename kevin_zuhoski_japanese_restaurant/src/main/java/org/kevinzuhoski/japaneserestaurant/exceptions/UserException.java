package org.kevinzuhoski.japaneserestaurant.exceptions;

// A customer exception UserException with a constructor that takes in a String when creating an instance of the exception.

public class UserException extends Exception {
	public UserException(String message) {
		super(message);
	}
}
