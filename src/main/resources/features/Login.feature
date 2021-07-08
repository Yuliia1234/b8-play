Feature: Login functionality testing feature file
  @smoke @regression

  Scenario: Happy path login scenario
    Given user on home page
    When user log in with valid username and password
    Then user sees the welcome massage


  Scenario: OpenMRS login test
    Given user has valid credentials
    And user is on OpenMRS login page
    When user logs in with valid credentials
    Then user sees welcome massage

