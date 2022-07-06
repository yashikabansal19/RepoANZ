Feature: Calculate Borrowing Estimate

Scenario: Positive test case returning the Estimated amount
Given Initialize the browser with chrome
And Navigate to ANZ URL 
When User enters details 
And earnings
And expenses
Then Verify that borrowing estimate is succesfully returned
And close browser







