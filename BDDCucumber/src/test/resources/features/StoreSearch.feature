Feature: EyeGlass Store Search Functionality

Background:
Given I access EyeGlass world website

@dryrun
Scenario: verify the functionality of searching an EyeGlass store based on City name
When I search for an eyeglass store based on city/state/zipcode "atlanta"
Then I should see the appropriate store details in the search results page with city/state/zipcode "atlanta"

@datarun
Scenario Outline: verify the functionality of searching an EyeGlass store based on City name
When I search for an eyeglass store based on "<city/state/zipcode>"
Then I should see the appropriate store details in the search results page with "<city/state/zipcode>"
Examples:
|city/state/zipcode|
|atlanta|
#|tampa|


@datatablerun
Scenario: verify the functionality of searching an EyeGlass store based on City name
When I search for an eyeglass store based on different Cities
|City/State/Zipcode|
|dallas|
|austin|
Then I should see the appropriate store details in the search results

