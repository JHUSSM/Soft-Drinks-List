package com.qa.soft.drinks.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean // Bean just means that we dont have to keep track of it or worry about it since
			// it becomes the full responsibility of the framework in this case spring
	@Scope("singleton")
	public void fizz() {
		System.out.println("Fizz! Fizz! Fizz!"); // this is a soft drinks project so it makes sense to have a fizzing
													// method
	}

}
