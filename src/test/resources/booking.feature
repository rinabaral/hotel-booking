Feature: Booking a hotel room in a website
    Scenario: Booking a room successfully
        Given I navigate to the booking page
        Then I see the welcome message
        When I enter check in and check out date
        And I click the check availability button
        And I select the double room
        When I click on reserve now button
        When I enter booking details
        Then I should see success message "Book This Room"

        