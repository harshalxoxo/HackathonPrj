package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{
	
	//constructor
	public SignupPage(WebDriver driver) {
		super(driver);
	}

	//find elements
	//Zigwheels  Logo link Click on Link
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a")
	public WebElement zigwheels;
	
	//Login/SignUp Button Element
	@FindBy(xpath = "//div[@id='des_lIcon']")
	public WebElement loginSignUpButton;
	
	//Login with google Button
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement loginWithGoogleButton;
	
	//Click on Zigwheels
	public void clickZigwheels() {
		zigwheels.click();
	}
	
	//Click on Login/SignUp button 
	public void clickLoginSignUp() {
		loginSignUpButton.click();
	}
	
	//Click on Sign in with Google
	public void selectGoogleButton() {
		loginWithGoogleButton.click();
	}
	
}
