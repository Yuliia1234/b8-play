Feature: Login functionality testing feature file

  @espoCRM
  Scenario: simple test
    Given user navigates to home page "https://demo.espocrm.com/?lang=en_US#"
    When the user opens the home page
    Then  the user should see the function names:
      | Home          |
      | Accounts      |
      | Contacts      |
      | Leads         |
      | Opportunities |
      | Reports       |
      | Quotes        |
      | Sales Orders  |
      | Invoices      |
      | Products      |
      | Emails        |
      | Cases         |
      | Calender      |

  @Task2
  Scenario Outline: account test
    Given user navigates to page "https://demo.espocrm.com/?lang=en_US#"
    When the user open the Accounts
    Then the user clicks the Create Account button
    And the user create 4 new account "<name>" and "<email>"
    And the user validate the new users is created
    Examples:
      | name    | email             |
      | Brian   | brian@gamil.com   |
      | Alex    | alex@gmail.com    |
      | Anna    | anna@gmail.com    |
      | Jenifer | jenifer@gmail.com |

