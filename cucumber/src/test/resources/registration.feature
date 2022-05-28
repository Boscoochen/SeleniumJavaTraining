
Feature: Register
	Scenario: Register new user
		Given I am currently on the "home" page
		When I click sign in button
		Then I enter valid email and click "Create an account" button
		When I sign up with valid details and click "Registrer" button
		And I should see the successful sign up message
		