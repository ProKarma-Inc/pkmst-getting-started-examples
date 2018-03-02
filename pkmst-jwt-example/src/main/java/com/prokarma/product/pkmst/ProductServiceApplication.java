package com.prokarma.product.pkmst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.prokarma.product.pkmst.config.PkmstProperties;


@SpringBootApplication
/*
 * lives in spring-cloud-commons and picks the implementation on the classpath. 
 */
//@EnableDiscoveryClient

/*
 * lives in spring-cloud-netflix and only works for eureka. 
 * If eureka is on your classpath, they are effectively the same.
 */
@EnableEurekaClient
@EnableConfigurationProperties({ PkmstProperties.class })
@EnableCircuitBreaker
@EnableHystrixDashboard
/*
 * Enable for Spring Cloud Sleuth Stream Zipkin Collector
 */
//@EnableZipkinStreamServer
public class ProductServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(ProductServiceApplication.class);
	public static void main(String[] args) {
		log.debug("Running spring boot application");
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
}
