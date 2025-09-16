package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Browser;
import config.ConfigReader;
import pages.CustomerLoginLogOut;
import pages.OpenNewAccount;
import pages.RegisterAccount;
import pages.RequestLoan;
import pages.TransferFunds;
import utils.ScreenshotUtility;


/*
 * Provides methods to interact with different page objects and perform ations.
 */

public class Steps {

	private WebDriver driver=Browser.getDriver();
	
	private CustomerLoginLogOut loginlogout;
	private RegisterAccount registerAccount;
	private ScreenshotUtility screenshots;
	private OpenNewAccount newAccount;
	private TransferFunds transferfunds;
	private WebDriverWait wait;
	private RequestLoan requestLoan;
	
	
		/**
	 * Constructor for the Steps class. 
	 * Initializes the WebDriver instance and
	 * all the necessary page objects and utilities required for the test steps.
	 * It also initializes a WebDriverWait instance for managing explicit waits.
	 *
	 * @param driver the WebDriver instance to be used for interacting with web elements
	 */
	
	public Steps(WebDriver driver) {
		this.driver=Browser.getDriver();
		this.loginlogout=new CustomerLoginLogOut(driver);
		this.registerAccount=new RegisterAccount(driver);
		this.screenshots=new ScreenshotUtility(driver);
		this.transferfunds=new TransferFunds(driver);
		this.requestLoan=new RequestLoan(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	/*
	 * Getter methods for accessing page objects and  utility classes initialized
	 * in the constructor. 
	
	 * @returns instance of the particular page allowing interaction and
	 * providing access to use the specific page object
	 */
	
	public RequestLoan requestLoan()
	{
		return this.requestLoan;
	}
	
	public CustomerLoginLogOut getLoginLogOutPage() {
		
		return this.loginlogout;
	}
	
	public TransferFunds transferfunds() {
		return this.transferfunds;
	}
	
	public RegisterAccount getregisterAccount() {
		
		return this.registerAccount;
	}

	public OpenNewAccount openNewAccount() {
		
		return this.newAccount;
	}

	
	public ScreenshotUtility clickScreenshots() {
		return this.screenshots;
	}
	

	
	/*Methods to retrieve various data of WebElements
	 * located in pages package
	*/
		
	public void openSite() {
		driver.get(ConfigReader.getProperty("url"));
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public void sendLoginValue(String query) {
		loginlogout.loginTextBox.sendKeys(query);
		
	}

	public void sendPasswordValue(String query) {
		loginlogout.passwordTextBox.sendKeys(query);
		
	}
	
		
	public void waitForElementToBeVisible(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void waitForElementToBeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	 public void takeScreenshot(String folderName, String fileName) {
	        screenshots.takeScreenshot(folderName, fileName);
	    }
    
	
	
	
}
