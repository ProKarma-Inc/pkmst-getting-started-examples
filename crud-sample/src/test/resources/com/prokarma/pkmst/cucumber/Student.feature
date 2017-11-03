# This is a sample feature file. Please modify according to your APIs.

Feature: Student Service API
 @scenario-1
  Scenario:
    Given I query to all students "/students" 
    Then response status code for get should be "200"
    And response content type for get should be "application/json"
 @scenario-2
  Scenario:
    Given I query to student-id"/student/{id}" 
    Then response status code for get should be "200"
    And response content type for get should be "application/json"
 @scenario-3
  Scenario:
    Given I query to delete student-id "/students/{id}" 
    Then response status code delete should be "200"
    And response content type for delete should be "application/json"
 @scenario-4
  Scenario:
    Given I query to add "/students" 
    Then response status code post  should be "201"
    And response content type for post should be "application/json"