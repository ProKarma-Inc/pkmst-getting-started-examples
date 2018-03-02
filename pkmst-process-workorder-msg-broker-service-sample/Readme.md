This project was scaffolded from PKMST code generator integrated with Swagger UI :

http://swagger-editor.mybluemix.net/

Generate Server : java-pkmst 


This service works in conjunction with 2 other services. The 3 services that work together are :

#pkmst-order-mgmt-msg-broker-service-sample
#pkmst-process-payment-msg-broker-service-sample
#pkmst-process-workorder-msg-broker-service-sample


These service demonstrate aggregation of services using messaging pattern. The aggregator (pkmst-order-mgmt-msg-broker-service-sample) receives a request to place an order. It then sends messages to the other 2 services, one that processes payment of order, the other processes initiation of work-order for manufacturing of the product. Both the services perform their respective tasks and send back response messages to the service that is performing aggregation.
The composite service aggregates the responses received asynchronously from the other 2 services and send the response back to caller via websocket.


## Prerequisites

- Maven 3.x
- Java 1.7
- Git

## Steps to run the application: 

1.Clone this repository
https://github.com/ProKarma-Inc/pkmst-getting-started-examples.git

  Now from your environment and run each of the 3 applications with the following commands in separate command windows :

##
  $ cd pkmst-order-mgmt-msg-broker-service-sample

  $ mvn clean install

  $ mvn spring-boot:run

##
  $ cd pkmst-process-payment-msg-broker-service-sample

  $ mvn clean install

  $ mvn spring-boot:run

##
  $ cd pkmst-process-workorder-msg-broker-service-sample

  $ mvn clean install

  $ mvn spring-boot:run  
  
  
2. Project will run on http://localhost:8008 

Use the sample index page to try out:

