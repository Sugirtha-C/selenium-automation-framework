package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	private static WebDriver driver;
	
    public static void initialize(WebDriver WebDriver) {
    	
    	driver=WebDriver;
    	
    }
    
  //Explicit wait
    //public static WebElement waitforElement(By locator,int timeout) {
  		    	
    	//WebElement linkText = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
    	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
  		//return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	//return wait.until(ExpectedConditions.elementToBeClickable(locator));
    	
    	// Explicit wait for presence of element
        public static WebElement waitForPresenceOfElement(By locator, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        // Explicit wait for element to be clickable
        public static WebElement waitForElementToBeClickable(By locator, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        
        public static WebElement waitForVisibilityOfElement(By locator, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
}

