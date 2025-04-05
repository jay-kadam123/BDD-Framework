Feature: Add to cart page

Scenario: to test add to cart page
 Given User launch ChromeBrowser
 When user opens URL "https://demoblaze.com/index.html"
 And  click on loginbutton
 And User enter Username as "ka1ka12" and Password as "123456"
 And click on login
Then user will view Dashboard "STORE"
When User click on product
And click on add to cart
And go to the cartlisting
Then product will list
When User click on Place order
And enter Customer data
Then Order will placed "Thank you for your purchase!"
And click on ok button