Feature: Security Testing for Product Service API

 @scenario-9
  Scenario:
    Given Unauthorized access for REST Service 
    Then except status code should be "401"
 
 @scenario-10
  Scenario:
    Given Invalid User Credentials
    Then Invalid User Credentials status code should be "400"
    
 @scenario-11
  Scenario:
    Given Invalid OAUTH2 Credentials
    Then Invalid OAUTH2 Credentials status code should be "401"
    
 @scenario-12
  Scenario:
    Given Valid OAUTH2 REST accesstoken
    Then Valid OAUTH2 REST accesstoken should not null
    
 @scenario-13
  Scenario:
    Given Valid OAUTH2 REST GET PRODUCTS
    Then Valid OAUTH2 REST GET PRODUCTS should be success
    
 @scenario-13
  Scenario:
    Given Valid OAUTH2 REST service
    Then Valid OAUTH2 REST service should be success