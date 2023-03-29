
Feature: Testing Place Order
  Background:
    Given User validate that Home Page is Visible Successfully
  @regression
  Scenario: Testing Place Order Register while Checkout
    When User add products to cart
    And User Click Cart button
    And User Verify that cart page is displayed
    And User Click Proceed To Checkout
    And User Click RegisterLogin button
    And User Fill all details in Signup and create account
    And User Verify account created 'ACCOUNT CREATED!' and click Continue button
    And User Verify Logged in as 'Jolie' at top
    And User Click Cart button
    And User Click Proceed To Checkout button
    And User Verify '1 hopper dr' Details and Review Your Order
    And User Enter description in 'Blue Top' text area and click Place Order
    And User Enter payment details Name , card Number, CVC, Expiration date
    And User Click Pay and Confirm Order button
    And User Verify success message 'Your order has been placed successfully!'
    And User Click Delete Account button
    Then User Verify 'ACCOUNT DELETED!' and click Continue button
  @regression
  Scenario: Testing Place Order Register before Checkout
    When User Click SignupLogin Button
    And User Fill all details in Signup and create account
    And User Verify account created 'ACCOUNT CREATED!' and click Continue button
    And User Verify Logged in as 'Jolie' at top
    And User add products to cart
    And User Click Cart button
    And User Verify that cart page is displayed
    And User Click Proceed To Checkout
    And User Verify '1 hopper dr' Details and Review Your Order
    And User Enter description in 'Blue Top' text area and click Place Order
    And User Enter payment details Name , card Number, CVC, Expiration date
    And User Click Pay and Confirm Order button
    And User Verify success message 'Your order has been placed successfully!'
    And User Click Delete Account button
    Then User Verify 'ACCOUNT DELETED!' and click Continue button

  @regression
  Scenario: Testing Place Order Login before Checkout
    When User Click SignupLogin Button
    And User Fill Email, Password and Click Login Button
    And User Verify Logged in as 'Jolie' at top
    And User add products to cart
    And User Click Cart button
    And User Verify that cart page is displayed
    And User Click Proceed To Checkout
    And User Verify '1 hopper dr' Details and Review Your Order
    And User Enter description in 'Blue Top' text area and click Place Order
    And User Enter payment details Name , card Number, CVC, Expiration date
    And User Click Pay and Confirm Order button
    And User Verify success message 'Your order has been placed successfully!'

  @regression
  Scenario: Testing Remove Products from Cart
    When User add products to cart
    And User Click Cart button
    And User Verify that cart page is displayed
    And User Click X Button corresponding to particular product
    And User validate that 'Cart is empty!'

  @regression
  Scenario: Testing View Category Products
    When User Click on Women Category
    And User Click Tops under Women Category
    And User Validate 'category' Page is Displayed and Validate 'WOMEN - TOPS PRODUCTS'
    And User on Left Side bar, Click on any Sub-Category link of Man Category
    Then Validate User is Navigated to that Category 'MEN - JEANS PRODUCTS'

  @regression
  Scenario: Testing View And Cart Brand Products
    When User Click Products Button
    And User Validate that 'BRANDS' are Visible on Left Side Bar
    And User Click H&M Brand
    And User Validate that Navigated to Brand 'https://automationexercise.com/brand_products/H&M' and 'BRAND - H&M PRODUCTS' are Displayed
    And User Click KOOKIE KIDS Brand Link
    Then User Validate that User Navigated to that Brand 'BRAND - KOOKIE KIDS PRODUCTS' and Products are Displayed


