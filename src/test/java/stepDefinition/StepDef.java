package stepDefinition;

import java.io.IOException;

import TestBase.BaseClass;
import TestCase.TC_001_UpcomingBikeDetails;
import TestCase.TC_002_UsedCarsDetails;
import TestCase.TC_003_GoogleLogin;
import TestCase.TC_004_GoogleSignup;
//import TestCases.TestCase1_UpcomingBikeDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	BaseClass bs = new BaseClass();

	@Given("Given load the browser and ZigsWheel Page")
	public void load_the_browser() {
		try {
			bs.invokeBrowser("Windows", "chrome");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Then("Click on New Bikes and Upcoming bike select hond and get the details of Bikes")
	public void click_on_new_bikes_and_upcoming_bike_select_hond_and_get_the_details_of_bikes() {
		TC_001_UpcomingBikeDetails tc1 = new TC_001_UpcomingBikeDetails();
		try {
			tc1.clickNewBikes();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		tc1.clickUpcomingBikes();
	}

	@Then("Click on Used Cars and select models and Get the model details")
	public void click_on_used_cars_and_select_models_and_get_the_model_details() {
		TC_002_UsedCarsDetails tc2 = new TC_002_UsedCarsDetails();
		try {
			tc2.UsedCarDetails();
		} catch (InterruptedException e) {

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("Login/signUp tp google and give invalid details and capture error message")
	public void login_sign_up_tp_google_and_give_invalid_details_and_capture_error_message() {
		TC_003_GoogleLogin tc3 = new TC_003_GoogleLogin();
		TC_004_GoogleSignup tc4 = new TC_004_GoogleSignup();
		tc3.verifyLoginPage();
		tc4.verifyLoginPage();
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		bs.tearDown();
	}

}