@rates
Feature: Rates page functionality
   Background:

    Given As a user should be on login page
    Given user enters the valid username
    Given user enters the valid password
    Given user clicks the login button
    Given user clicks the Tax Profile button
    Given user clicks th Rates button

    Scenario: user should on Rates page
      Then Verify the page title
