Feature: register into moneygaming site

  Background:
    Given I open moneygaming site

  @FunctionalTest
  Scenario Outline: To Validate error message for DOB field

    When User click on JoinNow
    Then User Selected Title as <title>
    And User Enter Firstname as  <firstName>
    And User Enter Surname as <lastName>
    And User selected I accept the Terms and Conditions and certify that I am overthe age of 18
    Then User click on JoinNowReg
    And Verify system is displaying error message"This field is required"




    Examples:
      | title | firstName | lastName |
      | Mr    | Venu      | Linga    |
      | Ms    | Sara      | Smith    |
      | Mrs   | Lara      | Smith    |
      | Miss  | Julie     | Smith    |

