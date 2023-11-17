Feature: EyeGlass Store Search Functionality

@dryrun
Scenario: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on city/state/zipcode "atlanta"
Then I should see the appropriate store details in the search results page with city/state/zipcode "atlanta"

@datarun
Scenario Outline: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on "<city/state/zipcode>"
Then I should see the appropriate store details in the search results page with "<city/state/zipcode>"
Examples:
|city/state/zipcode|
|tampa|
|goergia|
#|chicago|
#|atlanta|

@datatablerun
Scenario: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on different Cities
|City|
|Chicaga|
|dallas|
|austin|
|houston|
Then I should see the appropriate store details in the search results page with city "chicago"

