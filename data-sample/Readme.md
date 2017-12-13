Microservices with Spring Boot and JPA repository

This is the sample Spring boot microservice template project generated from swagger codegen.Using swagger specification you can convert any definition to spring boot microservice.It has the integration with the below services:
 circuit breaker. For testing we have placeholders for junit test class, integration test class, cucumber sample 
feature file(implement according to your needs), gatling load test.

Prerequisites

- Maven 3.x
- Java 1.7
- Git

Installation

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git

Now from your environment and run the application with the following commands

$ cd data-sample

$ mvn clean install

$ mvn spring-boot:run

2.  Import the project in to the eclipse.Find for the name pkmst-microservice in the project explorer. Run the app as a spring boot application. The project will run on http://localhost:8008  

3) Swagger ui for the running application is available on:
http://localhost:8008/swagger-ui.html

You should be adding this to your pom , if using JPA in your project:

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
