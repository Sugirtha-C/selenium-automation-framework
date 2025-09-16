package tests;

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

public class TestNg_Tests {

	private WebDriver driver;	
	private Steps steps;	
	private CustomerLoginLogOut login;
	private OpenNewAccount newAccount;
	private ScreenshotUtility screenshotUtility;
	private TransferFunds transferfunds;
	private RequestLoan requestLoan;
	
	
	@BeforeMethod
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
	
	public void verifyLogin()
	{
		steps.openSite();
		steps.sendLoginValue("test4");
		steps.sendPasswordValue("test4");
		steps.click(login.loginButton);
		steps.takeScreenshot("TestNG_Tests", "Login");
		
		String currentURL=driver.getCurrentUrl();
		String expectedURL="https://parabank.parasoft.com/parabank/overview.htm";
		AssertJUnit.assertEquals(currentURL,expectedURL,"Sucess Login URL is not the same");
		

	}
	@Test
	public void verifyOpenNewAccount() {
		steps.openSite();
		steps.sendLoginValue("test4");
		steps.sendPasswordValue("test4");
		steps.click(login.loginButton);
		steps.click(newAccount.openNewAccountLink);
		
		WebElement dropdownText=newAccount.accountType;
		Select dropdown = new Select(dropdownText);
		dropdown.selectByVisibleText("SAVINGS");
		
		WebElement dropdownAmount=newAccount.accountType;
		Select dropdownValue = new Select(dropdownAmount);
		dropdownValue.selectByIndex(0);
		
		steps.takeScreenshot("TestNG_Tests", "Creating new account");
		
		steps.click(newAccount.createAccountButton);
		steps.takeScreenshot("TestNG_Tests", "Acc creation response");
		
		String actualText=steps.getElementText(newAccount.successText);
		String successText=ConfigReader.getProperty("success_account_creation");
		assertTrue(actualText.contains(successText), "Acc opening does not contain expected text");			
	
}
	
	
	@DataProvider(name="MultipleFundTransfer")
	public static Object[][] getCreateAccountData() throws IOException{
	String filepath=System.getProperty("user.dir") + "/src/main/resources/CreateAccounts.xlsx";
	String sheetName="Sheet1";
	return ExcelUtils.getDataArray(filepath, sheetName);
}
	

	@Test(dataProvider="MultipleFundTransfer")
	public void verifyFundTransfers(String amount){
		
        
		steps.openSite();
		steps.sendLoginValue("test4");
		steps.sendPasswordValue("test4");		
		steps.click(login.loginButton);
		steps.waitForElementToBeVisible(transferfunds.transferFundsLink);
		steps.click(transferfunds.transferFundsLink);
		
		transferfunds.amount.sendKeys(amount);
		
		WebElement dropdownText=transferfunds.toAccount;
		Select dropdown = new Select(dropdownText);
		dropdown.selectByIndex(0);
		
		steps.takeScreenshot("TestNG_Tests", "transfer info");
		
		steps.click(transferfunds.transferButton);
		
				
		String actualText=steps.getElementText(transferfunds.transferCompleteText);
		String successText=ConfigReader.getProperty("transfer_success");
		assertTrue(actualText.contains(successText), "Text not displayed as expected");	
		steps.click(login.logOutLink);
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
	
	@Test
	public void verifyLoanApplication() {
		steps.openSite();
		steps.sendLoginValue("test4");
		steps.sendPasswordValue("test4");
		steps.click(login.loginButton);
		
		steps.waitForElementToBeVisible(requestLoan.clickRequestLoanLink);
		steps.click(requestLoan.clickRequestLoanLink);
		requestLoan.loanAmount.sendKeys("1000");
		requestLoan.downPayment.sendKeys("100");
		
		steps.takeScreenshot("TestNG_Tests", "Loan info");
		
		steps.click(requestLoan.applyNowButton);
		
		String loanRequestText=requestLoan.loanRequestSuccess.getText();
		System.out.println("loanRequestText"+loanRequestText);
		AssertJUnit.assertTrue(requestLoan.loanRequestSuccess.isDisplayed());	
		
		String expectedLoanRequestText=ConfigReader.getProperty("loanRequestText");
	
		
	}
	
		
		
	
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}
}
