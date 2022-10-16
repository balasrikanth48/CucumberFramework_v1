package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ultilites.WaitHelper;

public class SerchCustomerPage 
{
public WebDriver ldriver;
    WaitHelper waithelper;



	public SerchCustomerPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
		
	}
	
	@FindBy(how=How.ID , using ="SearchEmail")
	WebElement txtemail;
	
	@FindBy(how=How.ID ,using="SearchFirstName")
	WebElement txtfirstname;
	
	@FindBy(how=How.ID ,using="SearchLastName")
	WebElement txtlastname;
	
	@FindBy(how=How.ID ,using="SearchMonthOfBirth")
	WebElement drpmonth;
	
	@FindBy(how=How.ID ,using="SearchDayOfBirth")
	WebElement drpday;
	
	@FindBy(how=How.ID ,using="search-customers")
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH ,using="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how=How.XPATH , using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH , using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tablecolumns;
	
	public void setEmail(String email)
	{
		waithelper.WaitforElement(txtemail, Duration.ofSeconds(3000));
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void setFirstname(String fname)
	{
		waithelper.WaitforElement(txtfirstname, Duration.ofSeconds(3000));
		txtfirstname.clear();
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastname(String fname)
	{
		waithelper.WaitforElement(txtlastname, Duration.ofSeconds(3000));
		txtlastname.clear();
		txtlastname.sendKeys(fname);
	}
	
	public void searchcustomer()
	{
		btnSearch.click();
	}
	public int getNoOfRows()
	{
		return(tableRows.size());
		
	}
	
	public int getNoOfColumn()
	{
		return(tablecolumns.size());
	}
	
	public boolean searchcustomerbyEmail(String Email)
	{
		boolean flag=false;
		for (int i = 1; i <=getNoOfRows(); i++) 
		{
			String Emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
			if (Emailid.equals(Email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchByName(String Name)
	{
		
		boolean flag=false;
		for (int i = 0; i <getNoOfRows(); i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\"+i+\"]/td[3]")).getText();
			System.out.println(name);
			String[] names=name.split("");
			if (name.equals(Name))
			{
				flag=true;
				
			}
		}
		return flag;
		
		
		
	}
	
	
	
	
}
