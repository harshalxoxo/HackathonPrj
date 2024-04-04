package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utils.ExcelUtility;
import Utils.JavaScriptManager;

public class UpcomingBikes extends BasePage {

	JavaScriptManager javaScriptManager = new JavaScriptManager();
	Utils.ExcelUtility excelUtility = new ExcelUtility();
	
	//constructor
	public UpcomingBikes(WebDriver driver) {
		super(driver);
	}
	
	//find elements
	// Clicking on DropDown Manufacture
	@FindBy(id = "makeId")
	public WebElement Manufacturer;

	// View More Bikes Button to view more bikes
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	public WebElement viewMoreBikes;

	// Model names of all the Honda bikes
	@FindBy(css = ".lnk-hvr.block.of-hid.h-height")
	////*[@class='lnk-hvr block of-hid h-height']
	public List<WebElement> modelName;

	// Prices of all the Honda bikes
	@FindBy(xpath = "//li[contains(@class,'modelItem')]")
	public List<WebElement> bikePrice;

	// Launch date of all the Honda bikes
	@FindBy(css = ".clr-try.fnt-14")
	public List<WebElement> dateOfBikes;

	//methods
	// Select Manufacturer Honda and click
	public void clickManufacturer() {
		Manufacturer.click();
		Select s=new Select(Manufacturer);
		s.selectByIndex(3);
	}

	// Locate the  more bikes button and click on it
	public void clickViewMoreButton() throws InterruptedException {
        //Scrolling in to view Elements of Certain Element
		javaScriptManager.scrollIntoView(driver, viewMoreBikes);
		Thread.sleep(3000);
        //Clicking on View More Bikes Button
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", viewMoreBikes);
		Thread.sleep(2000);
	}

	// Get the details of the bikes and store in the excel file
	public void bikeDetails() throws IOException {
		excelUtility.setCellData("UpcomingBike", 0, 0, "BikeName");
		excelUtility.setCellData("UpcomingBike", 0, 1, "Price");
		excelUtility.setCellData("UpcomingBike", 0, 2, "LunchDate");
		int row = 1;
		for (int i = 0; i < modelName.size(); i++) {
			String bikeName = modelName.get(i).getText();
			String launchDate = dateOfBikes.get(i).getText();
			int price = Integer.parseInt(bikePrice.get(i).getAttribute("data-price"));
			if (price < 400000) {
				System.out.println(bikeName + "\n" + price + "\n" + launchDate);
				System.out.println("****************************");
				excelUtility.setCellData("UpcomingBike", row, 0, bikeName);
				excelUtility.setCellData("UpcomingBike", row, 1, price + "");
				excelUtility.setCellData("UpcomingBike", row, 2, launchDate);
				row++;
			}
		}
	}

	
}
