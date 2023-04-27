Feature: Test google search functionality

Scenario: As a user I enter a search criteria in google
    Given I am on the Google search page
    When  I enter a search criteria
    And Click on the search button
    Then The result matches the search criteria
