Feature: Test

#Scenario: Test Login of PHPTravels Application
#
#Given User navigates to PHPTravels Login Page
#When User enters valid username and password
#Then User navigates to Home Screen


Scenario Outline: Test Login of PHPTravels Application1234

Given User navigates to PHPTravels Login Page
When User enters invalid <username> and <password>
Then User sees error message
Examples:
|username|password|
|aaaa|bbbb|
|cccc|dddd|