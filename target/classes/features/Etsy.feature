Feature: Testing etsy with cucumber datatable


  @datatable
  Scenario: Simple database
    Given user is on etsy home page
    When user searches for following:
      | search phrase | java OCA book |
      | another search phrase | selenium |

    Then user should see results about java only

    @datatable2
    Scenario: Another datatable
      Given user is on amazon page
      When user searches for :
      |product|
      |iphone |
      Then the result is valid

      @datatable3
      Scenario: Login functionality
        Given user on home page
        When user log in  using credential:
        |username|Hello|
        |password | World |
        Then result is valid

@multiSearch
        Scenario: search for multiple products
          Given user is on ecommerce page
          When user searches for multiple products:
          |product|
          |iphone |
          |samsung|
          |tablet |
          Then user sees different results

