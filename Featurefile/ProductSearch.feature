Feature: ProductSearchFeature 

@sanity 
Scenario: Search the Product in list 

	Given user launches chrome browser 
	When  user opens url "https://admin-demo.nopcommerce.com/login" 
	And user enter username as "admin@yourstore.com" and password as "admin" 
	And click login 
	Then click on CatlogMenu 
	And click on SearchButton for Product 
	#When user enter the Product name "Digital Storm VANQUISH 3 Custom Performance PC" 
	Then user should be able to the item in list "DS_VA3_PC" 
	And close the browser 
	