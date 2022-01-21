@forgot
Feature: Forgot Password page
  Background:
    Given As a user should be on login page
    And As a user should click the Forgot your password? button

  Scenario: Enter username on the Forgot password page
    Then Verify that user should be on Forgot password page.
    And As a user should enter "username"
    And As a user should click the send button
    Then verify that the email sent message
    And As a user I should click Return to login page
    Then Verify that login page is displayed

   Scenario: Turn on the Login page
     And As a user I should click Return to login page
     Then Verify that login page is displayed




