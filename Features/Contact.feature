Feature: Contact page
Background: 
 Given User launch ChromeBrowser
 When user opens URL "https://demoblaze.com/index.html"
 And  click on loginbutton
 And User enter Username as "ka1ka12" and Password as "123456"
 And click on login
Then user will view Dashboard "STORE"

@Sanity
Scenario: to test contact page
When user click on contact
And enter contact details
And click on Send Message button
Then page will logout
And Browser will close

@Regression
Scenario: to test contact page with Name
When user click on contact
And enter contact details with name
And click on Send Message button
Then page will logout
And Browser will close