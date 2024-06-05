Feature: Store Search

Background:
Given I access eyeglassworld portal

@dryrun
Scenario: verify the functionality of searching an eyeglass store based on city name
When I enter a city name as "tampa"
And I click on FIND A STORE button
Then I should see the appropriate store search results