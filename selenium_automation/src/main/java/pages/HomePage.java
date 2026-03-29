package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utils.WaitUtil;


/*
 * HomePage represents the landing page of the application.
 * It contains locators and actions related to navigation,
 * such as accessing the Signup/Login page and verifying login status.
 */

public class HomePage {
	
WebDriver driver = DriverFactory.getDriver();

WaitUtil waitutil= new WaitUtil();

By signUpLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");

By userName = By.xpath("//a[contains(text(),'Logged in as')]");

By logOutBtn = By.xpath("//a[contains(text(),'Logout')]");

public void clickSignupLogin() {
	waitutil.waitForElementToBeVisible(signUpLoginBtn);
	driver.findElement(signUpLoginBtn).click();
	
}

public boolean isUserLoggedIn() {
	waitutil.waitForElementToBeVisible(userName);
	return driver.findElement(userName).isDisplayed();
}


}