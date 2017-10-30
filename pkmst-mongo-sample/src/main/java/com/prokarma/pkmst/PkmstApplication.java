package com.prokarma.pkmst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.prokarma.pkmst.model.Car;
import com.prokarma.pkmst.model.CarRepository;

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
	public InitializingBean seedDatabase(CarRepository carRepository) {
		return () -> {
			carRepository.save(new Car(101l,"v101","Honda", "Civic", 1997));
			carRepository.save(new Car(102l,"v102","Honda", "Accord", 2003));
			carRepository.save(new Car(103l,"v103","Ford", "Escort", 1985));
		};
	}

  public static void main(String[] args) {
    LOGGER.debug("Running spring boot application");
    SpringApplication.run(PkmstApplication.class, args);
  }
}

