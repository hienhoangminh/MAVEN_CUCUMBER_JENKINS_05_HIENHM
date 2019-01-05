@payment
Feature: Payment feature
  As tester,
  I want to test payment feature
  To ensure that it works correctly

  Scenario: Common step
    # ----------- ACTION -----------#
    #Textbox
    And I input to "" textbox with data ""
    # 0 = fix data | 1 = random data
    And I input to "" textbox with "0" data ""
    #Textarea
    And I input to "" textarea with data ""
    #Dropdown
    And I select item in "" dropdown with data ""
    #Radiobutton
    And I select "" radio button
    #Link
    And I open "" page
    # Button
    And I click on "" button
    
    #Regex
    And I input to (edit_customer|new_account|deposit|withdrawal|transfer|balance_enquiry) "" textbox
    
    #Alert
    And I click (first|second) times to accept button on (del_aacount|del_user) alert
    And I click again to accept button on (del_aacount|del_user) alert
    
    #Text
    And I can get "" value
    
     # ----------- WAIT -----------#
    #And I sleep for 7 seconds
    
    
    # ----------- VERIFY -----------#
    And Verify message "" is displayed
    And Verify actual value is the same as expected value ""
    And Verify message "" is displayed with "0" data AccountId info
    And Verify actual (new_account|deposit|withdrawal|transfer) value is the same as expected value \"([^\"]*)\"
    And Verify alert message "" is displayed 
    
    
    
    
