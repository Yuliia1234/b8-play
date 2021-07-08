Feature:Login functionality testing feature file

  Background:

  @implemented
  Scenario: Ebay search page
    Given user navigates to "https://www.ebay.com/"
    When user searches for "java for dummies"
    Then user validates the numbers of results more then 10
