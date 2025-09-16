package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
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

/*
 * /**
 * Tests loan application functionality with TestNG using data from an Excel file.
 * It handles login, submits a loan application, verifies success, and cleans up WebDriver.
 */


public class LoanApplicationWithDataProviderTest {

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
	
	@DataProvider(name="loan_application")
	public static Object[][] getCreateAccountData() throws IOException{
	String filepath=System.getProperty("user.dir") + "/src/main/resources/LoanApplication.xlsx";
	String sheetName="Sheet2";
	return ExcelUtils.getDataArray(filepath, sheetName);
}
		
	@Test(dataProvider="loan_application")
	public void verifyLoanApplication(String username, String password,String loanamount,String downpayment) {
		steps.openSite();
		steps.sendLoginValue(username);
		steps.sendPasswordValue(password);
		steps.waitForElementToBeVisible(login.loginButton);
		steps.click(login.loginButton);
		
		steps.waitForElementToBeVisible(requestLoan.clickRequestLoanLink);
		steps.click(requestLoan.clickRequestLoanLink);
		requestLoan.loanAmount.sendKeys(loanamount);
		requestLoan.downPayment.sendKeys(downpayment);
		
		steps.takeScreenshot("TestNG_Tests", "Loan info");
		
		steps.waitForElementToBeVisible(requestLoan.applyNowButton);
		steps.click(requestLoan.applyNowButton);
		
		String loanRequestText=requestLoan.loanRequestSuccess.getText();
		System.out.println("loanRequestText"+loanRequestText);
		AssertJUnit.assertTrue(requestLoan.loanRequestSuccess.isDisplayed());	
		
		String expectedLoanRequestText=ConfigReader.getProperty("loanRequestText");
		AssertJUnit.assertEquals(expectedLoanRequestText,loanRequestText);
	
		
	}
			
	@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}	

}
