package Utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import PageObject.BasePage;

public class WindowHandel extends BasePage {
	public WindowHandel(WebDriver driver) {
		super(driver);
	}
	
	//Implementing window Handling
	public boolean windowNavigate(String WebsiteTitle) {
		Set<String> window = driver.getWindowHandles();
		for(String id : window) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if(title.equals(WebsiteTitle)) {
				return true;
			}
		}
		return false;
	}
}
