Feature: Account Page Feature

  Background: 
    Given User has already logged in to application
      | Username          | Password  |
      | apandey@gmail.com | Going@123 |

  Scenario: Account Page title
    Given User is on Accounts page
    When User gets the title of the page
    Then page title should be "My account - My Shop"

  Scenario: Account section count
    Given User is on Accounts page
    Then User gets account section
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | Home                      |
    And Account section count should be 6
