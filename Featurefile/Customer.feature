Feature: Customer

  Background:  Below steps for common for every step
  Given user launches chrome browser
	When  user opens url "https://admin-demo.nopcommerce.com/login"
	And user enter username as "admin@yourstore.com" and password as "admin"
	And click login
	Then user can view Dashboard
	
	
@sanity
Scenario: add New Customer
	
	When user click on Customer menu
	And click on customer  Menu item
	And click on add new customer
	Then user can view add new customer page
	When User enter customer info
	And click on save button
	Then User can view confirmation message "The new customer has been added successfully"
	And close the browser
	
@regression
Scenario: Search Customer by Email
	
	When user click on Customer menu
	And click on customer  Menu item
	And enter customer  email 
	When click on Search button
	Then user Should found email in the Search tabele
	And close the browser
@regression
Scenario: Search customer by name
	
	When user click on Customer menu
	And click on customer  Menu item
	And Enter customer firstname
	And Enter customer Lastname
	When click on Search button
	Then user should found customer name in the table
	And close the browser
