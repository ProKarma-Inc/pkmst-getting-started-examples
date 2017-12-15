# This is a sample feature file. Please modify according to your APIs.

Feature: Product Service API
 @scenario-1
  Scenario:
    Given I query to login "/user/login" 
    Then response status code for all users should be "200"
    And response content type for all users should be "application/json"
    
 @scenario-2
  Scenario:
    Given I query to create "/user" 
    Then response status code for create user should be "200"
    And response content type for create user should be "application/json"
    
 @scenario-3
  Scenario:
    Given I query to delete user "/user/{username}" 
    Then response status code for delete user should be "200"
    And response content type for delete user should be "application/json"
    
 @scenario-4
  Scenario:
    Given I query to get user by vin number "/user/{username}" 
    Then response status code for get user by vin number should be "200"
    And response content type for get user by vin numberr should be "application/json"

    
 
    
 