@demo
Feature: Payment feature
  As tester,
  I want to test payment feature
  To ensure that it works correctly

  @register
  Scenario: Register to the application
    Given I get login page URL
    When I click to here link
    And I input to email textbox with data "online"
    And I click to Submit button
    Then I get UserID info
    And I get password info
    When I open Login page again

  @login
  Scenario: Login to application
    Given I input to UserID textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then verify home page displayed with message "Welcome To Manager's Page of Guru99 Bank"

  #@new_customer
  #Scenario Outline: Create New Customer
    #Given I click to New Customer link
    #And Input to New Customer form with data
      #| Name   | Gender | DateOfBirth | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      #| <Name> | m      | 01/01/1989  | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    #And I click to Submit button at New Customer page
    #Then verify message displayed with text "<Message>"
    #And I verify all above information created successfull
      #| Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   |
      #| <Name> | male   | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    #When I get Customer ID at New Customer page
#
    #Examples: New Customer info
      #| Name      | Gender | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password | Message                             |
      #| Auto Test | m      | 1989-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987654321 | autotest |   123123 | Customer Registered Successfully!!! |
