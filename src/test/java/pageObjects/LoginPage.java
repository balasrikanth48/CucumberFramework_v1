package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;
	
public LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
}

@FindBy(id="Email")
WebElement txtemail;

@FindBy(id="Password")
WebElement txtpassword;

@FindBy(xpath="//button[normalize-space()='Log in']")
WebElement btnLogin;

@FindBy(linkText="Logout")
WebElement btnLogout;
 
public void setUserName(String uname)
{
	txtemail.clear();
	txtemail.sendKeys(uname);
}

public void setPassword(String password)
{
	txtpassword.clear();
	txtpassword.sendKeys(password);
}

public void clickLogin()
{
	btnLogin.click();
}

public void clickLogout() throws InterruptedException
{
	Thread.sleep(3000);
	btnLogout.click();
}
}
