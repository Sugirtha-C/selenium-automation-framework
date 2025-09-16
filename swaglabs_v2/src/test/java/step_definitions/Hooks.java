package step_definitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Browser;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtility;

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
		String screenshotName=scenario.getName().replaceAll(" ","_") +"_"+ System.currentTimeMillis();
		screenshots.takeScreenshot(screenshotName);
		}
		
		
	}
	
	 }
