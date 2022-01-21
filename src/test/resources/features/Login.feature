@login
Feature: Login Page
  Background:
    Given As a user should be on login page

  Scenario: login with valid credentials
    When user enters the valid username
    And user enters the valid password
    And user clicks the login button
    Then user should be on home page

  Scenario: login with invalid username
    When user enters the invalid username
    And user enters the valid password
    And user clicks the login button
    Then user should get the error message

  Scenario: login with invalid password
    When user enters the valid username
    And user enters the invalid password
    And user clicks the login button
    Then user should get the error message
