package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

/*
 * Hooks class manages setup and teardown of test execution.
 * It initializes WebDriver before each scenario and quits it after execution.
 * It also integrates reporting and captures screenshots on failure.
 */


public class Hooks {
	
	static ExtentReports extent = ExtentManager.getInstance();
	static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Before
	public void setUp(Scenario scenario) {
		DriverFactory.initDriver(ConfigReader.get("browser"));
		
		ExtentTest extentTest = extent.createTest(scenario.getName());
		test.set(extentTest);
	}

	@After
	public void tearDown(Scenario scenario) {

	    if (scenario.isFailed()) {

	        String screenshotPath = ScreenshotUtil.captureScreenshot(scenario.getName());
	        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
	                .getScreenshotAs(OutputType.BYTES);

	        scenario.attach(screenshot, "image/png", "Failure Screenshot");

	        test.get().fail("Test Failed",
	                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	    } else {
	        test.get().pass("Test Passed");
	    }

	    DriverFactory.quitDriver();
	    extent.flush();
	}
}
