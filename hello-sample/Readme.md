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

$ cd hello-sample

$ mvn clean install

$ mvn spring-boot:run

2)  Import the project in to the eclipse. Run the app as an spring boot application.The project will run on  http://localhost:8008. The options to be tried in the localhost are:

        a) http://localhost:8008/sayHello
	               Now you will see "Hello! welcome World"
        b) http://localhost:8008/hello/prok
	              Now you will see "Hello! welcome prok"
        c) http://localhost:8008/sayHello?name=testuser
	             Now you will see "Hello! welcome testuser"

3) Swagger ui available on:
http://localhost:8008/swagger-ui.html

