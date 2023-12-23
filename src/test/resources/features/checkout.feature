Feature: Order checkout Feature

  Background:
    Given The User navigates to Swag Labs website

  Scenario: Validate the User is able to checks out successfully with Multiple Items.
    When The user is logged into the app with valid username "standard_user" and password "secret_sauce"
    Then The User is launched in Products Page
    And Verify the product "Onesie" are listing in the productsPage
    When User Adds item "Onesie" to the Cart
    And Verify the product "Backpack" are listing in the productsPage
    When User Adds item "Backpack" to the Cart
    And User clicks on the Shopping Cart
    Then Verify the Item is added in yourCartScreen
    When The user clicks on checkoutButton
    Then Verify the Checkout: Your Information screen is displayed
    And Verify that the user is able to enter customer details
    When User clicks on Continue button
    Then Verify Checkout: Overview screen is displayed
    When User clicks on Finish button
    Then Verify the Order is displayed.

  Scenario: Validate the User is not able to login the app with Invalid Credentails
    When The user tries to log on to the app with Invalid username "Invalid_user" and password "secret_sauce"
    Then Error message is displayed with proper error message