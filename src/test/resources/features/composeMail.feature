Feature: Compose Email in Gmail

  Scenario: Successful composition of an email
    Given the user is logged into Gmail
    When the user composes an email with subject "Incubyte" and body "QA test for Incubyte"
    Then the email should be sent successfully

  Scenario: Failed composition due to missing subject
    Given the user is logged into Gmail
    When the user composes an email without a subject
    Then the email should not be sent
    And an error message should be displayed

  Scenario: Failed composition due to missing body
    Given the user is logged into Gmail
    When the user composes an email without a body
    Then the email should not be sent
    And an error message should be displayed
