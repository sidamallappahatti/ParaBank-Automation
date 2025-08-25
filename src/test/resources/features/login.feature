@smoke
Feature: Login
  Scenario: Valid login
    Given I am on the ParaBank login page
    When I login as "john" with password "demo"
    Then I should see the Accounts Overview page