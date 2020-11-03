package org.kevinzuhoski.japaneserestaurant.repositories;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// UserRepository with method to find user by login

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByLogin(String login);

}
