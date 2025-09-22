package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Browser;
import config.ConfigReader;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.ScreenshotUtility;

public class Steps {

	private WebDriver driver=Browser.getDriver();
	
	private HomePage homepage;
	
	private SignUpPage signuppage;
	
	private SignInPage signinpage;
	
	private WebDriverWait wait;
	
	private WebDriverWait wait2;
	
	private Actions actions;
	
	private ScreenshotUtility screenshots;
	
	public HomePage getHomePage() {
		
		return homepage;
	}
	
	public SignUpPage getSignUpPage() {
		
		return signuppage;
	}

	public SignInPage getSignInPage() {
	
	return signinpage;
	}
	
	public ScreenshotUtility clickScreenshots() {
		return screenshots;
	}
	public Steps(WebDriver driver) {
		this.driver=driver;
		homepage=new HomePage(driver);
		signuppage=new SignUpPage(driver);
		signinpage=new SignInPage(driver);
		screenshots=new ScreenshotUtility(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
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
	
	public void sendSearchValue(String query) {
		homepage.searchBox.sendKeys(query);
		
	}
	
	public int getCountOfSearchResults() {
		return homepage.searchResultsCount.size();
	}
	
	public int getCountOfNestedResultsForGearMenu() {
		return homepage.nestedFirstLevel_Gear.size();
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void waitForElementToBeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
public void waitForElementToBeVisible2(WebElement element) {
		
		wait2.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void waitForElementToBeClickable2(WebElement element) {
		
		wait2.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*public void takeScreenshot(String fileName) {
        screenshots.takeScreenshot(fileName);
    }*/
	
	 public void takeScreenshot(String folderName, String fileName) {
	        screenshots.takeScreenshot(folderName, fileName);
	    }
    
	
	
	
}
