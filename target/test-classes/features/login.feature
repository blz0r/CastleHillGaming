#Author: Shamsul Khan
#Date: 4/22/2022
#Description: 
#			User Story - As a Swag Labs customer who is not locked 
#                  out, I need to be able to log in so that I  
#									 can purchase Sauce Labs merch.


Feature: To test the login functionality of https://www.saucedemo.com

  Background: 
    Given user is on the login page

  Scenario: Successful Login
    When user enters valid username
    When user enters valid password
    And user clicks on the login button
    Then user is redirected to the Sauce Demo Main Page
    And user verifies the App Logo exists

  Scenario: Failed Login
    When user enters locked out user username
    When user enters locked out user password
    And user clicks on the login button
    Then user verifies the Error Message "Sorry, this user has been banned."