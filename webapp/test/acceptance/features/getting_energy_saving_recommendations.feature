Feature: Getting energy saving recommendations
  As a resident
  I want to see the options available to me to save energy
  In order to save money on my bills

  Scenario: Resident searches for possible energy savings
    Given I am on the Undercurrent homepage
    When I enter the details of my home into the savings calculator
    Then I should see a list of possible energy saving interventions
    And I should see estimated cost and carbon savings for each intervention
