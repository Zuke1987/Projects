package org.kevinzuhoski.japaneserestaurant;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// configure method registers the class below as a configuration class of the application

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KevinZuhoskiJapaneseRestaurantApplication.class);
	}

}