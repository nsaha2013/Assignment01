Feature: Comment on Blog Posts - start the journey with a logged in user

  Background:
    Given I am on BBC blogpage and I am already signed in as "bbctestuser01@mailinator.com":"Password123"

  Scenario: Successfully comment on a blog
    And I click on comments link
    And I see the welcome message "You are signed in as Automation QA"
    And I enter the comment as "Test comment by Automation QA"
    And I click on Post Comment button
    Then I see the Post comment success message is displayed

  Scenario: Cannot post an empty comment
    And I click on comments link
    And I see the welcome message "You are signed in as Automation QA"
    And I click on Post Comment button
    Then I see the Post comment error message is displayed