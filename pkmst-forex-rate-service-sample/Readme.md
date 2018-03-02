This project was scaffolded from PKMST code generator integrated with Swagger UI :

http://swagger-editor.mybluemix.net/

Generate Server : java-pkmst 


This service accepts a Foreign Exchange ticker and responds back with Foreign Exchange Rates for the currency pairs represented by the ticker.

## Prerequisites

- Maven 3.x
- Java 1.7
- Git

## Steps to run the application: 

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git

  Now from your environment and run the application with the following commands

  $ cd pkmst-forex-rate-service-sample

  $ mvn clean install

  $ mvn spring-boot:run

2. Project will run on http://localhost:9009 

3. Swagger ui available on:
http://localhost:9009/swagger-ui.html

Try out with some example currency pairs like : USDJPY, EUDUSD, GBPCAD, USDINR