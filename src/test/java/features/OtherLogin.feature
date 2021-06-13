@LoginFeature
Feature: validate Techfios login functionality 

Background:  
	Given User is on the "Techfios" login page

Scenario Outline: 1 User should be able to Login with valid credentials
When User enters "<username>" and "<password>"  
And User clicks on sigin button 
Then User should land on Dashboeard page 
Examples:
|      username   | password|
|demo@techfios.com| abc123  |
|demo@techfios.com| abc124  |
|demo2@techfios.com| abc123 |
|demo2@techfios.com| abc123 |
	

	