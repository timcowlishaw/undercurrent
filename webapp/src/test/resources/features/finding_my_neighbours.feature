@wip
Feature: Finding my neighbours

  As a local resident
  I want to find my neighbours on Undercurrent
  In order to work together on ideas for improving our neighbourhood
  
  Scenario: Finding an existing community
    Given A community already exists near my postcode
    When I search for my postcode
    Then I should be given the opportunity to join the community   
  
  Scenario: Creating a new community
    Given No community exists near my postcode
    When I search for my postcode
    Then I should be prompted to name my community
    And I should become a member of the community
    