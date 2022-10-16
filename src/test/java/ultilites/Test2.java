package ultilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		com.aventstack.extentreports.ExtentReports extentrep = new com.aventstack.extentreports.ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter extentspark = new ExtentSparkReporter(file);
		extentrep.attachReporter(extentspark);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https:/www.google.com");
		
		String base64=getScreenShot();
		String path=getScreenShot("logo.png");
		extentrep.createTest("Attcheing the Screenshot").info("This is info msg").addScreenCaptureFromBase64String(base64);
		
		extentrep.createTest("Attcheing the Screenshot2").info("This is info msg").addScreenCaptureFromBase64String(path);
		extentrep.flush();
	}

	public static String getScreenShot() {
		String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return ss;

	}
	public  static String getScreenShot(String defectname) throws IOException
	{
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/" +defectname);
		FileUtils.copyFile(ss, dest);
		
		return dest.getAbsolutePath();
	}

}
