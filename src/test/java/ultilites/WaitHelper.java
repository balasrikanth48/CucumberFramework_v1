package ultilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper
{
	public WebDriver driver;
	
	
	public WaitHelper(WebDriver rdriver)
	{
		this.driver=rdriver;
		System.out.println("Workong on New Feature");
		
	}
	
	

	
	public void WaitforElement(WebElement element ,Duration timeOutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void WaitforElement(Duration timeOutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.titleIs("Your store. Login"));
		
	}
}
