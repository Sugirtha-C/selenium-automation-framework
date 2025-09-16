package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {

	
private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			driver=new ChromeDriver();
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
