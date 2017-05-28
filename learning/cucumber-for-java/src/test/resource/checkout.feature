Feature: Checkout

  Scenario: Checkout a banana
    Given the price of a "banana" is 40c
    When I checkout 1 "banana"
    Then the total price should be 40c

  Scenario: Checkout a banana book version
    Given A the price of a "banana" is 40c
    When A I checkout 1 "banana"
    Then A the total price should be 40c

  Scenario: Checkout 10 bananas book version
    Given A the price of a "banana" is 40c
    When A I checkout 10 "banana"
    Then A the total price should be 400c

  Scenario Outline: Checkout bananas
    Given A the price of a "banana" is <price>c
    When A I checkout <count> "banana"
    Then A the total price should be <total>c

    Examples:
      | price | count | total |
      | 40    | 1     | 40    |
      | 40    | 2     | 80    |
      | 40    | 4     | 160   |
      | 80    | 2     | 160   |


  Scenario: Two bananas scanned separately
    Given A the price of a "banana" is 40c
    When A I checkout 1 "banana"
    And A I checkout 1 "banana"
    Then A the total price should be 80c


  Scenario: A banana and an apple
    Given the price of a "banana" is 40c
    And the price of a "apple" is 25c
    When I checkout 1 "banana"
    And I checkout 1 "apple"
    Then the total price should be 65c