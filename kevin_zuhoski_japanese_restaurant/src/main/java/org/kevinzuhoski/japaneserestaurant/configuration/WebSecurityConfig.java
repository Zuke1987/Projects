package org.kevinzuhoski.japaneserestaurant.configuration;

import org.kevinzuhoski.japaneserestaurant.services.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	String[] resources = new String[] {
			"/images/**","/scripts/**", "/styles/**"
	};
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	UserDetailsServiceImplementation userDetailsService;
	
	// BCrypt bean defined, to be used for password encryption
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		System.out.println("passwordEncoder");
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
	
	// Injecting the userDetails service
	
	@Autowired
	public void WebSecurityConfig(UserDetailsServiceImplementation userDetailsService) {
		System.out.println("userDetailsService");
		this.userDetailsService = userDetailsService;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
		System.out.println("configureGlobal");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	//  This method is configuring the HttpSecurity or security for requests.  Requests are permitted to
	// all static files like .html, .css, and .js files.  Any requests are permitted that match what's inside
	// .antMatchers().  All requests are permitted to the login page and different url's are given if the 
	// request is successful or if there is an error. The login form authentication requires two parameters 
	// the username and password.  All logout requests are permitted and a url is given for when a logout is successful. 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers(resources).permitAll()
			.antMatchers("/", "/menu", "/about", "/contact", 
					"/reviews","/registration","/registerUser", "/submitInquiry").permitAll()
			.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/order").permitAll()
				.defaultSuccessUrl("/shoppingcart")
				.failureUrl("/order?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/order?logout");
				
	}
	
}
