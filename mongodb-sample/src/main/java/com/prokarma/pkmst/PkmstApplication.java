package com.prokarma.pkmst;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.util.StreamUtils;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.prokarma.pkmst.model.Customer;
import com.prokarma.pkmst.model.CustomerRepository;

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


	@Bean
	public InitializingBean seedDatabase(CustomerRepository repository) {
		return () -> {
			repository.deleteAll();
			repository.save(new Customer(101l,"John Berg", "Omaha"));
			repository.save(new Customer(102l,"Josh Tyson", "Lincoln"));
			repository.save(new Customer(103l,"Rim Tylor", "Omaha"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PkmstApplication.class, args);
	}


}

