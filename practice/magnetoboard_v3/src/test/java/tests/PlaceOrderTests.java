package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.Browser;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import steps.Steps;
import listeners.Testlisteners;

@Listeners(Testlisteners.class)
public class PlaceOrderTests {

	
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
    public void checkOutPurchase() {
    	
    	steps.openSite();
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	
    	steps.waitForElementToBeVisible(homepage.signInLink);
    	homepage.signInLink.click();
    	
    	steps.waitForElementToBeVisible(signinpage.registeredEmailID);
    	signinpage.registeredEmailID.sendKeys("sugi@gmail.com");
    	
    	steps.waitForElementToBeVisible(signinpage.registeredPassword);
    	signinpage.registeredPassword.sendKeys("Sugi@test.com");
    	
    	signinpage.loginButton.click();        	
    	        	
    	steps.sendSearchValue("watch");
				
		steps.waitForElementToBeVisible(homepage.searchMagnifier);
		homepage.searchMagnifier.click();
				
		
		steps.waitForElementToBeVisible(homepage.searchResultsPage);
		
		
		steps.waitForElementToBeVisible(signinpage.productToBuy);
		signinpage.productToBuy.click();
			
		
		
		steps.waitForElementToBeVisible(signinpage.addToCart);
		signinpage.addToCart.click();
		
		steps.waitForElementToBeVisible(homepage.showCartLink);
		signinpage.showCartCounterLink.click();
		
		steps.waitForElementToBeVisible(signinpage.checkOutButton);
		signinpage.checkOutButton.click();
		
		steps.waitForElementToBeVisible(signinpage.shippingMethodOption);
		signinpage.shippingMethodOption.click();
		
		
		steps.waitForElementToBeVisible(signinpage.nextButton);
		signinpage.nextButton.click();

		
		/*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signinpage.placeOrderButton);
		signinpage.placeOrderButton.click();*/
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinpage.placeOrderButton);
		
		//steps.waitForElementToBeVisible(signinpage.placeOrderButton);
		//signinpage.placeOrderButton.click();
		
		
		steps.waitForElementToBeVisible(signinpage.orderConfirmationPage);
		//signinpage.orderConfirmationPage.click();
		
		assertTrue(signinpage.orderConfirmationPage.isDisplayed());
		
		String expectedText=steps.getElementText(signinpage.orderConfirmationPage);
		
		System.out.println("Text is: "+expectedText);
		
		String actualText="Thank you for your purchase!";
		assertEquals(expectedText,actualText,"Text is not matching");
    }		
}
	
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}
}
