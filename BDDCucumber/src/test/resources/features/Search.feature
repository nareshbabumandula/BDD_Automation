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
