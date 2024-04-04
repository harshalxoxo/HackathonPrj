package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.SignupPage;
import TestBase.BaseClass;

public class TC_003_GoogleLogin extends BaseClass {

	@Test(groups= {"smoke","regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting TC_003_LoginSignup ****");
		try {
			logger.info("Verifying login/SignUp");
			SignupPage loginSignupPage = new SignupPage(driver);
			
			// click on the Zigwheels link to navigate back
			loginSignupPage.clickZigwheels();
			
			// Click on the Login/Signup button
			loginSignupPage.clickLoginSignUp();
			// Taking screenshot
			screenshot("LoginSignUpCard");
			
			// Select the google button
			loginSignupPage.selectGoogleButton();
		} catch (Exception e) {
			logger.info("Verifying login/SignUp failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_004_LoginSignup ****");
	}
}
