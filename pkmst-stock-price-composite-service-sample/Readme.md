This project was scaffolded from PKMST code generator integrated with Swagger UI :

http://swagger-editor.mybluemix.net/

Generate Server : java-pkmst 


The purpose of this service is to demonstrate aggregate service pattern. This service is a composite service that utilizes multiple other services, aggregates data obtained form other services, applies business logic and sends back an aggregated response to the client.
The service works in conjunction with other 2 services:

1)  pkmst-stock-price-service-sample
2)  pkmst-forex-rate-service-sample

## Prerequisites

- Maven 3.x
- Java 1.7
- Git

## Steps to run the application: 

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git


Make sure that the other 2 dependent services are up and running:
cd pkmst-stock-price-service-sample
mvn clean install
mvn spring-boot:run
The above service will run on port 9008


cd ../pkmst-forex-rate-service-sample
mvn clean install
mvn spring-boot:run
The abovce service will run on port 9009

Once the other 2 services are up and running, build and run this composite service :

  $ cd pkmst-forex-rate-service-sample

  $ mvn clean install

  $ mvn spring-boot:run

2. Project will run on http://localhost:8008 

3. Swagger ui available on:
http://localhost:8008/swagger-ui.html


This service will take a stock ticker and a currency in which the stock price will be returned. It make use of the other 2 services to render its response.

You may try out with FB and INR to see the stock price of Facebook in Indian rupees
