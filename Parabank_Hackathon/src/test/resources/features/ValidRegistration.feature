# Feature: Register Accounts
# This feature tests the account registration process with various scenarios

Feature: Register Accounts

@positive 

Scenario: Verify account registration with valid data

Given User already opened the webpage
When RegisterLink is clicked
And user enters valid data
 | First Name | Last Name | Address     | City      | State      | Zip Code | Phone	  | SSN    | Username   | Password   | Confirm    |
 | BankUser16 | BankUser16 | BankUser16 | BankUser16 | BankUser16 | 1101     | 999999  | 12345  | BankUser16| BankUser16 | BankUser16 |

And user clicks the register button
Then user registered successfully



    