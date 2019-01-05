@paymentv2
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

  @new_customer
  Scenario Outline: Create New Customer
    Given I open "New Customer" page
    When I input to "name" textbox with data "<Name>"
    And I select "<Gender>" radio button
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with "2" data "<Email>"
    And I input to "password" textbox with data "<Password>"
    And I click on "Submit" button
    Then Verify message "<NewCustomerMessage>" is displayed
    And I can get customerId info

    Examples: New Customer info
      | Name      | Gender | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password | NewCustomerMessage                  |
      | Auto Test | m      | 01/01/1989  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987654321 | autotest |   123123 | Customer Registered Successfully!!! |

  @edit_customer
  Scenario Outline: Edit the customer
    Given I open "Edit Customer" page
    When I input to edit_customer "cusid" textbox
    And I click on "Submit" button
    And I input to "addr" textarea with data "<NwAddress>"
    And I input to "city" textbox with data "<NwCity>"
    And I input to "state" textbox with data "<NwState>"
    And I input to "pinno" textbox with data "<NwPin>"
    And I input to "telephoneno" textbox with data "<NwPhone>"
    And I input to "emailid" textbox with "2" data "<NwEmail>"
    And I click on "Submit" button
    Then Verify message "<EditCustomerMessage>" is displayed

    Examples: Edit Customer info
      | NwAddress  | NwCity      | NwState | NwPin  | NwPhone    | NwEmail  | EditCustomerMessage                      |
      | 456 Le Loi | Ho Chi Minh | Thu Duc | 654321 | 0987654321 | autotest | Customer details updated Successfully!!! |

  @new_account
  Scenario Outline: Create new account
    Given I open "New Account" page
    When I input to new_account "cusid" textbox
    And I select item in "selaccount" dropdown list with data "<Type>"
    And I input to "inideposit" textbox with data "<Amount>"
    And I click on "submit" button
    Then Verify message "<NewAccountMessage>" is displayed with "0" data AccountId info
    And Verify actual new_account value is the same as expected value "<ExpectedAmount>"
    And I can get AccountId info

    Examples: New Account info
      | Amount | Type    | ExpectedAmount | NewAccountMessage                 |
      |  50000 | Current |          50000 | Account Generated Successfully!!! |

  @deposit
  Scenario Outline: Deposit to current account
    Given I open "Deposit" page
    When I input to deposit "accountno" textbox
    And I input to "ammount" textbox with data "<DepositAmount>"
    And I input to "desc" textbox with data "<DepositReason>"
    And I click on "Submit" button
    Then Verify message "<DepositMessage>" is displayed with "1" data AccountId info
    And Verify actual deposit value is the same as expected value "<ExpectedAmountAfterDeposit>"

    Examples: Deposit info
      | DepositAmount | DepositReason | DepositMessage                             | ExpectedAmountAfterDeposit |
      |          5000 | deposit       | Transaction details of Deposit for Account |                      55000 |

  @withdrawal
  Scenario Outline: Withdrawal from to current account
    Given I open "Withdrawal" page
    When I input to withdrawal "accountno" textbox
    And I input to "ammount" textbox with data "<WithdrawalAmount>"
    And I input to "desc" textbox with data "<WithdrawalReason>"
    And I click on "Submit" button
    Then Verify message "<WithdrawalMessage>" is displayed with "1" data AccountId info
    And Verify actual withdrawal value is the same as expected value "<ExpectedAmountAfterWithdrawal>"

    Examples: Deposit info
      | WithdrawalAmount | WithdrawalReason | WithdrawalMessage                             | ExpectedAmountAfterWithdrawal |
      |            15000 | withdrawal       | Transaction details of Withdrawal for Account |                         40000 |

  @transfer
  Scenario Outline: Transfer from to one account to current account
    Given I open "Fund Transfer" page
    When I input to fund_transfer "payersaccount" textbox
    And I input to "payeeaccount" textbox with data "<PayersAccount>"
    And I input to "ammount" textbox with data "<TransferAmount>"
    And I input to "desc" textbox with data "<TransferReason>"
    And I click on "Submit" button
    Then Verify message "<TransferMessage>" is displayed with "0" data AccountId info
    And Verify actual withdrawal value is the same as expected value "<ExpectedAmountAfterWithdrawal>"

    Examples: Deposit info
      | PayersAccount | TransferAmount | TransferReason | TransferMessage       | ExpectedAmountAfterWithdrawal |
      |         55001 |          10000 | transfer       | Fund Transfer Details |                         10000 |

  @balance_enquiry
  Scenario Outline: Check the balance enquiry
    Given I open "Balance Enquiry" page
    When I input to balance_enquiry "accountno" textbox
    And I click on "Submit" button
    Then Verify message "<EnquiryMessage>" is displayed with "1" data AccountId info
    And Verify actual withdrawal value is the same as expected value "<ExpectedAmountAfterEnquiry>"

    Examples: Balance enquiry info
      | EnquiryMessage              | ExpectedAmountAfterEnquiry |
      | Balance Details for Account |                      30000 |

  @delete_account
  Scenario Outline: Delete account
    Given I open "Delete Account" page
    When I input to del_acc "accountno" textbox
    And I click on "Submit" button
    And I click first times to accept button on del_acc alert
    Then Verify alert message "<DeleteAccountMessage>" is displayed
    And I click again to accept button on del_acc alert

    Examples: Delete account info
      | DeleteAccountMessage            |
      | Account Deleted Successfully!!! |

  @delete_user
  Scenario Outline: Delete customer
    Given I open "Delete Customer" page
    When I input to del_user "cusid" textbox
    And I click on "Submit" button
    And I click first times to accept button on del_user alert
    Then Verify alert message "<DeleteUserMessage>" is displayed
    And I click again to accept button on del_user alert

    Examples: Delete user info
      | DeleteUserMessage                |
      | Customer Deleted Successfully!!! |
