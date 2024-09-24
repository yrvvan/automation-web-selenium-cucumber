Feature: QA Engineer Job Application

    Scenario: Successful apply for QA Engineer
        Given User is on the Main page
        When User click Apply now
        And User fulfill with "Valid" Personal data
        And User upload CV
        And User add cover letter
        And User submit the application
        Then Application submitted successfully

    Scenario: Failed apply for QA Engineer
        Given User is on the Main page
        When User click Apply now
        And User fulfill with "Invalid" Personal data
