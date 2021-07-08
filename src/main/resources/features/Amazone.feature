
Feature: Amazon search functionality

  Scenario: OpenAmazon page
    Given user navigates to amazon.com
    When user searches for selenium cookbook
    Then user validates the number of results more then 10
    And user validates the search criteria