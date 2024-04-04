package PageObject;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.ExcelUtility;

public class LoginPage extends BasePage {

	ExcelUtility excelUtility = new ExcelUtility();
	
	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//find element
	// locate the google button
	@FindBy(id = "identifierId")
	public WebElement emailInput;

	// Locate the "Next" on the login page
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nextBtn_loc;

	// locate the error message displayed
	@FindBy(xpath = "//div[@class='dEOOab RxsGPe']")//div[@class='dEOOab RxsGPe'] //div[@class='o6cuMc Jj6Lae']
	public WebElement errorMessage;

	// To write invalid account details
	public void setEmailInput() {
		emailInput.sendKeys(randomString() + "@gmail.com");
	}

	// Click the "Next" button
	public void clickNextBtn() throws InterruptedException {
		nextBtn_loc.click();
		Thread.sleep(5000);
	}

	// Extract the error message and display on the console
	public void handleErrorMsg() throws IOException {
		String errorMsg = errorMessage.getText();
		System.out.println("***********************");
		System.out.println(errorMsg);
		excelUtility.setCellData("LoginPage", 0, 0, errorMsg);
	}

	// Generate a random string to type into email input
	public String randomString() {
		//Random String is from apache commons dependency
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
