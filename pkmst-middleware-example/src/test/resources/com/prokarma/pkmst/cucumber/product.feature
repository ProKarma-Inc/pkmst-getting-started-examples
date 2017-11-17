Feature: Product Service API
 @scenario-1
  Scenario:
    Given I query to all products "/products" 
    Then response status code for get should be "200"
    And response content type for get should be "application/json"
 @scenario-2
  Scenario:
    Given I query to product-id"/product/{id}" 
    Then response status code for get should be "200"
    And response content type for get should be "application/json"
 @scenario-3
  Scenario:
    Given I query to delete product-id "/products/{id}" 
    Then response status code delete should be "200"
    And response content type for delete should be "application/json"
 @scenario-4
  Scenario:
    Given I query to add "/products" 
    Then response status code post  should be "201"
    And response content type for post should be "application/json"