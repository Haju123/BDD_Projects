Feature: Rest API
  As a user
  I want to send request for a API
  So that I validate the response obtained for the API

  Scenario Outline: API Request and Response
	Given Seaching the github api no <SearchCount>
	When API with <keyword>
	Then the response code should be <code>
	  
	
	Examples: 
	
	|SearchCount| keyword | code |
	| 1	        | java    | 200  |
	| 2         | angular | 200  |
	| 3         |         | 422  |
		