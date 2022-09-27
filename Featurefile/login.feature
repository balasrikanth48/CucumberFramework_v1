Feature: Login

@sanity
Scenario: Successful login with valid credentials

	Given user launches chrome browser
	When  user opens url "https://admin-demo.nopcommerce.com/login"
	And user enter username as "admin@yourstore.com" and password as "admin"
	And click login
	Then log in page Title should be "Dashboard / nopCommerce administration"
	When clcik on logout 
	Then logout page Title should be "Your store. Login"
	And close the browser
	