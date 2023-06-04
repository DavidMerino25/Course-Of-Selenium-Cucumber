
Feature: Test different actions on a sandbox page

Scenario: As a Test Engineer I want to test different actions on a sandbox page.
    Given I navigate to the sandbox page
    And Select a value from the dropdown

Scenario: As a Test Enginee I want to retrieve te value of an static table
    Given I navigate to the static table
    When I can return the value I wanted


Scenario: As a Test Engineer I want to upload a file
    Given I navigate to the upload page
    When I upload a file
    Then I can see the file uploaded