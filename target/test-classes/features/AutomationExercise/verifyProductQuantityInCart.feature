@regression
Feature: Testing Product Quantity Increase Functionality
  Scenario: Testing Product Quantity in Cart
    When User click View Product for any Product on Home Page
    And User Validate Product Detail is Opened
    And User Increase Quantity to 4
    And User click Add to Cart Button
    And User click View Cart Button
    Then User validate Product is Displayed in Cart with Quantity 4
