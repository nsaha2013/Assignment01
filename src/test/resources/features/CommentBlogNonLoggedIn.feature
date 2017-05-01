Feature: Comment on Blog Posts - start the journey with non logged in user

  Background:
    Given I am on BBC blogpage and I am not signed in
    And I click on comments link
    And I see the signin and register options are displayed

  Scenario: Successfully comment on a blog with existing user
    And I choose the option to signin
    And I enter username to signin as "bbctestuser01@mailinator.com"
    And I enter password to signin as "Password123"
    And I click on sign in button
    And I click on comments link
    And I see the welcome message "You are signed in as Automation QA"
    And I enter the comment as "Test comment by Automation QA"
    And I click on Post Comment button
    Then I see the Post comment success message is displayed


  Scenario: Cannot Comment on a blog after creating a new user but without verifying the email address
    And I choose the option to register
    And I enter date of birth as "01-01-1985"
    And I click on Next button
    And I enter Email as a valid random email
    And I enter password as "Password123"
    And I enter postcode as "sl1 1er"
    And I select gender as "Male"
    And I choose marketing preference as "optin"
    And I click on Register button
    And I see the registered email address is displayed on the confirmation page
    And I click on continue button on confirmation page
    And I enter display name as "Automation QA"
    And I click on continue button on more info page
    And I click on continue button on Account confirmation page
    And I click on comments link
    Then I see the message "You need to verify your email address before you can comment and rate comments. Check your inbox for the email we sent when you registered. Can't find it?"



