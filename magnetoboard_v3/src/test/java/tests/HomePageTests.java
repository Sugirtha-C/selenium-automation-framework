package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import listeners.Testlisteners;

import config.Browser;
import listeners.Testlisteners;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import steps.Steps;
import utils.ExcelUtils;


@Listeners(Testlisteners.class)

public class HomePageTests {
	
private WebDriver driver;
	
	private Steps steps;
	
	private HomePage homepage;
	private SignUpPage signuppage;
	private SignInPage signinpage;
	
	
	//@BeforeMethod - removed this as this was creating different instances of the browser
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		driver=Browser.getDriver();
		steps=new Steps(driver);
		homepage=steps.getHomePage();	
		signuppage=steps.getSignUpPage();
		signinpage=steps.getSignInPage();
		
		
	}
		
	@Test
	public void verifyDemoMessage() {
		
		steps.openSite();
		String actualDemoMessage=steps.getElementText(homepage.showDemoMessage);
		String expectedDemoMessage="This is a demo store to test your test automaiton scripts. No orders will be fulfilled. If you are facing any issue, email us at hello@softwaretestingboard.com.";
		assertEquals(actualDemoMessage,expectedDemoMessage,"Demo message is not as expected");
		
	}
	
	@Test
	public void verifySearchResultsOnMagnifierClick() {
		
		steps.openSite();
		steps.sendSearchValue("watch");
		
		
		steps.waitForElementToBeClickable(homepage.searchMagnifier);
		homepage.searchMagnifier.click();
				
		steps.waitForElementToBeClickable(homepage.searchResultsPage);
		
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");
		
		int actualResultCount=steps.getCountOfSearchResults();
		System.out.println("Actual list in output: "+actualResultCount);
		int expectedResultCount=9;
		assertEquals(actualResultCount,expectedResultCount);	
		
	}
	
	@Test
	public void verifySearchResultsOnAutoCompleteClick() {
		
		steps.openSite();
		steps.sendSearchValue("tee");
		
		steps.waitForElementToBeClickable(homepage.AutoCompleteSearchOption);
		steps.click(homepage.AutoCompleteSearchOption);
				
		steps.waitForElementToBeVisible(homepage.searchResultsPage);
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");
		
		//maintain expected results on properties file, to avoid hardcoding
		
		}
	
	@Test
	
	public void verifyNestedLevelSearch() {
		
		steps.openSite();
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(homepage.womenLink));
		steps.waitForElementToBeVisible(homepage.womenLink);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.womenLink).perform();
				
		//wait.until(ExpectedConditions.visibilityOf(homepage.nestedFirstLevel));
		steps.waitForElementToBeVisible(homepage.nestedFirstLevel);
		actions.moveToElement(homepage.nestedFirstLevel).perform();
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.nestedSecondLevel));
		steps.waitForElementToBeVisible(homepage.nestedSecondLevel);
		actions.moveToElement(homepage.nestedSecondLevel).perform();
		
		homepage.nestedSecondLevel.click();
		
				
		//wait.until(ExpectedConditions.visibilityOf(homepage.searchResultsPage));
		steps.waitForElementToBeVisible(homepage.searchResultsPage);
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");	
		
	}
	
	
	@Test
	
	public void verifyLogoClick()
	{
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		steps.waitForElementToBeVisible(homepage.storeLogo);		
		homepage.storeLogo.click();
		String currentURLAfterLogoClick=driver.getCurrentUrl();
		String expectedURL="https://magento.softwaretestingboard.com/";
		
		assertEquals(currentURLAfterLogoClick,expectedURL,"Unable to navigate to home page");
	}
	
	public void verifyDirectMenuClicks() {
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.womenLink)).click();
		
		steps.waitForElementToBeVisible(homepage.womenLink);
		homepage.womenLink.click();
		
		steps.waitForElementToBeVisible(homepage.searchResultsPage);
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.searchResultsPage));
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.storeLogo)).click();
		steps.waitForElementToBeVisible(homepage.storeLogo);
		homepage.storeLogo.click();
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.menLink)).click();
		steps.waitForElementToBeVisible(homepage.menLink);
		homepage.menLink.click();
		
		steps.waitForElementToBeVisible(homepage.searchResultsPage);	
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.searchResultsPage));
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.storeLogo)).click();
		steps.waitForElementToBeVisible(homepage.storeLogo);
		homepage.storeLogo.click();
		
		steps.waitForElementToBeVisible(homepage.gearLink);
		homepage.gearLink.click();
		
		steps.waitForElementToBeVisible(homepage.searchResultsPage);
		//wait.until(ExpectedConditions.visibilityOf(homepage.gearLink)).click();	
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.searchResultsPage));
		assertTrue(steps.isElementPresent(homepage.searchResultsPage),"Expected search output not present");	
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.storeLogo)).click();
		
		steps.waitForElementToBeVisible(homepage.storeLogo);
		homepage.storeLogo.click();
	}
	
	@Test
	public void verifyDropDownArrowMenuCount() {
		
		Actions actions = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//wait.until(ExpectedConditions.visibilityOf(homepage.gearLink));
		steps.waitForElementToBeVisible(homepage.gearLink);
		actions.moveToElement(homepage.gearLink).perform();	
			
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@id='ui-id-6']/following-sibling::ul[contains(@class, 'level0 submenu ui-menu')]/li")));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(homepage.nestedFirstLevel_Gear));
		
		int actualCountOfMenuItemsUnderGear=steps.getCountOfNestedResultsForGearMenu();
		System.out.println("Actual count of menu items under gear:" +actualCountOfMenuItemsUnderGear);
		int expectedCountOfMenuUnderGear=3;
		
		assertEquals(actualCountOfMenuItemsUnderGear,expectedCountOfMenuUnderGear,"Count under Gear is not 3");
		
		
	}

        	
          
        @AfterClass
    	
    	public void closeBrowser() {
    		
    		Browser.closeBrowser();
    	}
    		
    		
}
	



