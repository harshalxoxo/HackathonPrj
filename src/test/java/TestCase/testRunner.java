package TestCase;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\2308397\\eclipse-workspace\\CAS_Project\\IdentifyNewBikes_Hackathon-main\\IdentifyNewBikes_Hackathon-main\\FeatureFiles\\login.feature", glue = "stepDefinition", plugin = { "pretty",
		"html:reports/myCucumberReport.html" })
public class testRunner {

}