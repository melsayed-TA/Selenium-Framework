package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities_helper.Helper;

//Note: All tests (test cases) will inherit from this TestBase class

public class TestBase {

	protected static WebDriver driver;
	
	@BeforeTest
	@Parameters ({"browser"})	//parameterizing the browser --> The parameter value is in the testng.xml file
	public void startDriver(@Optional ("chrome") String browserName) {	//@Optional annotation is used here to set the value = "chrome" when running the test from "tests" package not from the TestNGSuite.xml file
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();		
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		} 

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://www.maut.toll-collect.de/ui/web/#/home");
	}
	
	
	@AfterTest(enabled = true) 
	public void stopDriver() {
		driver.quit();
	}
	
	
	//To be executed after each method --> take a screenshot when a test case fails and save it in the Screenshots folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Testcase failed!");
			Helper.captureScreenshot(driver, result.getName());
			System.out.println("Screenshot took and saved in Screenshots folder");
		}
	}
	
	
}
