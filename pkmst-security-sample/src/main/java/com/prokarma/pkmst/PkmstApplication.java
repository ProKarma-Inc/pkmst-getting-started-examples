package com.prokarma.pkmst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.prokarma.pkmst.model.User;
import com.prokarma.pkmst.model.UserRepository;

/**
 * starts the spring boot application
 * @author pkmst
 *
 */
 
@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
@EnableHystrixDashboard
public class PkmstApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkmstApplication.class);
  
  @Bean
	public CommandLineRunner demo(UserRepository urepository) {
		return (args) -> {
			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "user", "USER");
			User user2 = new User("admin", "admin", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}

  public static void main(String[] args) {
    LOGGER.debug("Running spring boot application");
    SpringApplication.run(PkmstApplication.class, args);
  }
}

