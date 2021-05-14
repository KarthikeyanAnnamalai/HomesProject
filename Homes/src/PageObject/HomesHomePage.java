package PageObject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomesHomePage {

	WebDriver driver;
	String searchId = "autocomplete-search";
	String dropDown = "//*[@id=\"masthead\"]/div/homes-search/div/div[2]/div[1]/div[1]";
	String navigatedPageText = "//homes-drawer/div[1]/div[2]/h2";
	String actualNavigatedPageText;

	public HomesHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void geturl(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.MILLISECONDS);
	}

	public void enterValueInSearchBox(String search) {
		WebElement searchBox = driver.findElement(By.id(searchId));
		Reporter.log("Search Box is Located");
		searchBox.sendKeys(search);
		Reporter.log("Value Entered in Search Field is :" + search);
	}

	public void clickOnDropDown(String search) {
		WebElement searchDropDown = driver.findElement(By.xpath(dropDown));
		Reporter.log("Value from the Search Drop down is selected ");
		searchDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(navigatedPageText))));
		actualNavigatedPageText = driver.findElement(By.xpath(navigatedPageText)).getText();
	}

	public void expectedOutput(String expectedNavigationText) {
		if (actualNavigatedPageText.contains(expectedNavigationText)) {
			Assert.assertTrue(true, "Search Result is Correct");
			Reporter.log("Search Result Page Navigation is Successful");
		} else {
			Assert.assertTrue(false, "Search Result is Incorrect");
			Reporter.log("Search Result Page Navigation is UnSuccessful");
		}

	}
}
