Feature: Application Login

Scenario: Login With valid Credentials
Given open any Browser
And Navigate to login page
When User enters username as "arun.selenium@gmail.com" and password as "Second@123"
And user clicks on Login button
Then verify user is able to successfully Login
