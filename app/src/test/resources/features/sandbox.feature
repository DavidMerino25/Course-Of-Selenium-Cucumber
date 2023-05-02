
Feature: Test different actions on a sandbox page

Scenario: As a Test Engineer I want to test different actions on a sandbox page.
    Given I navigate to the sandbox page
    And Select a value from the dropdown
@Test
Scenario: As a Test Enginee I want to retrieve te value of an static table
    Given I navigate to the static table
    When I can return the value I wanted