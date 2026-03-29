
@registration
Feature: Registration

Scenario: Register valid user
  Given user is on home page
  When user clicks on signup login button
  And user registers with "valid"
  Then registration should be successful

Scenario: Register invalid user
  Given user is on home page
  When user clicks on signup login button
  And user registers with "missing_fields"
  Then registration should fail
  
Scenario: Invalid email in signup
  Given user is on home page
  When user clicks on signup login button
  And user registers with "invalid_email"
  Then email validation message should be shown