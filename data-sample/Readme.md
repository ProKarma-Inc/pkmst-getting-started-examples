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

 Running the application:
1) Import the project in to the eclipse. Run the app as an spring boot application.The project will run on http://localhost:8008   OR
2) Clone the repository onto your local and get into the folder with the command cd pkmst-security-sample 
             a) Run with the command mvn clean install , for including all the dependencies
             b) After you see that the build is successfull , then run the command mvn spring-boot:run for running your application at http://localhost:8008
             
3) sSwagger ui available on:
http://localhost:8008/swagger-ui.html
