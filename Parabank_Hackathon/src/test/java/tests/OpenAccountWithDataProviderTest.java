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
 * Tests account creation using data from an Excel file.
 * Includes setup, data-driven tests, screenshots, and result verification.
 */


public class OpenAccountWithDataProviderTest {

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

	@DataProvider(name="open_account")
	
	public static Object[][] getCreateAccountData() throws IOException{
	String filepath=System.getProperty("user.dir") + "/src/main/resources/OpenAccount.xlsx";
	String sheetName="Sheet2";
    Object[][] data = ExcelUtils.getDataArray(filepath, sheetName);

 // Debug log
    System.out.println("Data loaded from Excel:");
    for (Object[] row : data) {
        for (Object cell : row) {
            System.out.print(cell + " ");
        }
        System.out.println();
    }
    return data;
}
	
	
	@Test(dataProvider="open_account")
	public void verifyOpenNewAccount(String username,String password,String accountType,String amount) {
		steps.openSite();
		steps.sendLoginValue(username);
		steps.sendPasswordValue(password);
		steps.click(login.loginButton);
		steps.click(newAccount.openNewAccountLink);
		
		WebElement dropdownText=newAccount.accountType;
		Select dropdown = new Select(dropdownText);
		dropdown.selectByVisibleText(accountType);
		
		WebElement dropdownAmount=newAccount.accountType;
		Select dropdownValue = new Select(dropdownAmount);
		//dropdownValue.selectByIndex(amount);
		dropdownValue.deselectByValue(amount);
		
		/*dropdownAmount.clear();
		dropdownAmount.sendKeys(String.valueOf(amount));*/
		
		steps.takeScreenshot("TestNG_Tests", "Creating new account");
		
		steps.click(newAccount.createAccountButton);
		steps.takeScreenshot("TestNG_Tests", "Acc creation response");
		
		String actualText=steps.getElementText(newAccount.successText);
		String successText=ConfigReader.getProperty("success_account_creation");
		assertTrue(actualText.contains(successText), "Acc opening does not contain expected text");			
	
}

	
		
	
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}
}



