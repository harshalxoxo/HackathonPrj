Feature: Identifying New Bikes

  Scenario: Verify the New Upcoming Bikes and Used Cars with Invalid Email
    Given load the browser and ZigsWheel Page
    Then Click on New Bikes and Upcoming bike select honda and get the details of Bikes
    Then Click on Used Cars and select models and Get the model details
    Then Login/signUp to google and give invalid details and capture error message
    And Close the Browser