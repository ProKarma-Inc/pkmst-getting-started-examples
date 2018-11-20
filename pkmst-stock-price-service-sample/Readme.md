This project was scaffolded from PKMST code generator integrated with Swagger UI :

http://swagger-editor.mybluemix.net/

Generate Server : java-pkmst 


This service accepts a stock ticker and responds back with details of the stock.

## Prerequisites

- Maven 3.x
- Java 1.7
- Git

## Steps to run the application: 

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git

  Now from your environment and run the application with the following commands

  $ cd pkmst-stock-price-service-sample

  $ mvn clean install

  $ mvn spring-boot:run

2. Project will run on http://localhost:9008 

3. Swagger ui available on:
http://localhost:9008/swagger-ui.html

Try out with some example stock tickers like : UNP, MSFT, AMZN, NFLX, INFY, AAPL