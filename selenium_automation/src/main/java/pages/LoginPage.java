package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utils.WaitUtil;

/*
 * LoginPage handles all actions related to user login.
 * It includes methods to enter credentials and perform login operations.
 * It also provides validation methods for login success or failure.
 */

public class LoginPage {
	
	WebDriver driver= DriverFactory.getDriver();
	
	WaitUtil waitutil= new WaitUtil();
	
	By signinEmail = By.cssSelector("[data-qa='login-email']");
	
	By signinPassword = By.xpath("//input[@data-qa='login-password']");
	
	By loginButton = By.xpath("//button[@data-qa='login-button']");
	
	By loginErrorMsg = By.xpath("//form/p[text()[contains(., 'incorrect!')]]");

	//Actions
	
	public void clickLoginbutton() {
		waitutil.waitForElementToBeClickable(loginButton);
		driver.findElement(loginButton).click();
		
	}
	
	public void enterEmail(String email) {
		waitutil.waitForElementToBeVisible(signinEmail);
		driver.findElement(signinEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		waitutil.waitForElementToBeVisible(signinPassword);
		driver.findElement(signinPassword).sendKeys(password);
	}
	
	public boolean isErrorDisplayed() {
		waitutil.waitForElementToBeVisible(loginErrorMsg);
		return driver.findElement(loginErrorMsg).isDisplayed();
	}

}

