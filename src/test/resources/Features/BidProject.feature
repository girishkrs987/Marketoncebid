Feature: MarketOnce


#without Examples Keyword
@Internal_Quota_Groups
Scenario: Edit Requested N Test Scenario
#
Given user is already on Login Page
When title of login page is MarketOnce
Then user enters "automation.qa@roirocket.com" and "demopassword123"
Then user clicks on login button
Then user is on home page
Then user clicks on Bids 
Then user validate Projects By searching project ID "2384"
Then user view Project details
Then user click Edit Project
Then User verify Test and Lanuch tabs are in disable status
Then User Edit Requested N and enter quota group Requested N as"10"
# User enter quota group Requested N as"3"
#Then Logout the Application
#Then Close the browser
 





#without Examples Keyword
@Tabs
Scenario: MarketOnce Bid - Test and Lanuch tabs Scenario

Given user is already on Login Page
When title of login page is MarketOnce
Then user enters "automation.qa@roirocket.com" and "demopassword123"
Then user clicks on login button
Then user is on home page
Then user clicks on Bids 
Then user validate Projects By searching project ID "2370"
Then user view Project details
Then user click Edit Project
Then User verify Test and Lanuch tabs are in disable status
#Then Logout the Application
#Then Close the browser

#with Examples Keyword
#Scenario Outline: Free Marketonce Login Test Scenario

#Given user is already on Login Page
#When title of login page is  Marketonce
#Then user enters "<username>" and "<password>"
#Then user clicks on login button
#Then user is on home page
#Then Close the browser


#Examples:
#	| username | password |
	#| automation.qa@roirocket.com  | demopassword123 |
	#|  tom     | test456  | 	
		