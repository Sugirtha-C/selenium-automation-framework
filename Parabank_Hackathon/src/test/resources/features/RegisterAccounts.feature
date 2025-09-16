Feature: Register Accounts

@positive 

Scenario: Verify account registration with valid data

Given User already opened the webpage
When user enters valid data
 | First Name | Last Name | Address                | City      | State     | Zip Code | Phone	  | SSN    | Username   | Password   | Confirm    |
 | BankUser2 | BankUser2 | BankUser2@hotmail.com | BankUser2 | BankUser2 | 1101     | 999999  | 12345  | BankUser2	  | BankUser2  | BankUser2  |

And user clicks the register button
Then user registered successfully



@negative
Scenario: Verify account registration with confirm password error

Given url "https://parabank.parasoft.com/parabank/register.htm" is launched
When Register is clicked
And the user enters wrong confirm password
| First Name 		   | Last Name          | Address						| City      					| State     				| Zip Code 						| Phone	  				| SSN    							| Username   			| Password   				| Confirm    |
|PasswordErrorUser1| PasswordErrorUser1	|PasswordErrorUser1|	PasswordErrorUser1	|PasswordErrorUser1|	PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordErrorUser1	|PasswordError|
 
And user clicks the register button
Then the user should see an error message
    | error                 |
    | Passwords did not match. |

    