Feature: Departure screens



  Scenario: Flight code is displayed on the screen
    Given the flight EZY4567 is leaving today
    Given the flight C038 is leaving today
    Given the flight BA01618 is leaving today
    Given the flight A1 is leaving today
    Given I have 1 cucumber in my basket
    Given I have 256 cucumbers in my basket
    When I visit the homepage
    When I go to the homepage

  Scenario: Transfer funds from savings into checking account
    Given I have deposited $10 in my Checking Account
    And I have deposited $500 in my Savings Account
    When I transfer $500 from my Savings Account into my Checking Account
    Then the balance of the Checking Account should be $510
    And the balance of the Savings Account should be $0