@Amazon_Login
Feature: Amazon Login

  ####      This scenario also has hovering and clicking on elements that disappear  ####
  Scenario Outline: Login into Amazon and verifying customer page
    Given I am on Amazon website
    And I scroll down till the bottom and click Your Account
    When I click on Hello! Sign In link at the top-right corner
    And I am navigated to Amazon Sign-In page
    ## <-- in below step, I'm taking data from EXCEL file
    #And I get Amazon Sign-In details from excel data sheet with sheetname "<SheetName>" and row-number <RowNumber>
    ## <-- in below step, I'm taking data from JSON file
    And I get Amazon Sign-In for user "<Name>" details from JSON file
    Then I place my username or phone number and click on Continue button
    And I am navigated to password input page and verify page
    Then I place my password and tick keep me signed in and click on Sign in button
    And I verify my Amazon account is logged in
    Then I hover on the Account & Lists! button and Click on sign out button
    Then I verify that I have successfully signed out

    Examples: 
      | Name |
      | yourName |
      #| SheetName    | RowNumber |
      #| LoginDetails |         0 |
      ## remember to put your login details in the amazonLoginTestData.xlsx file
