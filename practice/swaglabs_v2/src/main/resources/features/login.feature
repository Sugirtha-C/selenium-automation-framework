@Login

Feature: Login
	As a user I want to login to saucedemo
	
	@positive
	
	Scenario: Login with valid data	
	Given User already opened the webpage
	When User input "standard_user" as username "secret_sauce" as password
	Then User already on homepage
	
	@negative
	Scenario Outline: Login with invalid data
	Given User already opened the webpage
	When User input "<username>" as username "<password>" as password
	Then User get "<error>" as error message
	
	Examples: Credentials data
	
	|	username			|	password			|error																|
	|								|								| Epic sadface: Username is required  |
	|locked_out_user|								| Epic sadface: Password is required  |
	|								| secret_sauc		|	Epic sadface: Username is required	|
	| standard_user | secret_sauc   | Epic sadface: Username and password do not match any user in this service |
	
	
	
	
	