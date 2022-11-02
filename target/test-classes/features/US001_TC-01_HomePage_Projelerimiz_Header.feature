@happyTesting

Feature: US001 Verify "Projelerimiz" Header

  Scenario: TC01_Projelerimiz
    Given user goes to "tiga" webpage
    Then hovers Projelerimiz
    Then clicks on Projelerimiz
    And verifies the main text
    And scrolls down until the bottom of the page
    And verifies Tiga Hakkinda texts
    And clicks on twitter logo
    And in the opening page verifies the tiga biography text
    Then clicks on youtube logo
    And clicks on subscribe


