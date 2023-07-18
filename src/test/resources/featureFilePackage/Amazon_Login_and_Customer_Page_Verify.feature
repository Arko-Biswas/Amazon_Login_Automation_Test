@Amazon_Login
Feature: Amazon Login

  Scenario Outline: Login into Amazon and verifying customer page
    Given I am on Amazon website
    When I click on Hello! Sign In link at the top-right corner
    And I am navigated to Amazon Sign-In page
    And I get Amazon Sign-In details from excel data sheet with sheetname "<SheetName>" and row-number <RowNumber>
    Then I place my username or phone number and click on Continue button
    And I am navigated to password input page and verify page
    Then I place my password and tick keep me signed in and click on Sign in button
    And I verify my Amazon account is logged in

    Examples: 
      | SheetName    | RowNumber |
      | LoginDetails |         0 |
