Feature: Login Page

  Scenario: Verify that sign up button opens registration page
    Given user is on login page
    Then user opens registration page

  Scenario: Verify select plan page functionality
    Given user is on login page
    And user clicks on signup link
    Then verify that plan page is shown

