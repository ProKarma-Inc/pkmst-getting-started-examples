# This is a sample feature file. Please modify according to your APIs.

Feature: HelloWorld Service API
 @scenario-1
  Scenario:
    Given I query to greet testuser "/hello/testuser"
    Then response status code for get should be "200"
    And response content type for get should be "application/json"
 