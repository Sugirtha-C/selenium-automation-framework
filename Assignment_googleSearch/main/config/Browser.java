package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	 public static WebDriver driver;
	 
	 public static WebDriver getBrowser() {
		 
		 if (driver == null) {
			 
			 driver= new ChromeDriver();
			 driver.manage().window().maximize();			 
		 }
		 
		 return driver;
		 
	}
	 
	 public static void redirect(String url) {
		 
		 driver.get(url);
		 
	 }
	 
	 public static void closeBrowser() {
		 
	 	if(driver!=null) {
				driver.quit();
				driver=null;
		}
	 	
	 }	
	 
	 public static boolean isBrowserOpen() {
			return driver!=null;
		}
		
	 
}