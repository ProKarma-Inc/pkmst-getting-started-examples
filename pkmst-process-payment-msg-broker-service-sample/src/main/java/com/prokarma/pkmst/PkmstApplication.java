package com.prokarma.pkmst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * starts the spring boot application
 * @author pkmst
 *
 */
 
@SpringBootApplication
@EnableJms
//@EnableSwagger2
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class PkmstApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkmstApplication.class);

  public static void main(String[] args) {
    LOGGER.debug("Running spring boot application");
    SpringApplication.run(PkmstApplication.class, args);
  }
}

