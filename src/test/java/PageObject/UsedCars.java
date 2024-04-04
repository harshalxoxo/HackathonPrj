package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;
import Utils.ExcelUtility;
import Utils.JavaScriptManager;

public class UsedCars extends BasePage {

	ExcelUtility excelUtility = new ExcelUtility();
	JavaScriptManager javaScriptManager = new JavaScriptManager();
	
	//constructor
	public UsedCars(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Selecting Used Cars element
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsElement;

	// Select Chennai Element 
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement usedCarLocation;

	// Locating Popular Models element
	@FindBy(xpath = "//div[text()='Popular Models']")
	WebElement popularModelsElements;

	// Getting List of popular models
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']/ul/li/label")
	List<WebElement> popularModelsList;

	// Checkbox of the popular models
	@FindBy(xpath = "//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	List<WebElement> checkboxOfCars;

	// Locating Brand and Model element
	@FindBy(xpath = "//span[normalize-space()='Brand and Model']")
	WebElement BrandAndModel;

	// Hover and select used cars
	public void selectUsedCars() throws InterruptedException {
		javaScriptManager.scrollToTop(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(usedCarsElement).perform();
		Thread.sleep(3000);
	}

	// Select the used cars location
	public void clickSelectedCar() throws IOException, InterruptedException {
		new BaseClass().screenshot("UsedCarLocation");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", usedCarLocation);
		Thread.sleep(3000);
	}

	// Scroll and click on the popular models
	public void extractPopularModels() throws IOException, InterruptedException {
		System.out.println("Total no of car models:" + checkboxOfCars.size());
		
		excelUtility.setCellData("PopularModels", 0, 0, "PopularModelsList");
		
		javaScriptManager.scrollIntoView(driver, BrandAndModel);
		
		int row = 1;
		/*for (WebElement model : checkboxOfCars) {
			try {
				System.out.println(model.getText());
				excelUtility.setCellData("PopularModels", row, 0, model.getText());
				row++;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		for(int i=0; i<popularModelsList.size(); i++) {
			String modelname = popularModelsList.get(i).getText();
			excelUtility.setCellData("PopularModels", row, 0, modelname);
			row++;
		}
	}
}
