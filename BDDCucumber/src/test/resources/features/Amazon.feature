Feature: Search functionality

@dryrun
Scenario: verify the product search funcionality in Amazon
Given I access Amazon portal
When I search for a product "umbrella"
Then I should see the appropriate search results

@data
Scenario Outline: verify the product search funcionality in Amazon
Given I access Amazon portal
When I search for a product "<Product>"
Then I should see the appropriate search results
Examples:
|Product|
|iphone|
|samsung|
|realme|
|redme|

@datatable
Scenario: verify the product search funcionality in Amazon
Given I access Amazon portal
When I search for a product
|watch|
|jewelry|
|pen|
|bag|
Then I should see the appropriate search results
