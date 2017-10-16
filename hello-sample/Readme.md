This is the sample Spring boot microservice template project generated from swagger codegen.Using swagger specification you can convert any definition to spring boot microservice.It has the integration with the below services:
 circuit breaker. For testing we have placeholders for junit test class, integration test class, cucumber sample 
feature file(implement according to your needs), gatling load test.

The project has three profiles local, dev, dev-config which can be configured accordingly.
Ways to run the project:
1) Normal spring boot application
2) Using Dockerfile to run in the container

Use manifest.yml file to push the application to the cloud.

HttpLogging filter is provided for logging in the request and response. Can be found inside the com.prokarma.pkmst.logging package.
Spring security is also provided to secure the resources. Please modify according to your needs.

First run:
Import the project in to the eclipse. Run the app as an spring boot application.The project will run on 
1. http://localhost:8008/sayHello
	Now you will see "Hello! welcome World"
2. http://localhost:8008/hello/prok
	Now you will see "Hello! welcome prok"
3. http://localhost:8008/sayHello?name=testuser
	Now you will see "Hello! welcome testuser"