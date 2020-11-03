package org.kevinzuhoski.japaneserestaurant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//JUnit test to test getting a user by their username.  An actual username is passed in and our expected output
// is asserted to be not null since that username exists.  

@SpringBootTest
public class UserTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void userByUsername() {
		User user = userService.getUserByUsername("Zuke1987-");
		
		assertThat(user).isNotNull();
	}
 }
