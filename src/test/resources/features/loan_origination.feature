@loan @e2e
Feature: Loan Origination
  As a customer I want to request a loan so that I can receive funds into my account

  Background:
    Given I am on the ParaBank login page
    And I login as "john" with password "demo"

  Scenario: Request loan with sufficient funds
    When I navigate to Request Loan
    And I request a loan of "1000" with down payment "100" from account "13344"
    Then the loan request should be "Approved"
    And the new balance should reflect the loan disbursement

  @negative
  Scenario: Request loan with insufficient funds
    When I navigate to Request Loan
    And I request a loan of "100000" with down payment "10" from account "13344"
    Then the loan request should be "Denied"