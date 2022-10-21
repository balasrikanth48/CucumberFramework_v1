package setpDefintion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.SalesPage;
import pageObjects.SerchCustomerPage;
import ultilites.ExtentReportstest;

@SuppressWarnings("deprecation")
public class StepsLogin extends BaseClass {
	// public AddCustomerPage Addcust;

	@Before
	public void setup() throws IOException {

		configprop = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		configprop.load(configfile);
		logger = LogManager.getLogger(this.getClass());
		reports = new ExtentReportstest();

		WebDriverManager.chromedriver().setup();
		String br = configprop.getProperty("browser");
		if (br.equals("chrome")) {
			logger.info("-----------Chrome Browser is launching---------");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (br.equals("firefox")) {
			logger.info("------------Firefox is Launching--------------");
			driver = new FirefoxDriver();

		}

		logger.info("---------Launching the Browser----------");

	}

	@Given("user launches chrome browser")
	public void user_launches_chrome_browser() {

		scp = new SerchCustomerPage(driver);
		lp = new LoginPage(driver);

	}

	@When("user opens url {string}")
	public void user_opens_url(String url) throws InterruptedException {
		logger.info("---------Opening Application-----------");
		driver.get(url);
		// wait.WaitforElement(Duration.ofSeconds(3000));
		Thread.sleep(3000);
	}

	@When("user enter username as {string} and password as {string}")
	public void user_enter_username_as_and_password_as(String Uname, String Password) {
		logger.info("----------Proving the  Credentials-----");
		lp.setUserName(Uname);
		lp.setPassword(Password);
	}

	@When("click login")
	public void click_login() throws InterruptedException {
		logger.info("------clicking the logi in button----------");
		lp.clickLogin();

		Thread.sleep(3000);
	}

	@SuppressWarnings("deprecation")
	@Then("log in page Title should be {string}")
	public void log_in_page_title_should_be(String Title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("----- login is pass---");
			Assert.assertTrue(false);
			SoftAssert asser = new SoftAssert();
			asser.assertAll();

		} else {
			Assert.assertEquals(Title, driver.getTitle());
		}
	}

	@When("clcik on logout")
	public void clcik_on_logout() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
		logger.info("---------clicked the logout button----------");
	}

	@SuppressWarnings("deprecation")
	@Then("logout page Title should be {string}")
	public void logout_page_title_should_be(String logouttitle) {
		if (driver.getTitle().equals(logouttitle)) {
			Assert.assertTrue(true);
			logger.info("---------------Getting the title of the page-----------");
		} else {
			Assert.assertTrue(false);
		}
	}

	// Addcustomer
	@SuppressWarnings("deprecation")
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
		logger.info("-------------Add a customer page is started------");
		Addcust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", Addcust.getPageTitle());
	}

	@When("user click on Customer menu")
	public void user_click_on_customer_menu() {

		Addcust.clickOnCustomerMenu();
		logger.info("clicked the customermenu");
	}

	@When("click on customer  Menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Addcust.clickonCustomerMenuItem();
		logger.info("clicked the customermenuItem");
	}

	@When("click on add new customer")
	public void click_on_add_new_customer() {
		Addcust.clickonAddnew();
		logger.info("clicked on add new customer");
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", Addcust.getPageTitle());
		logger.info("Varifying the tittle of the page");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = RandomEmail() + "@gmail.com";
		Addcust.email(email);
		Addcust.setPassword("Test123");

		Addcust.customerrole("Guests");
		Thread.sleep(3000);

		Addcust.setManagerofVendor("Vendor 2");
		Addcust.setGendor("Male");
		Addcust.setFirstname("Srikanth");
		Addcust.setLastName("Panchala");
		Addcust.setDOB("4/22/1993");
		Addcust.companyName("Automation");
		Addcust.setcustomercontext("New user");

		logger.info("Added the details of the new customer");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		Addcust.clicksave();
		logger.info("Clicked the save button");
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmationmsg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

		logger.info("Verifying the customer details added");
	}

	@When("enter customer  email")
	public void enter_customer_email() {

		scp.setEmail("Balhy@gmail.com");
		logger.info("Entering the customer email id");

	}

	@When("click on Search button")
	public void click_on_search_button() throws InterruptedException {
		scp.searchcustomer();
		logger.info("Clicking the search button");
		Thread.sleep(3000);
	}

	@Then("user Should found email in the Search tabele")
	public void user_should_found_email_in_the_search_tabele() {
		boolean status = scp.searchcustomerbyEmail("Balhy@gmail.com");

		Assert.assertEquals(false, status);

		logger.info("verifying the Serch sutomer list");
	}

	@When("Enter customer firstname")
	public void enter_customer_firstname() {
		scp = new SerchCustomerPage(driver);
		scp.setFirstname("Srikanth");
		logger.info("Entering the customer first name");
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() {
		scp.setLastname("Panchala");
		logger.info("Entering the Last name");
	}

	@Then("user should found customer name in the table")
	public void user_should_found_customer_name_in_the_table() {
		boolean status = scp.searchByName("Srikanth Panchala");

		Assert.assertEquals(true, status);
		logger.info("Verifying the customer name in the table");
	}

	@Then("click on CatlogMenu")
	public void click_on_catlog_menu() {
		logger.info("Clicking on CatlogMenu");
		ProductSearch=new ProductSearchPage(driver);
		ProductSearch.clickOnCatlogMenu();
	}

	@Then("click on SearchButton for Product")
	public void click_on_search_button_for_product() {
		
		logger.info("Clicking on Productpage");
		ProductSearch.productMenu();
	}

	@When("user enter the Product name {string}")
	public void user_enter_the_product_name(String ProductName) {
		logger.info("Entering the Product name");
		//ProductSearch.enterProductName(ProductName);
		ProductSearch.clickOnSearchButton();
	}

	@Then("user should be able to the item in list {string}")
	public void user_should_be_able_to_the_item_in_list(String name)
	{
		logger.info("Validating the table");
		
		System.out.println(name);
		
		boolean verifySatus=ProductSearch.verifyTable(name);
		System.out.println(verifySatus);
		Assert.assertEquals(true, verifySatus);
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		logger.info("Closing the browser");
	}
	@Then("click on salesMenu")
	public void click_on_sales_menu() {
		
		logger.info("Clicking on salesMenu");
	    salespage=new SalesPage(driver);
	    salespage.clickSalesMenu();
	    
	}
	@Then("click Ordes")
	public void click_ordes() {
		logger.info("Clicking on Orders");
	   salespage.OpenOrdersMenu();
	}
	@Then("Enter billingEmail Adress {string}")
	public void enter_billing_email_adress(String Email) 
	{
		logger.info("Entering on the email address");
	 salespage.EnterBillingEmail(Email);  
	}
	@Then("click On SearchonOrderList")
	public void click_on_searchon_order_list() {
		logger.info("Showing the list of Orders list");
	  salespage.clickOnSearchorder();
	}
	@Then("user should able to see the list")
	public void user_should_able_to_see_the_list() {
		logger.info("Validating the Orders list");
	   boolean status=salespage.VerifyOrderStatus("Delivered");
	   Assert.assertEquals(true, status);
	}


	@AfterStep
	public void addScreenshot(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshot, "image/jpeg", screenshotName);
		}

	}

}
