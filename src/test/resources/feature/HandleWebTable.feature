@DataTable
Feature: Feature to handle Web table with dynamic rows and columns

  Background:
    Given user navigates to data table page site launch page

    Scenario: Verify if data is present in Employee table
      Given user verify if required "Employee" data table page is present
      Then user verify if able iterate through tables as expected