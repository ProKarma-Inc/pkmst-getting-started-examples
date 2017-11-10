Feature: HelloWorld API
 @scenario-1
  Scenario:
    Given I query to sayHello "/sayHello" 
    Then response status code for sayHello should be "200"
 @scenario-2
  Scenario:
    Given I query to hello "/hello/{name}" 
    Then response status code for hello should be "200"
