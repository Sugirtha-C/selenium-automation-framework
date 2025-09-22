package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.Browser;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import steps.Steps;
import utils.ScreenshotUtility;
import listeners.Testlisteners;

@Listeners(Testlisteners.class)

public class SignInSignOuTest {
	
	private WebDriver driver;	
	private Steps steps;	
	private HomePage homepage;
	private SignUpPage signuppage;
	private SignInPage signinpage;
	private ScreenshotUtility screenshotUtility;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		driver=Browser.getDriver();
		steps=new Steps(driver);
		homepage=steps.getHomePage();	
		signuppage=steps.getSignUpPage();
		signinpage=steps.getSignInPage();
		 screenshotUtility = new ScreenshotUtility(driver); 
				
	}
	
	@Test
    public void verifySignInSignOut() {
    	
    	
		steps.openSite();
		//screenshotUtility.takeScreenshot("TestNG_Tests","Signinsingout_01");
		//steps.takeScreenshot("01_openSite");
		 steps.takeScreenshot("TestNG_Tests", "01_openSite");
    	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	
    	steps.waitForElementToBeVisible(homepage.signInLink);
    	homepage.signInLink.click();
    	//steps.takeScreenshot("02");
    	 //steps.takeScreenshot("testng_exec", "02");
    	screenshotUtility.takeScreenshot("TestNG_Tests","Signinsingout_02");
    	steps.waitForElementToBeClickable(signinpage.registeredEmailID);
    	signinpage.registeredEmailID.sendKeys("sri@gmail.com");
    	
    	
    	steps.waitForElementToBeClickable(signinpage.registeredPassword);
    	signinpage.registeredPassword.sendKeys("Sri1986@gmail");
    	 	
    	steps.waitForElementToBeClickable(signinpage.loginButton);
    	signinpage.loginButton.click();
    	//steps.takeScreenshot("03");
    	 // steps.takeScreenshot("testng_exec", "03");
    	
    	steps.waitForElementToBeVisible(signinpage.signOutArrowLink);
    	signinpage.signOutArrowLink.click();  
    	//steps.takeScreenshot("04");
    	// steps.takeScreenshot("testng_exec", "04");
    	
    	
        //wait.until(ExpectedConditions.elementToBeClickable(signuppage.signOutLink2)).click();
    	steps.waitForElementToBeVisible(signinpage.signOutButton);
    	signinpage.signOutButton.click();
    	//steps.takeScreenshot("05");
    	  //steps.takeScreenshot("testng_exec", "05");
    	
    	String currentURl=driver.getCurrentUrl();
    	//steps.takeScreenshot("06");
    	// steps.takeScreenshot("testng_exec", "06");
    	System.out.println("Url navigated after sign out to: "+currentURl);
    	
    	
    }
    
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}

}
