Feature: Validating the place API

@AddPlace
  Scenario Outline: verify if place is successfully added using AddplaceAPI
    Given Add Place Payload "<name>" "<language>" "<address>"
    When user call "AddPlaceApi" with "Post" http Request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place Id created maps to "<name>" using "GetPlaceApi"
  Examples: 
  	|name| language| address|
  	|Akshay|English| House no 175|
  #	|Abhishek|English| House no 176|
  	
@DeletePlace
	Scenario: verify if Delete place functionality is working
		Given DeletePlace payload
		When user call "DeletePlaceApi" with "Post" http Request
		Then the API call got success with status code 200
		And "status" in response body is "OK"