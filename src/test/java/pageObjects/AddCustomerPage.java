package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage 
{
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	By link_customerMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By linkCustomer_menuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	By Email= By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtCustomerRole=By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By listItmAdmistrator=By.xpath("//li[contains(text(),'Administrators')]");
	By listItmRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By listItmGuest=By.xpath("//li[contains(text(),'Guests')]");
	By listItmVendor=By.xpath("//li[contains(text(),'Vendors')]");
	By listItmRobot=By.xpath("//li[contains(text(),'Robot')]");
	By drpmgrOfVendor=By.xpath("//select[@id='VendorId']");
	By rdGenderMale=By.xpath("//input[@id='Gender_Male']");
	By rdGenderFemale=By.id("Gender_Female");
	By DOB=By.xpath("//input[@id='DateOfBirth']");
	By txtCompany=By.xpath("//input[@id='Company']");
	By txtAdminContext=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(link_customerMenu).click();
	}
	
	public void clickonCustomerMenuItem()
	{
		ldriver.findElement(linkCustomer_menuItem).click();;		
	}
	
	public void clickonAddnew()
	{
		ldriver.findElement(btnAddNew).click();;
	}
	
	public void email(String email)
	{
		ldriver.findElement(Email).sendKeys(email);;
		
	}
	
	public void password(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);;
		
	}
	
	public void customerrole(String role) throws InterruptedException
	{
		if (!role.equals("Vendors")) 
		{
			ldriver.findElement(By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']"));
		}
		ldriver.findElement(txtCustomerRole).click();
		
		WebElement listItem;
		Thread.sleep(3000);
		
		if (role.equals("Admistrators"))
		{
			listItem=ldriver.findElement(listItmAdmistrator);
		}else if(role.equals("Guests")) 
		{
			listItem=ldriver.findElement(listItmGuest);
			
		}else if(role.equals("Registered"))
		{
			listItem=ldriver.findElement(listItmRegistered);
		}else if(role.equals("Vendors"))
		{
			listItem=ldriver.findElement(listItmVendor);
		}else 
		{
			listItem=ldriver.findElement(listItmRobot);
		}
		listItem.click();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listItem);
	}
	
	
	public void setManagerofVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGendor(String gender)
	{
		if (gender.equals("Male")) 
		{
			ldriver.findElement(rdGenderMale).click();
		}else if (gender.equals("Female"))
		{
			ldriver.findElement(rdGenderFemale).click();
		}else
		{
			ldriver.findElement(rdGenderMale).click();
		}
		
	}
	public void setFirstname(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setPassword(String pword)
	{
		ldriver.findElement(txtPassword).sendKeys(pword);
	}
	public void setLastName(String Lname)
	{
		ldriver.findElement(txtLastName).sendKeys(Lname);
	}
	
	public void setDOB(String dob)
	{
		ldriver.findElement(DOB).sendKeys(dob);
	}
	
	public void companyName(String cpamy)
	{
		ldriver.findElement(txtCompany).sendKeys(cpamy);
	}
	
	
	public void setcustomercontext(String context)
	{
		ldriver.findElement(txtAdminContext).sendKeys(context);
	}
	
	public void clicksave()
	{
		ldriver.findElement(btnSave).click();
	}
}
