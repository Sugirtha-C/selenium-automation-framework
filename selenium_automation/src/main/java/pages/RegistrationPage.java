package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utils.WaitUtil;


/*
 * LoginPage handles all actions related to user login.
 * It includes methods to enter credentials and perform login operations.
 * It also provides validation methods for login success or failure.
 */

public class RegistrationPage {

	WebDriver driver= DriverFactory.getDriver();
	
	WaitUtil waitUtil= new WaitUtil();
	
	By signupName= By.xpath("//input[@data-qa='signup-name']");
	
	By signupEmail=By.cssSelector("input[data-qa='signup-email']");
	
	By signUpPassword=By.id("password");
	
	By firstName=By.id("first_name");
	
	By lastName=By.id("last_name");
	
	By addr1=By.id("address1");
	
	By state= By.id("state");
			
	By city=By.id("city");
	
	By zipCode=By.id("zipcode");
	
	By mobileNumber=By.id("mobile_number");
	
	By dayDropdown = By.id("days");
	
	By monthDropdown = By.id("months");
	
	By yearDropdown = By.id("years");
	
	By signupBtn = By.xpath("//button[contains(text(),'Signup')]");
	
	By createAccountBtn= By.xpath("//button[@data-qa='create-account']");	
	
	By accountCreatedMsg= By.xpath("//h2[@data-qa='account-created']");
	
    // Actions
    public void clickSignupButton() {
    	
        driver.findElement(signupBtn).click();
    }
    
    public void enterPassword(String password) {
        waitUtil.waitForElementToBeClickable(signUpPassword);
        driver.findElement(signUpPassword).sendKeys(password);
    }
    
    public void clickCreateAccountBtn() {
	 	waitUtil.waitForElementToBeClickable(createAccountBtn);
        driver.findElement(createAccountBtn).click();
    }

    public void enterName(String name) {
    	waitUtil.waitForElementToBeClickable(signupName);
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterEmail(String email) {
    	waitUtil.waitForElementToBeClickable(signupEmail);
        driver.findElement(signupEmail).sendKeys(email);
    }
    
    public void enterfirstName(String first) {
    	waitUtil.waitForElementToBeClickable(firstName);
        driver.findElement(firstName).sendKeys(first);
    }
    
    public void enterLastName(String last) {
    	waitUtil.waitForElementToBeClickable(lastName);
        driver.findElement(lastName).sendKeys(last);
    }

    public void enteraddr1(String addrline1) {
    	waitUtil.waitForElementToBeClickable(addr1);
        driver.findElement(addr1).sendKeys(addrline1);
    }
    
    public void enterCity(String cityData) {
    	waitUtil.waitForElementToBeClickable(city);
        driver.findElement(city).sendKeys(cityData);
    }
    
    public void enterState(String stateData) {
    	waitUtil.waitForElementToBeClickable(state);
        driver.findElement(state).sendKeys(stateData);
    }
    
    public void enterZipCode(String zip) {
    	waitUtil.waitForElementToBeClickable(zipCode);
        driver.findElement(zipCode).sendKeys(zip);
    }
    
    public void enterMobileNumber(String mobile) {
    	waitUtil.waitForElementToBeClickable(mobileNumber);
        driver.findElement(mobileNumber).sendKeys(mobile);
    }
    
    public String getEmailValidationMessage() {
    	waitUtil.waitForElementToBeClickable(signupEmail);
        return driver.findElement(signupEmail).getAttribute("validationMessage");
    }
    
    public String getGeneralValidationMessage() {
        return driver.findElement(signUpPassword).getAttribute("validationMessage");
    }

    public boolean isAccountCreated() {
    	waitUtil.waitForElementToBeClickable(accountCreatedMsg);
    	return driver.findElement(accountCreatedMsg).isDisplayed();
    }
    
    public void selectDOB(String day, String month, String year) {

        Select daySelect = new Select(driver.findElement(dayDropdown));
        daySelect.selectByValue(day);

        Select monthSelect = new Select(driver.findElement(monthDropdown));
        monthSelect.selectByValue(month);

        Select yearSelect = new Select(driver.findElement(yearDropdown));
        yearSelect.selectByValue(year);
    }
}
