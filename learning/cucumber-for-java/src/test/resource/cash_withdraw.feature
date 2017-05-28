Feature: Cash Withdrawal

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

  Scenario: Successful withdrawal from an account in credit
    Given I have deposited $100.00 in my account
    When I request $20.00
    Then $20.00 should be dispensed

