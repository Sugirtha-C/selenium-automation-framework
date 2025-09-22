package tests;

import org.testng.annotations.AfterClass;
import listeners.Testlisteners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.Browser;
import listeners.Testlisteners;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import steps.Steps;
import utils.ExcelUtils;


@Listeners(Testlisteners.class)
public class CreateAccountTest {

	private WebDriver driver;	
	private Steps steps;	
	private HomePage homepage;
	private SignUpPage signuppage;
	private SignInPage signinpage;
	
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
	public void verifyCreateAccountLink1() {
		
		steps.openSite();
		
		steps.waitForElementToBeVisible(homepage.signUpLink);
		homepage.signUpLink.click();
		
		steps.waitForElementToBeVisible(signuppage.signUpForm);
		
		assertTrue(steps.isElementPresent(signuppage.signUpForm));
	}

	
	@Test
	public void verifyCreateAccountLink2() {
		
		steps.openSite();
				
		steps.waitForElementToBeVisible(homepage.signUpLink);
		homepage.signUpLink.click();		

		steps.waitForElementToBeVisible(signuppage.signUpForm);
		AssertJUnit.assertTrue(steps.isElementPresent(signuppage.signUpForm));
	}


	
	@DataProvider(name="createAccountChecks")
			public static Object[][] getCreateAccountData() throws IOException{
			String filepath=System.getProperty("user.dir") + "/src/main/resources/CreateAccounts.xlsx";
			String sheetName="Sheet1";
			return ExcelUtils.getDataArray(filepath, sheetName);
	}
	
	@Test(dataProvider="createAccountChecks")
	public void verifyCreateAccount(String firstName,String lastName,String email,String password,String confirmPassword) {
		
        
		steps.openSite();
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(30));
			
		steps.waitForElementToBeVisible2(homepage.signUpLink);
		homepage.signUpLink.click();
		
		steps.waitForElementToBeVisible2(signuppage.signUpForm);
		
		signuppage.firstNameTextBox.sendKeys(firstName);
		signuppage.lastNameTextBox.sendKeys(lastName);
		signuppage.emailTextBox.sendKeys(email);
		signuppage.passwordTextBox.sendKeys(password);
		signuppage.passwordConfirmationTextBox.sendKeys(confirmPassword);
		
		steps.waitForElementToBeClickable2(signuppage.createAccountButton);
		signuppage.createAccountButton.click();
		
		try {
			
				steps.waitForElementToBeVisible2(signuppage.successResponseMessage);
				String actualResponse=signuppage.successResponseMessage.getText();
						
				
	            String expectedResponse="Thank you for registering with Main Website Store.";
     
	            assertEquals(actualResponse,expectedResponse,"Response text does not match:");
	            
	            steps.waitForElementToBeVisible2(signinpage.signOutArrowLink);
	            signinpage.signOutArrowLink.click();
	            
	            steps.waitForElementToBeVisible2(signinpage.signOutButton);
	            signinpage.signOutButton.click();
	            
	            wait2.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/"));
     
		 } catch(TimeoutException e) {
		 
			 
			 if(email.isEmpty())
			 {
				 
				
				 steps.waitForElementToBeVisible2(signuppage.emailRequiredError);			 
				 assertTrue(signuppage.emailRequiredError.isDisplayed());
				 String actualError=signuppage.requiredFieldsText.getText();
				
				 System.out.println("Actual error message for empty field input is: "+actualError);
				 
			 }
			 
			 if(password.isEmpty())
			 {
				 
				 
				 steps.waitForElementToBeVisible2(signuppage.passwordRequiredError);		

				 assertTrue(signuppage.passwordRequiredError.isDisplayed());
				 String actualError=signuppage.requiredFieldsText.getText();
				 //String expectedError= "This is a required field.";
				 System.out.println("Actual error message for empty field input is: "+actualError);
				 //assertEquals(actualError,expectedError,"Error message is different");

			 }
			 else if(!password.equals(confirmPassword)){
				 
							 
				 steps.waitForElementToBeVisible2(signuppage.confirmPasswordError);
				 assertTrue(signuppage.confirmPasswordError.isDisplayed());

	             String actualErrorMessage = signuppage.confirmPasswordError.getText();
	             System.out.println("confirm password actual error:"+actualErrorMessage);
	             
				 
			 }
			 
		 }
	}
	
@AfterClass
	
	public void closeBrowser() {
		
		Browser.closeBrowser();
	}
}
