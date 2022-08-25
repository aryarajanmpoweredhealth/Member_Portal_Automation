Feature: Findcare

  Scenario:Validate that the user is navigated to the Findcare page on clicking Care Tab on home
    When clicking on care tab
    Then navigated to findcare page

  Scenario: Validate that the user can able to click on Add location and search location
    When clicking on Add location buttton
    Then validate user can able to search for area and street name

  Scenario: Validate that the user can able to view Provider section
    When clicking on provider part
    Then User should view the list of all Pharmacies nearest to selected location
    Then verify user can able to click and view Previously Visited datas

  Scenario:

  Scenario: Previously Visited view details is pending

  Scenario:
