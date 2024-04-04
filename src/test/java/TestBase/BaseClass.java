package TestBase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	public static Logger logger;
	
	@BeforeTest(groups={"smoke","regression","master"})
	@Parameters({"os", "browser"})
	public void invokeBrowser(String os, String browser) throws IOException {
		//Reads the value From the Config File
		FileReader fileReader = new FileReader(".//src/test/resources/config.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		//loading log4j2 file For Logging
		logger = LogManager.getLogger(this.getClass());
		
		//Checks the type of Browser through Parameters from xml File
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		else {
			System.out.println("No Matching Browser");
			return;
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("Url"));
		
		driver.manage().window().maximize();
	}
	
	@AfterTest(groups={"smoke","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	//screenshot implementation
	public String screenshot(String name) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\ScreenShots\\"+name+" " +timeStamp+".png";
		File targetLocation = new File(path);
		FileUtils.copyFile(file, targetLocation);
		return path;
	}
}