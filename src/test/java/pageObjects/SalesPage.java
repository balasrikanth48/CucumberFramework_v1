package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ultilites.WaitHelper;

public class SalesPage {
	public WebDriver ldriver;
	public WaitHelper waithelper;

	public SalesPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Sales')]")
	WebElement salesMenu;
	@FindBy(xpath = "//a[@href='/Admin/Order/List']//p[contains(text(),'Orders')]")
	WebElement Orders;
	@FindBy(id = "BillingEmail")
	WebElement BillingEmail;
	
	@FindBy(id="search-orders")
	WebElement Search_Order;
	
	@FindBy(xpath="//table[@id='orders-grid']")
	WebElement TableOrders;
	
	@FindBy(xpath="//table[@id='orders-grid']/tbody/tr")
	List<WebElement> OrderListRows;
	
	@FindBy(xpath="//table[@id='orders-grid']/tbody/tr/td")
	List<WebElement> ColumnList;
	
	
	public void clickSalesMenu() {
		
		waithelper.WaitforElement(salesMenu, Duration.ofSeconds(30));
		salesMenu.click();
	}
	
	public void OpenOrdersMenu()
	{
		waithelper.WaitforElement(Orders, Duration.ofSeconds(30));
		Orders.click();
	}
	public void EnterBillingEmail(String email)
	{
		BillingEmail.sendKeys(email);
	}
	
	public void clickOnSearchorder()
	{
		Search_Order.click();
	}
	
	public boolean VerifyOrderStatus(String Shippingstatus)
	{
		boolean flag=false;
		for (int i = 1; i<=OrderListRows.size(); i++) 
		{
			String actualStatus=TableOrders.findElement(By.xpath("//table[@id='orders-grid']/tbody/tr["+i+"]/td[5]")).getText();
			if (actualStatus.equals(Shippingstatus)) 
			{
				flag =true;
			}
		}
		return flag;
		
	}
	
	
}
