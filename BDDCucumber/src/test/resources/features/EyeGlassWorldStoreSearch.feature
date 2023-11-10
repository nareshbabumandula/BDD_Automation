Feature: Store Search

@smoke
Scenario: Verify the functionality of searching an eyeglass store base on City name
Given I access Eyeglassword website
When I search a Store by City
Then I should see the store details based on City
