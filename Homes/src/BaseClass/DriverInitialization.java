package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInitialization {
	
	public WebDriver driver;
	
@BeforeMethod
	public void commonSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("Chrome Browser is Invoked");
	}

@AfterMethod 
	public void tearDown() {
	driver.quit();	
	}
}
