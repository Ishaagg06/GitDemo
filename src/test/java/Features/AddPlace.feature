Feature: Validating Add Place API
  Scenario Outline:Validating successful addition of place
    Given add place payload with "<name>","<language>","<address>"
    When "AddPlaceAPI" call is made to "POST" request
    Then status code is returned as 200
    And verify place_id created maps to "<name>" using "getPlaceAPI"

    
    Examples:
    |name|language|address|
    |Isha|English|Delhi|
    @DeletePlace
    Scenario: Validating successful deletion of place
    Given delete place payload
    When "deletePlaceAPI" call is made to "POST" request
    Then status code is returned as 200
    