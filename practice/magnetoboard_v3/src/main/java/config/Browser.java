package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

	private static WebDriver driver;
	
	/*
	 * Browser Initialization
	 * @return driver
	 */
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			//options.addArguments("--start-maximized");					
			driver=new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();			
		}
		return driver;
	}
	
	public static void closeBrowser() {
		
		if(driver!=null) {
			
		driver.quit();
		driver=null;
		
		}
	}
	
}
