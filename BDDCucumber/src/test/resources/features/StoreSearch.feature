Feature: EyeGlass Store Search Functionality

@dryrun
Scenario: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on City name
Then I should see the appropriate store details in the search results page

@datatablerun
Scenario: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on different Cities
|City|
|Chicaga|
|dallas|
|austin|
|houston|
Then I should see the appropriate store details in the search results page


@datarun
Scenario Outline: verify the functionality of searching an EyeGlass store based on City name
Given I access EyeGlass world website
When I search for an eyeglass store based on "<City>" name
Then I should see the appropriate store details in the search results page
Examples:
|City|
|tampa|
|newyork|
|duluth|
|atlanta|