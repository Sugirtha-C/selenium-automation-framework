package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverFactory;


/*
 * WaitUtil provides reusable explicit wait methods.
 * It helps handle dynamic elements by waiting for conditions like
 * visibility and clickability, improving test stability.
 */

public class WaitUtil {
	
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public void waitForElementToBeClickable(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementToBeVisible(By locator) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
