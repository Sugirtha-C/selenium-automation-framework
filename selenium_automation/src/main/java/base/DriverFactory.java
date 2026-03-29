package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * DriverFactory is responsible for managing WebDriver instances.
 * It uses ThreadLocal to ensure thread safety during parallel execution.
 * It provides methods to initialize, retrieve, and quit browser instances.
 */

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	//Get Driver

	public static WebDriver getDriver() {
		return driver.get();
	}

	//Initialize the driver

	public static void initDriver(String browser) {

		if(browser.equalsIgnoreCase("chrome")){

			ChromeOptions options= new ChromeOptions();
			options.addArguments("--disable-notifications");
	        options.addArguments("--disable-popup-blocking");

	        WebDriverManager.chromedriver().setup();
	        WebDriver webDriver= new ChromeDriver(options);
	        webDriver.manage().window().maximize();

	        driver.set(webDriver);
		}

		else if(browser.equalsIgnoreCase("edge")) {

			EdgeOptions options= new EdgeOptions();
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notifications");

			WebDriverManager.edgedriver().setup();
			WebDriver webDriver= new EdgeDriver(options);
			webDriver.manage().window().maximize();

			driver.set(webDriver);

		}

	}

	//Quit Driver
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
