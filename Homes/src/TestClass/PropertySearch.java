package TestClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseClass.DriverInitialization;
import BaseClass.ExcelReader;
import PageObject.HomesHomePage;

public class PropertySearch extends DriverInitialization {

	HomesHomePage homeshomepage;

	@Test(dataProvider = "getData")
	public void navigationTest(String search, String url, String expectedNavigationText) {
		homeshomepage = new HomesHomePage(driver);
		homeshomepage.geturl(url);
		homeshomepage.enterValueInSearchBox(search);
		homeshomepage.clickOnDropDown(search);
		homeshomepage.expectedOutput(expectedNavigationText);
	}

	@DataProvider
	public static Object[][] getData() {
		ExcelReader excel = null;
		if (excel == null) {
			excel = new ExcelReader(System.getProperty("user.dir") + "\\SearchData.xlsx");
		}
		String sheetName = "Search";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

}
