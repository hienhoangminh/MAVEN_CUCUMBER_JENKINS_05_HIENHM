#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Login
  As an automation tester
  I want to check login feature
  So that I want to make sure that user can login to the system
  
 Scenario: Login to system without datatable
    Given I navigate to bank guru site
    When I input to username "mngr165832"
    And I input to password "buzEgUt"
    And I click to Login button
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"
    And I close browser


  Scenario Outline: Login to system using datatable
    Given I navigate to bank guru site
    When I input to username "<userID>"
    And I input to password "<userPass>"
    And I click to Login button
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"
    And I close browser
    
  Examples: UserID and UserPass datatable
    |    userID    |    userPass   |
    |  mngr165817  |    AbedusU    |
    |  mngr165832  |    buzEgUt    | 
