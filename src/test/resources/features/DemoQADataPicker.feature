Feature: Demo QA Scenarios
  		 I want to practice different scenarios on Demo QA
	@DemoQaDatePicker
  Scenario: I should be able to select a data from date picker
    Given I am on the date picker page "https://demoqa.com/date-picker"
    When I enter "09/24/2027" to date picker
    Then Date entered should be selected