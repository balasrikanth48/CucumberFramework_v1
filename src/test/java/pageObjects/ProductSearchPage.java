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

public class ProductSearchPage {
	public WebDriver ldriver;
	public WaitHelper waithelper;

	public ProductSearchPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Catalog')]")
	WebElement CatlogMenu;

	@FindBy(xpath = "//a[@href='/Admin/Product/List']//p[contains(text(),' Products')]")
	WebElement ProductsMenu;

	@FindBy(xpath = "//input[@id='SearchProductName']")
	WebElement ProductName;

	@FindBy(xpath = "//button[@id='search-products']")
	WebElement SearchButton;

	@FindBy(xpath = "//table[@id='products-grid']")
	WebElement Table;

	@FindBy(how=How.XPATH , using="//table[@id='products-grid']//tbody//tr")
	List<WebElement> rows;

	@FindBy(xpath = "//table[@id='products-grid']//tbody//tr/td")
	List<WebElement> column;

	public void clickOnCatlogMenu() {
		waithelper.WaitforElement(CatlogMenu, Duration.ofSeconds(30));
		CatlogMenu.click();

	}
	
	public void productMenu()
	{
		waithelper.WaitforElement(CatlogMenu, Duration.ofSeconds(30));
		ProductsMenu.click();
	}
	
	public void enterProductName(String Productname)
	{
		waithelper.WaitforElement(CatlogMenu, Duration.ofSeconds(30));
		ProductName.sendKeys(Productname);
		
	}
	
	public void clickOnSearchButton()
	{
		SearchButton.click();
	}
	
	public int CountOfRows()
	{
		System.out.println("no of rows :"+rows.size());
		return(rows.size());
	}
	
	public boolean verifyTable(String ProductName)
	{
		System.out.println(ProductName);
		boolean flag = false; 
		for (int i = 1; i <=CountOfRows(); i++) {
			waithelper.WaitforElement(Table, Duration.ofMillis(3000));
			String name=Table.findElement(By.xpath("//table[@id='products-grid']//tbody//tr["+i+"]/td[4]")).getText();
			System.out.println("name  :"+ name);
			if (name.equals(ProductName)) 
			{
				
				System.out.println("name :"+name);
				flag = true;
			}
		}
			
		
		return flag;
	}

}
