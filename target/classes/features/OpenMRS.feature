Feature: Open MRS

  @openMRS
  Scenario: Register a patient test
    Given I am logging in with credentials:
      | username | password | department |
      | admin    | Admin123 | Pharmacy   |
    When i register a new patient
      | given name  | techtorial |
      | family name | academy    |
      | gender      | Female     |
      | birthDay    | 21         |
      | birthMounth | March      |
      | birthYear   | 2019       |
      | address     | 2200 Devon |
    Then i see conformation page has
      | given name | family name |
      | techtorial | academy     |

