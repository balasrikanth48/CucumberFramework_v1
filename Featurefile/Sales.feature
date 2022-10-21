Feature: SalesPage 

Scenario: Order Status 
	Given  user launches chrome browser 
	When   user opens url "https://admin-demo.nopcommerce.com/login" 
	And  user enter username as "admin@yourstore.com" and password as "admin" 
	And  click login 
	Then click on salesMenu 
	And click Ordes 
	And Enter billingEmail Adress "victoria_victoria@nopCommerce.com" 
	And click On SearchonOrderList 
	And user should able to see the list
	And close the browser