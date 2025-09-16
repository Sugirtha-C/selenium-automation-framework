package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

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

public class sample {
	
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
	
	@DataProvider(name = "MultipleFundTransfer")
	public static Object[][] getTransferFundsData() throws IOException {
	    String filepath = System.getProperty("user.dir") + "/src/main/resources/Transferfunds.xlsx";
	    String sheetName = "Sheet1";
	    Object[][] data = ExcelUtils.getDataArray(filepath, sheetName);

	    // Debug output to check data
	    for (int i = 0; i < data.length; i++) {
	        System.out.println("Row " + (i + 1) + ": " + Arrays.toString(data[i]));
	    }

	    // Convert the last column (to account) to Integer
	    for (int i = 0; i < data.length; i++) {
	        String toAccountStr = data[i][3].toString().trim(); // Assuming the last column is the to account

	        // Check if the string is empty
	        if (toAccountStr.isEmpty()) {
	            throw new RuntimeException("To account value is empty for row: " + (i + 1));
	        }

	        // Parse the toAccount value as an integer
	        try {
	            data[i][3] = Integer.parseInt(toAccountStr);
	        } catch (NumberFormatException e) {
	            throw new RuntimeException("Invalid to account value for row " + (i + 1) + ": " + toAccountStr, e);
	        }
	    }

	    return data;
	}

	@Test(dataProvider="MultipleFundTransfer")
	public void verifyFundTransfers(String username,String password,String amount,int toaccount){
		
        
		steps.openSite();
		steps.sendLoginValue(username);
		steps.sendPasswordValue(password);		
		steps.click(login.loginButton);
		
		steps.waitForElementToBeVisible(transferfunds.transferFundsLink);
		steps.click(transferfunds.transferFundsLink);
		
		transferfunds.amount.sendKeys(amount);
		
		 System.out.println("To account value: " + toaccount);
		WebElement dropdownText=transferfunds.toAccount;
		Select toAccountDropdown = new Select(dropdownText);
		toAccountDropdown.selectByIndex(toaccount);
		
			
		steps.takeScreenshot("TestNG_Tests", "transfer info");
		
		steps.click(transferfunds.transferButton);
		
				
		String actualText=steps.getElementText(transferfunds.transferCompleteText);
		String successText=ConfigReader.getProperty("transfer_success");
		assertTrue(actualText.contains(successText), "Text not displayed as expected");	
		steps.click(login.logOutLink);
	}
		
		
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}


}
