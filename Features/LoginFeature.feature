Feature: Login

@Sanity
Scenario: Successful Login with Valid Credentials 
 Given User launch ChromeBrowser
 When user opens URL "https://demoblaze.com/index.html"
 And  click on loginbutton
 And User enter Username as "ka1ka12" and Password as "123456"
 And click on login
 When User click on logout button
Then page will logout
And Browser will close

@Regression
 Scenario Outline:Successful Login with Valid Credentials with DDT
 Given User launch ChromeBrowser
 When user opens URL "https://demoblaze.com/index.html"
 And  click on loginbutton
 And User enter Username as "<Username>" and Password as "<password>"
 And click on login
 Then user will view Dashboard "STORE"
 When User click on logout button
Then page will logout
And Browser will close

Examples:
|Username|password|
|ka1ka10|123456|
|ka1ka11|123456|

