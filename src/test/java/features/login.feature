Feature: User Login

  Background: Open mobile app
    Given User open mobile app

  Scenario: Verify that the user can login successfully after entering a valid username and password
    When the user enters username "TestUser" and password "TestPassword"
    And user clicks on login button
    Then user should see a success login message "Welcome !Thanks for Logging in"

  Scenario: Verify that the user can not login after entering a valid username and an empty password
    When the user enters a valid username "TestUser" and empty password
    Then the login button is not enabled

  Scenario: Verify that the user can not login after entering an empty username and a valid password
    When the user enters an empty username and a valid password "TestPassword"
    Then the login button is not enabled


