package PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;

public class PrimaryPage extends BasePage {
    //constructor
	public PrimaryPage(WebDriver driver) {
		super(driver);
	}
	
	//finding element
	
	//Selecting New Bikes
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikesEle;

	//Selecting Upcoming Bikes 
	@FindBy(xpath = "//span[normalize-space()='Upcoming Bikes']")
	public WebElement upcomingBikes;

	
	//Hover to new bikes element And Click
	public void clickNewBikes() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(NewBikesEle).perform();
		Thread.sleep(3000);
	}
	
	//Click Action on upcoming Bikes
	public void selectUpcomingBikes() throws IOException {
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(upcomingBikes).perform();
		
		//ScreenShot for UpcomingBikes by Calling BaseClass method
		new BaseClass().screenshot("UpcomingBike");
		
		//Clicking on upcomingBikes 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", upcomingBikes);
	}
};
