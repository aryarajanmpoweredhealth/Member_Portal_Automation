Feature:Member Portal Signup Scenario

  Scenario:  Launch the browser and navigated to signup page
    Then launch the url

  Scenario: verify that the logo is displayed
    Then verify logo is displayed on signup page

  Scenario:  Member detail page
    Then verify new user registration heading
    And User can able to enter the data in member detail page
    Then User can able to see user verified successful msg

  Scenario: create account  page
    And User can able to enter the data in create account page
    Then User can able to see popup account created successfully

  Scenario:  otp verification page
    When enter otp and navigated to sucessfull page
