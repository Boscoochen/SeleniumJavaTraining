Feature: login
	Scenario: Register new user
		Given I am current on the home page
		Then I click on sign in button
		When I sign in with valid email and password
		And I should see the MY ACCOUNT title
		