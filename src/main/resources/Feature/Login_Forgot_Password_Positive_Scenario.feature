Feature: Login Forgot Password

  Scenario:Browser Launch
    Given Launch the chrome browser and naviaged to login page

  Scenario: Forgot Password
    When Click on Forgot Button Link
    And Enter Linked Phone number
    And Click on Send Otp Button
    Then Navigated to forgot password otp page
    And Enter otp number
    And Click on Save Changes Button
    Then Navigated to create new password page
    And Create new Password
    And Click on Change Password Button





