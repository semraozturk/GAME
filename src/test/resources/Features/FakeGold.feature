Feature: As a user, I should be able to find the fake gold bar

  @test
  Scenario: Find out the number of the fake gold bar
    When user weighs bars and finds the one weighing less than others
    And clicks on the number of the fake bar in the numbers box
    Then user should see "Yay! You find it!” message on the screen

