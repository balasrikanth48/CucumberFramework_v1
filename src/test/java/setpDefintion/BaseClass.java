package setpDefintion;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SerchCustomerPage;

public class BaseClass 
{
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage Addcust;
	public SerchCustomerPage scp;
	public static java.util.logging.Logger logger;
	public static Properties configprop;
	
	
	
//Random email 
	public static String RandomEmail()
	{
		
		String generatstring=RandomStringUtils.randomAlphabetic(5);
		return generatstring;
	}

	//


}
