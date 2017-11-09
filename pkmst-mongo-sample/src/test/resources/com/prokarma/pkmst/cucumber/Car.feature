# This is a sample feature file. Please modify according to your APIs.

Feature: Product Service API
 @scenario-1
  Scenario:
    Given I query to display all cars "/car/allCars" 
    Then response status code for all cars should be "200"
    And response content type for all cars should be "application/json"
    
 @scenario-2
  Scenario:
    Given I query to create "/car" 
    Then response status code for create car should be "200"
    And response content type for create car should be "application/json"
 
 @scenario-3
  Scenario:
    Given I query to create cars with array "/car/createWithArray" 
    Then response status code for create cars with array should be "200"
    And response content type for create cars with array should be "application/json"
    
 @scenario-4
  Scenario:
    Given I query to delete car "/car/{vinNumber}" 
    Then response status code for delete car should be "200"
    And response content type for delete car should be "application/json"
    
 @scenario-5
  Scenario:
    Given I query to get car by vin number "/car/{vinNumber}" 
    Then response status code for get car by vin number should be "200"
    And response content type for get car by vin numberr should be "application/json"
    
 @scenario-6
  Scenario:
    Given I query to updated car "/car/{vinNumber}" 
    Then response status code for updated car should be "200"
    And response content type for updated car should be "application/json"  
    
 