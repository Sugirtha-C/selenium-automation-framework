
@login
Feature: Login

Scenario Outline: Login with multiple users
  Given user is on home page
  When user clicks on signup login button
  And user logs in with "<email>" and "<password>"
  Then login should be "<type>"

Examples:
  | email               | password | type    |
  | user1@testemail.com| user1    | valid   |
  | wrong@test.com     | wrong123 | invalid |