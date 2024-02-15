Feature: search feature

  Scenario: search for an Iphone 13 in vodafone ecommerce website
    Given User is in Vodafone ecommerce website homepage
    And I dismiss the cookies pop up
    When I press the smart phone button in the upper menu
    When I select the apple section of the store
    And I enter the search value in the search bar
    Then I verify that the results are relevant


