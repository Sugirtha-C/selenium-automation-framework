
package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.Browser;
import config.ConfigReader;
import listeners.Testlisteners;
import pages.CustomerLoginLogOut;
import pages.OpenNewAccount;
import pages.RequestLoan;
import pages.TransferFunds;
import steps.Steps;
import utils.ExcelUtils;
import utils.ScreenshotUtility;

@Listeners(Testlisteners.class)

/**
 * Tests the fund transfer functionality.
 * Includes login, fund transfer actions, and result validation.
 * Takes screenshots during the process.
 */


public class TransferFundsTest {

	private WebDriver driver;	
	private Steps steps;	
	private CustomerLoginLogOut login;
	private OpenNewAccount newAccount;
	private ScreenshotUtility screenshotUtility;
	private TransferFunds transferfunds;
	private RequestLoan requestLoan;
	
	
	@BeforeClass
	public void setUp() {
		driver=Browser.getDriver();
		steps=new Steps(driver);
		newAccount=steps.openNewAccount();	
		login=steps.getLoginLogOutPage();
		transferfunds=steps.transferfunds();
		requestLoan=steps.requestLoan();
		screenshotUtility = new ScreenshotUtility(driver); 
				
	}
	
	@Test
	
	public void verifyFundTransfer() {
		
		steps.openSite();
		steps.sendLoginValue("test4");
		steps.sendPasswordValue("test4");
		steps.click(login.loginButton);
		steps.waitForElementToBeVisible(transferfunds.transferFundsLink);
		steps.click(transferfunds.transferFundsLink);
		
		transferfunds.amount.sendKeys("100");
		
		WebElement dropdownText=transferfunds.toAccount;
		Select dropdown = new Select(dropdownText);
		dropdown.selectByIndex(0);
		
		steps.takeScreenshot("TestNG_Tests", "transfer info");
		
		steps.click(transferfunds.transferButton);
		
				
		String actualText=steps.getElementText(transferfunds.transferCompleteText);
		String successText=ConfigReader.getProperty("transfer_success");
		assertTrue(actualText.contains(successText), "Text not displayed as expected");			
	
	}
	
	
@AfterClass

public void closeBrowser() {
	
	Browser.closeBrowser();
}

}
	