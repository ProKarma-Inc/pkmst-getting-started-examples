package com.prokarma.pkmst;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.prokarma.pkmst.model.Student;
import com.prokarma.pkmst.model.StudentRepository;

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
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Arrays.asList("Phil", "Josh").forEach(name -> studentRepository
					.save(new Student(name, (name + "@email.com").toLowerCase())));
			studentRepository.findAll().forEach(System.out::println);
		};
	}
  
  public static void main(String[] args) {
    LOGGER.debug("Running spring boot application");
    SpringApplication.run(PkmstApplication.class, args);
  }
}

