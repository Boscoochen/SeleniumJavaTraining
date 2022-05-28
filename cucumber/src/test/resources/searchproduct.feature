Feature: SearchProduct
	Scenario: Enter keyword and search
		Given I am on the "home" page
		And I Enter the keyword "T-shirt" and click the search button
		Then the item calls "Faded Short Sleeves T-shirt" appears
		
