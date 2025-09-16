package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Browser;
import pages.GooglePage;
import steps.CommonSteps;
import utils.TestUtils;

public class GoogleTests {
	
	private WebDriver driver;
	
	@BeforeTest
	
	public void setUp() {
		
		driver=Browser.getBrowser();
		TestUtils.initialize(driver);
	}
		
	@BeforeMethod
		public void launchBrowser() {
		
			CommonSteps.navigateToGoogle();
				
	}
	@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}
		
	 @Test
	    public void verifyAboutPageMissionStatement() {
		 
	        CommonSteps.clickAboutLink();
	        String actualAboutText = CommonSteps.getAboutPageText();
	        String expectedAboutText = "Our mission is to organize the world’s information and make it universally accessible and useful.";
	        assertEquals(actualAboutText, expectedAboutText);
	       // Browser.closeBrowser();
	    }
	 
	 @Test
	    public void verifySearchFunctionality() {
		 
		 	//TestUtils.waitforElement(By.name("q"), 20);
	        //TestUtils.waitforElement(By.name("btnK"), 20).click();
		    CommonSteps.performSearch("BBC News");
	        String searchResultData = CommonSteps.getSearchResultText();
	        String actualResultsData="query:BBC%20News";
	        assertEquals(searchResultData,actualResultsData);
	       // Browser.closeBrowser();
	 
	 }
	 
	 @Test
	 
	 public void verifySearchRetrievalDuration() {
		 
		 CommonSteps.performSearch("BBC News");
		 String resultStats=CommonSteps.getResultStats();
		 System.out.println("Result statistics: "+resultStats);
		 assertTrue(resultStats.contains("About"));
		 assertTrue(resultStats.contains("results"));
		 //Browser.closeBrowser();
		 
	 }
	 
}
