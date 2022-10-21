package setpDefintion;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.SalesPage;
import pageObjects.SerchCustomerPage;
import ultilites.ExtentReportstest;
import ultilites.WaitHelper;

public class BaseClass 
{
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage Addcust;
	public SerchCustomerPage scp;
	public ProductSearchPage ProductSearch;
	public SalesPage salespage;
	public static Properties configprop;
	public static WaitHelper wait;
	public static ExtentReportstest reports;
	public static Logger logger;
	
	
	
//Random email 
	public static String RandomEmail()
	{
		
		String generatstring=RandomStringUtils.randomAlphabetic(5);
		return generatstring;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";

		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
