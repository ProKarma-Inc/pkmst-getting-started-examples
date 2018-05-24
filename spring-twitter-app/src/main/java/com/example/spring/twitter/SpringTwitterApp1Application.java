package com.example.spring.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTwitterApp1Application {

	// @Inject
	// private Twitter twitter;
	//
	// @Inject
	// private ConnectionRepository connectionRepository;
	//
	// @Bean
	// public Twitter getTwitter() {
	// return this.twitter;
	// }
	//
	// @Bean
	// public ConnectionRepository getConnectionRepository() {
	// return this.connectionRepository;
	// }

	public static void main(String[] args) {
		SpringApplication.run(SpringTwitterApp1Application.class, args);
	}
}
