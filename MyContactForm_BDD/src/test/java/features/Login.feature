Feature: Verify the login functionality

Background: 
Given i access mycontactform portal

@smoke
Scenario: Verify the user login functionality with invalid login credentials
Given i enter username as "naresh"
When i enter password as "secure*123"
And i click on login button
Then i should see an appropriate validation message

