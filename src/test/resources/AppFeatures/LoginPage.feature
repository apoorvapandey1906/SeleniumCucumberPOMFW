
Feature: Login Page Feature

@Smoke
Scenario: Login Page Title
 Given User is on login page
 When User gets the title of the page
 Then page title should be "Login - My Shop"

@Smoke
Scenario: Forgot password link
 Given User is on login page
 Then Forgot your password link should be displayed
 
 @Smoke @Skip
 Scenario: Login with correct credentials
 Given User is on login page
 When User enters username "apandey@gmail.com"
 And User enters password "Going@123"
 And User clicks on Sign In button
 Then User gets the title of the page
 And page title should be "My account - My Shop"