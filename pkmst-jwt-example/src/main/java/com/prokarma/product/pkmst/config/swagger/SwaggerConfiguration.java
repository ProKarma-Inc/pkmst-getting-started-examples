package com.prokarma.product.pkmst.config.swagger;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prokarma.product.pkmst.config.PkmstProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final String DEFAULT_INCLUDE_PATTERN = "/pkmst/.*";
	 @Bean
	    public Docket swaggerSpringfoxDocket(PkmstProperties pkmstProperties) {
	        System.out.println("Starting Swagger");
	        StopWatch watch = new StopWatch();
	        watch.start();
	        System.out.println(pkmstProperties.getSwagger().getContactName());
	        Contact contact = new Contact(
	        		pkmstProperties.getSwagger().getContactName(),
	        		pkmstProperties.getSwagger().getContactUrl(),
	        		pkmstProperties.getSwagger().getContactEmail());

	        ApiInfo apiInfo = new ApiInfo(
	        		pkmstProperties.getSwagger().getTitle(),
	        		pkmstProperties.getSwagger().getDescription(),
	        		pkmstProperties.getSwagger().getVersion(),
	        		pkmstProperties.getSwagger().getTermsOfServiceUrl(),
	            contact,
	            pkmstProperties.getSwagger().getLicense(),
	            pkmstProperties.getSwagger().getLicenseUrl());

	        Docket docket = new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo)
	            .forCodeGeneration(true)
	            .genericModelSubstitutes(ResponseEntity.class)
	            .ignoredParameterTypes(java.sql.Date.class)
	            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.prokarma.jwt.pkmst"))
	           // .paths(regex(DEFAULT_INCLUDE_PATTERN))
	            .paths(PathSelectors.any())
	            .build();
	        watch.stop();
	        System.out.println("Started Swagger in {} ms"+ watch.getTotalTimeMillis());
	        return docket;
	    }
	
}
