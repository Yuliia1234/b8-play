Feature: Google search functionality
  @googleSearch
  Scenario Outline: Search for products
    Given I am on google search page
    When I am search for "<product>"
    Then i get results about "<product>"
    Examples:
    |product     |
    |laptop      |
    |sushi place |
    |iphone      |
    |bootcamp    |

@gmailLogin
    Scenario Outline: Gmail login test
      Given user is ongmail login page
      When user tries to login with invalid "<username>" and "<password>"
      Then user should see error massage
      And should not be on mail box page
      Examples:
      |username        |password           |
      |invalidUsername |validPassword      |
      |some username   |some other password|
      |invalidUsername2|another password   |
      |user1233        |no password        |
      |invalidUsername4|empty password     |


