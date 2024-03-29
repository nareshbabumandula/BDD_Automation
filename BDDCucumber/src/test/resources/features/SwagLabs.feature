Feature: SwagLabs products verification

Background:
Given i access Sauce Demo portal

Scenario: Verify the functionality of accessing Sauce Demo portal
Then i should see Swag Labs login page

@dryrun
Scenario: Verify the fields displayed in Swag Labs login section
Then i should see username, password, login, accepted usernames and password fields in Swag Labs login page
