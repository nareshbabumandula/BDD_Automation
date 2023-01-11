Feature: Search Feature

Background:
Given i access amazon portal

@regression
Scenario: verify the search functionality
When i enter any valid product
And i click on search button
Then it should display the appropriate product details

@smoke
Scenario: verify the search functionality with an invalid search criteria
When i enter any invalid product
And i click on search button
Then it should display the appropriate product details

@smoke
Scenario: verify the search functionality with a partial text
When i enter any product name with a partial text "umbre"
And i click on search button
Then it should display the appropriate product details

@smoke
Scenario Outline: verify the search functionality with a partial text
When i enter any product name with a partial text as "<productname>"
And i click on search button
Then it should display the appropriate product details

Examples:
|productname|
|ipho|
|samsu|
|umbre|
|watc|
|electr|

@dryrun
Scenario: verify the search functionality with a partial text
When i enter any product name with a partial text 
|bottl|
|penc|
|erase|
And i click on search button
Then it should display the appropriate product details


