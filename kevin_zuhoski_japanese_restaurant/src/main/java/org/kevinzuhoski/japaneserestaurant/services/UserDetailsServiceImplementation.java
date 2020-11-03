package org.kevinzuhoski.japaneserestaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.User;
import org.kevinzuhoski.japaneserestaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	
	private UserRepository userRepository;
	
	// Injects a UserRepository into UserDetailsServiceImplementation using constructor injection.  
	
	@Autowired
	public void UserDetailsServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Loads a user by their username.  
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> userEntity = userRepository.findByLogin(username);
		
		if(userEntity.size()>0) {
			// The user was found
			User userFound = userEntity.get(0);
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
			
			grantList.add(grantedAuthority);
			
			UserDetails user = (UserDetails) new org.springframework.security.core.userdetails.User(username, userFound.getPassword(),
					grantList);
			
			return user;
		}else {
			System.out.println("The user does not exist");
			throw new UsernameNotFoundException("The user does not exist");
		}
		
	}

}
