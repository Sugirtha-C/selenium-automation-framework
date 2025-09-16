Feature: magneto homepage

Scenario: Demo message is visible

	Given url "https://magento.softwaretestingboard.com/" is launched
	When page is loaded
	Then Demo message "This is a demo store to test your test automaiton scripts. No orders will be fulfilled. If you are facing any issue, email us at hello@softwaretestingboard.com." is visible
	
	
Scenario: Verify signin and sign out

	Given url "https://magento.softwaretestingboard.com/" is launched
	When sign in is clicked
	And User Input "sri@gmail.com" as username and "Sri1986@gmail" as password
	And login is clicked
	And Signout is clicked
	Then user signedout successfully.
	
