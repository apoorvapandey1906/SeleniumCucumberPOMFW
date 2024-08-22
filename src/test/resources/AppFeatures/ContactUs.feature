Feature: ContactUs Page Feature

  Background: 
    Given User has already logged in to application
      | Username          | Password  |
      | apandey@gmail.com | Going@123 | 


  Scenario: Contact Us Page Title
    Given User navigates to contact Us Page
    When User gets the title of the page
    Then page title should be "Contact us - My Shop"

  Scenario Outline: Contact Us scenario with different set of data
   Given User navigates to contact Us Page
   When User fills the form from the given "<sheetname>" and rowNumber <rowNumber>
   And User clicks on send button
   Then It shows a success message "Your message has been successfully sent to our team."

 Examples:
 |sheetname|rowNumber|
 |contactus|0        |
 |contactus|1        |

