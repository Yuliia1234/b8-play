Feature: functionality testing feature file

  Scenario: gorest comment functionality
    Given i have a valid gorest characters endpoint
    When I should get comment for post
    Then user validates there no comments for a post
    When user create a comment for a post
    Then user validate output comment