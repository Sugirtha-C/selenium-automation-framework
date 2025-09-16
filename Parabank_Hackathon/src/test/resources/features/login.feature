# Feature: Login
# This feature tests the login functionality with various scenarios

Feature: Login

@positive 

Scenario: Verify login with valid data

Given User already opened the webpage
When User input "BankUser1" as username and "BankUser1" as password
Then user loggedin successfully

@negative

Scenario Outline: Verify invalid login with wrong password

Given User already opened the webpage
When User input "<username>" as username and "<password>" as password
Then user sees error

Examples:
      | username  | password |
      | BankUser1 | test5    |
      | BankUser1 |          | 
