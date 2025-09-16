
# Feature: Register Accounts
# This feature tests the account registration functionality for various scenarios

Feature: Register Accounts

Scenario: Verify account registration with empty lastName

Given User already opened the webpage
When RegisterLink is clicked
And user enters data with lastName empty

 | First Name| Last Name  |Address   | City      | State     | Zip Code | Phone	  | SSN    | Username   | Password   | Confirm    |
 | BankUser2 | 						|BankUser2 | BankUser2 | BankUser2 | 1101     | 999999  | 12345  | BankUser2	| BankUser2  | BankUser2  |
 
And user clicks the register button 
Then the user should see an error message for empty last name
  
 Scenario: Verify account registration with confirm password error
 
Given User already opened the webpage
When RegisterLink is clicked
And the user enters wrong confirm password
| First Name 		   | Last Name          | Address						| City      					| State     				| Zip Code 						| Phone	  				| SSN    							| Username   			| Password   				| Confirm    |
|PasswordErrorUser1| PasswordErrorUser1	|PasswordErrorUser1|	PasswordErrorUser1	|PasswordErrorUser1|	PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordError|
 
And user clicks the register button
Then the user should see an error message
  
