@manual
Feature: Cash Withdrawal cucumber-->domain model

"""
  Some inconsistent language is creeping in; the step talks
  about depositing funds, but the code passes funds to the Account constructor.

  The step is lying to us! It says Given I have deposited $100 in my account,
  and it’s passed. Yet we know from our implementation that nothing has been
  deposited anywhere.

  Bank balances don’t always contain whole numbers of dollars, but our step
  definition uses an int. We should be able to deposit dollars and cents.

  You have to read about regexp, what this "^[^\\d]*([\\d]+)\\.([\\d][\\d])$"
  pattern does
"""

  Background:
    Given server automated teller

  Scenario Outline: Successful withdrawal from an account in credit
    Given Account has been credited with <input>
    When I withdraw $<withdraw>
    Then $<withdraw> should be dispensed
    And The balance of my account should be <result>

    Examples:
      | input   | withdraw | result |
      | $100.00 | 20.00    | $80.00 |
      | $200.00 | 200.00   | $0.00  |

  Scenario: Successful withdrawal from an account in credit
    Given Account has been credited with $100.00
    When I withdraw $20.00
    Then $20.00 should be dispensed
    And The balance of my account should be $80.00