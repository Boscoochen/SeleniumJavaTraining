Feature: SearchProduct
	Scenario: Enter keyword and search
		Given I am on the home page
		Then I Enter the keyword T-shirt and click the search button
		And the item calls Faded Short Sleeves T-shirt appears
		
