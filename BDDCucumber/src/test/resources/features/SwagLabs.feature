Feature: SwagLabs products verification

Background:
Given i access Sauce Demo portal

Scenario: Verify the functionality of accessing Sauce Demo portal
Then i should see Swag Labs login page

Scenario: Verify the fields displayed in Swag Labs login section
Then i should see username, password, login, accepted usernames and password fields in Swag Labs login page

Scenario: Verify the mandatory fields displayed for 'Swag Labs' products
When i enter username as "standard_user"
And i enter password as "secret_sauce"
And i click on Login button
Then i should see the mandatory options for Swag Labs products

@dryrun
Scenario Outline: Verify the mandatory fields displayed for 'Swag Labs' products
When i enter username as "<username>"
And i enter password as "<password>"
And i click on Login button
Then i should see the mandatory options for Swag Labs products
Examples:
|username|password|
|standard_user|secret_sauce|
|problem_user|secret_sauce|
|performance_glitch_user|secret_sauce|
|error_user|secret_sauce|
|visual_user|secret_sauce|



