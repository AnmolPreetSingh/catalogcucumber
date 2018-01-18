Feature: Login Action
 
Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User Navigate to Log yourself in link And User enters UserName and Password
	Then Welcome to iBusiness page display
    Then click on logoff and click on closebutton	