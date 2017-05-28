Feature: banking

  tutaj jest opis tego co bedziemy robic




  Scenario: Successful withdrawal from an account in credit
    Given I have $1000 in my account
    When I request $20
    Then $20 should be dispensed