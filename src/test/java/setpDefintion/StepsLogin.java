package setpDefintion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SerchCustomerPage;


@SuppressWarnings("deprecation")
public class StepsLogin extends BaseClass
{
	//public AddCustomerPage Addcust;
	
	@Before
	public void setup() throws IOException
	{
		
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		
	}
	
	@Given("user launches chrome browser")
	public void user_launches_chrome_browser() 
	{
	  
	  scp=new SerchCustomerPage(driver);
	  lp=new LoginPage(driver);
	  
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) 
	{
	    driver.get(url);
	}

	@When("user enter username as {string} and password as {string}")
	public void user_enter_username_as_and_password_as(String Uname, String Password) 
	{
	   lp.setUserName(Uname);
	   lp.setPassword(Password);
	}

	@When("click login")
	public void click_login() throws InterruptedException 
	{
	    lp.clickLogin();
	    
	    Thread.sleep(3000);
	}

	@SuppressWarnings("deprecation")
	@Then("log in page Title should be {string}")
	public void log_in_page_title_should_be(String Title) 
	{
	  if (driver.getPageSource().contains("Login was unsuccessful")) 
	  {
		driver.close();
		Assert.assertTrue(false);
		
	  }else
	  {
		  Assert.assertEquals(Title, driver.getTitle());
	  }
	}

	@When("clcik on logout")
	public void clcik_on_logout() throws InterruptedException 
	{
	    lp.clickLogout();
	    Thread.sleep(3000);
	}
	@SuppressWarnings("deprecation")
	@Then("logout page Title should be {string}")
	public void logout_page_title_should_be(String logouttitle)
	{
	   if (driver.getTitle().equals(logouttitle)) 
	   {
		   Assert.assertTrue(true);
	}
	   else
	   {
		   Assert.assertTrue(false);
	   }
	}
	
	//Addcustomer
	@SuppressWarnings("deprecation")
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() 
	{
		Addcust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", Addcust.getPageTitle());
	}
	@When("user click on Customer menu")
	public void user_click_on_customer_menu() 
	{
		Addcust.clickOnCustomerMenu();  
	}
	@When("click on customer  Menu item")
	public void click_on_customer_menu_item() 
	{
		Addcust.clickonCustomerMenuItem();  
	}
	@When("click on add new customer")
	public void click_on_add_new_customer()
	{
		Addcust.clickonAddnew();  
	}
	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page()
	{
		Assert.assertEquals("Add a new customer / nopCommerce administration", Addcust.getPageTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException
	{
		String email=RandomEmail()+"@gmail.com";
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
	}
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException 
	{
		Addcust.clicksave();
	   Thread.sleep(3000);
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmationmsg)
	{
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
	
	@When("enter customer  email")
	public void enter_customer_email() 
	{
		
		scp.setEmail("kswathi@gmail.com");
	   
	}
	@When("click on Search button")
	public void click_on_search_button() throws InterruptedException
	{
	    scp.searchcustomer();
	    Thread.sleep(3000);
	}
	@Then("user Should found email in the Search tabele")
	public void user_should_found_email_in_the_search_tabele()
	{
	  boolean status=  scp.searchcustomerbyEmail("kswathi@gmail.com");
	  Assert.assertEquals(true, status);
	}

	@When("Enter customer firstname")
	public void enter_customer_firstname()
	{
		scp=new SerchCustomerPage(driver);
		scp.setFirstname("Victoria");
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() 
	{
	    scp.setLastname("Terces");
	}

	@Then("user should found customer name in the table")
	public void user_should_found_customer_name_in_the_table() 
	{
	  boolean status=scp.searchByName("Victoria Terces");
		Assert.assertEquals(true,status);	
	}


	@Then("close the browser")
	public void close_the_browser() 
	{
	   driver.close();
	}
	
	
	
	
}
