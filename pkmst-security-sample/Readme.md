## Microservices with PKMST with Security

This is the sample PKMST microservice template project generated from swagger codegen. Using swagger specification you can convert any definition to spring boot microservice.
This project takes in the username and password and authorizes and authenticates them. Users logged in can only edit or delete their information 

## Prerequisites
- Maven 3.x

- Java 1.7

- Git

## Installation

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git
Now from your environment and run the application with the following commands

$ cd pkmst-security-sample

$ mvn clean install

$ mvn spring-boot:run

2.  Import the project in to the eclipse. Run the app as a spring boot application. The project will run on http://localhost:8008  

3) Swagger ui available on:
http://localhost:8008/swagger-ui.html

### To access the protected resources first get the access token as below:

POST: http://localhost:8008/oauth/token?grant_type=password&username=admin&password=admin

Header:
Basic Auth:

username: my-trusted-client  

password: secret

Response: {
  "access_token": "811a47c2-0bea-459e-a172-fa9adb62381c",
  "token_type": "bearer",
  "refresh_token": "e06f8a81-de1e-4938-80d9-feabb7436f90",
  "expires_in": 120,
  "scope": "read write trust"
}

### Access the get resources as below:
GET: http://localhost:8008/user/login?username=user&password=password&access_token=811a47c2-0bea-459e-a172-fa9adb62381c

Response: User logged in successfully into the system
