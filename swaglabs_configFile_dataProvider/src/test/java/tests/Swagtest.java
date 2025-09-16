package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Browser;
import pages.Swagpage;
import steps.CommonSteps;

public class Swagtest {
	
	
	private WebDriver driver;
	
	private CommonSteps steps;
	
	private Swagpage swagpage;
	
	@BeforeMethod
	public void setup() {
		driver=Browser.getDriver();
		steps=new CommonSteps(driver);
		swagpage=steps.getSwagpage();
	}
	
	@Test(dataProvider="loginChecks")
	public void verifyLogin(String userId, String password,boolean isElementPresent) {
		
		steps.openLabs();
		steps.sendLoginValue(userId);
		steps.sendPasswordValue(password);
		swagpage.loginButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
		
	  if (isElementPresent) {
          
		  wait.until(ExpectedConditions.visibilityOf(swagpage.resultStats));
		  assertTrue(steps.isElementPresent(swagpage.resultStats),"Login was not successful for user: "+userId);
        
      } else {
          
    	  wait.until(ExpectedConditions.visibilityOf(swagpage.loginErrorText));
    	  String actualErrorText=steps.getElementText(swagpage.loginErrorText);
          String expectedErrorText = "Epic sadface: Sorry, this user has been locked out.";
          assertEquals(actualErrorText, expectedErrorText, "Error message did not match for user: " + userId);
      }
	}

	@DataProvider(name="loginChecks")
			public Object[][] getLoginData(){
			return new Object[][] {
				{"locked_out_user","secret_sauce",false},
				{"standard_user","secret_sauce",true},
				{"problem_user","secret_sauce",true}
			};
	}


	@Test
	public void verifyLockedUserLogin() {
		
		steps.openLabs();
		steps.sendLoginValue("locked_out_user");
		steps.sendPasswordValue("secret_sauce");
		swagpage.loginButton.click();
		String actualErrorText=steps.getElementText(swagpage.loginErrorText);
		System.out.println("Error:" +actualErrorText);		
		String expectedErrorText="Epic sadface: Sorry, this user has been locked out.";
		assertEquals(actualErrorText,actualErrorText);
		
	}
	
	@Test
	public void verifyValidLogin() {
		
		steps.openLabs();
		steps.sendLoginValue("standard_user");
		steps.sendPasswordValue("secret_sauce");
		swagpage.loginButton.click();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(swagpage.resultStats));
		assertTrue(steps.isElementPresent(swagpage.resultStats));
	}
	
	
	@Test
	public void verifyCartBadgeCount_addOneProduct() {
		steps.openLabs();
		steps.sendLoginValue("standard_user");
		steps.sendPasswordValue("secret_sauce");
		swagpage.loginButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(swagpage.productToAdd_1)).click();
		wait.until(ExpectedConditions.visibilityOf(swagpage.shoppingCartIcon)).click();
		String cartItemsCountText=steps.getElementText(swagpage.itemsCountInCart);
		int actualCartItemsCount=Integer.parseInt(cartItemsCountText);
		int expectedCartItemsCount=1;
		assertEquals(actualCartItemsCount,expectedCartItemsCount);
		
	}
	
	@Test
	public void verifyCartBadgeCount_addTwoProduct() {
		steps.openLabs();
		steps.sendLoginValue("standard_user");
		steps.sendPasswordValue("secret_sauce");
		swagpage.loginButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//swagpage.productToAdd_1.click();
		//swagpage.productToAdd_2.click();
		
		wait.until(ExpectedConditions.visibilityOf(swagpage.productToAdd_2));
		wait.until(ExpectedConditions.elementToBeClickable(swagpage.productToAdd_2)).click();
		
		wait.until(ExpectedConditions.visibilityOf(swagpage.productToAdd_3));
		wait.until(ExpectedConditions.elementToBeClickable(swagpage.productToAdd_3)).click();
		
		//swagpage.productToAdd_2.click();
		wait.until(ExpectedConditions.visibilityOf(swagpage.shoppingCartIcon));
		wait.until(ExpectedConditions.elementToBeClickable(swagpage.shoppingCartIcon)).click();
		
		String cartItemsCountText=steps.getElementText(swagpage.itemsCountInCart);
		int actualCartItemsCount=Integer.parseInt(cartItemsCountText);
		int expectedCartItemsCount=3;
		System.out.println("Count in cart icon badge: " +actualCartItemsCount);
		assertEquals(actualCartItemsCount,expectedCartItemsCount);
		
	}
	@Test
	public void verifyCartListCount() {
		
		steps.openLabs();
		steps.sendLoginValue("standard_user");
		steps.sendPasswordValue("secret_sauce");
		swagpage.loginButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(swagpage.productToAdd_4)).click();
		
		//Actions action=new Actions(driver);
		//action.moveToElement(swagpage.shoppingCartIcon).click().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(swagpage.shoppingCartIcon)).click();
		
		int currentCartListCount=steps.getNumberOfItemsInCart();
		System.out.println("Current cart list count after 1 item addition:"+currentCartListCount);
		int expectedCartListCount=4;
		System.out.println("Actual cart list count: " + currentCartListCount);
		assertEquals(currentCartListCount,expectedCartListCount);
		
	}
	
	
	

	
}

