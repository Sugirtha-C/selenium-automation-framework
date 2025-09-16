package step_definitions;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Browser;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtility;

/*
 * The Hooks class manages setup and teardown actions for Cucumber scenarios:
 * 
 * - @Before: Initializes the WebDriver and ScreenshotUtility before each scenario.
 * - @After: Captures a screenshot of the final scenario state, attaches it to the report, and closes the browser.
 * - @AfterStep: Takes a screenshot after each step, naming it with a timestamp for detailed step-level reporting.
 * 
 * Utilizes ScreenshotUtility for capturing screenshots and Browser for managing WebDriver and browser lifecycle.
 */

public class Hooks {
	
	private WebDriver driver;
	private ScreenshotUtility screenshots;
	
	@Before
	
	public void setUp() {
	driver=Browser.getDriver();
	screenshots=new ScreenshotUtility(driver);	
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		 if (screenshots != null) {
			 
			byte[] screenshot = screenshots.getScreenshotAsBytes();
	        scenario.attach(screenshot, "image/png", scenario.getName());
			Browser.closeBrowser();
		 }
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		
		if(scenario !=null && screenshots!=null) {
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String screenshotName=scenario.getName().replaceAll(" ","_") +"_"+date;
		screenshots.takeScreenshot("cucumber_exec",screenshotName);
		}
		
		
	}
	
	 }
