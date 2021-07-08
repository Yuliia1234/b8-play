Feature: Star Wars API

  Scenario: Get characters test
    Given i have a valid Star Wars characters endpoint
    When i send GET request
    Then I should get 200 status code
    And I should get response in JSON format
    And I should get Luke in the response