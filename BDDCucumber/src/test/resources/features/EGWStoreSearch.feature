Feature: EyeGlass World Store Search

@smoke
Scenario: Verify the functionality of searching an eyeglass store 
Given I access EGW website
When I search a Store by State, City, and Zipcode
Then I can see the store details