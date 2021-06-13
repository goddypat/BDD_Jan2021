Feature: validate Techfios login functionality 

Background:  
	Given User is on the Techfios login page      
	
Scenario: 1 User should be able to login with valid credentials 
	When User enters username as "demo@techfios.com"                
	When User enters password as "abc123"                              
	And User clicks on Signln button                                    
	Then User should land on Dashboard page 