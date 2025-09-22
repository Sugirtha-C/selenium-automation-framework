package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Browser;
import steps.CommonSteps;
import utils.TestUtils;

public class GooglePage {
	
	 private static WebDriver driver = Browser.getBrowser();

	 public static void clickAboutPageLink() {
	        WebElement aboutLink = TestUtils.waitForElementToBeClickable(By.linkText("About"),30);
	        aboutLink.click();
	    }   
	 
	 
	 public static WebElement getAboutPageText() {
	        return TestUtils.waitForPresenceOfElement(By.xpath("//h1[@class='modules-lib__mission-statement__headline glue-headline glue-headline--fluid-2']"),30);
	    }

	    public static void enterSearchText(String searchText) {
	        WebElement searchInput = TestUtils.waitForElementToBeClickable(By.name("q"),30);
	        searchInput.sendKeys(searchText);
	    }

	    public static void clickSearchButton() {
	        WebElement searchButton = TestUtils.waitForElementToBeClickable(By.name("btnK"),30);
	        searchButton.click();
	    }

	    public static String getSearchResultsText() {
	        WebElement linkText = TestUtils.waitForPresenceOfElement(By.xpath("//div[@id='rso']"),30);
	        return linkText.getAttribute("data-async-context");
	    }

	   public static String getResultStats() {
		   
		   WebElement resultStats=TestUtils.waitForPresenceOfElement(By.id("result-stats"),30);
		   return resultStats.getText();
	   }
	
	}
