package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import config.Browser;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CustomerLoginLogOut;
import steps.Steps;

/*
 * The LoginStepDefinitions class manages the login functionality for user authentication:
 * 
 * - Inputs username and password, then clicks the login button.
 * - Verifies successful login by checking the current URL against the expected homepage URL.
 * - Checks for an error message if login fails and validates the error text against the expected message.
 * 
 * Uses the Steps class for common actions and interacts with the CustomerLoginLogOut page object for login-related elements.
 */

public class LoginStepDefinitions {
	
		private Steps steps;
		private CustomerLoginLogOut login;
		private WebDriver driver;
		
		public LoginStepDefinitions() {
			
			this.steps=new Steps(Browser.getDriver());
			this.login=steps.getLoginLogOutPage();
			//steps=new Steps(driver);
		}
	
	@When("User input {string} as username and {string} as password")
	
	public void user_input_as_username_as_password(String username, String password) {
		steps.sendLoginValue(username);
		steps.sendPasswordValue(password);
		steps.click(login.loginButton);
		
	 }		


	@Then("user loggedin successfully")
	public void user_already_on_homepage() {
		
		steps.waitForElementToBeVisible(login.accountOverview);;		
		String currentURl=driver.getCurrentUrl();
		String expectedLoginURl="https://parabank.parasoft.com/parabank/overview.htm";
		System.out.println(currentURl);
	    assertEquals(currentURl,expectedLoginURl);
	    
	}
	
	@Then("user sees error")
	public void wrongPasswordLogin() {
	
		steps.waitForElementToBeVisible(login.emptyInputLoginError);
		
		String actualError=steps.getElementText(login.emptyInputLoginError);
		System.out.println("actual error for invalid login"+actualError);
		
		
		String expectedErrorMessageForWrongPassword=ConfigReader.getProperty("invalid_login_Error_Text");
		
		if(actualError.contains(expectedErrorMessageForWrongPassword)) {
			assertEquals(actualError,expectedErrorMessageForWrongPassword,"Wrong Password error text is not matching");
		}
		else {
			assertTrue(!actualError.isBlank() || actualError.isEmpty());
		}
		//System.out.println("expectedErrorMessageForWrongPAssword from config reader:"+expectedErrorMessage);
		
		//String actualError=steps.getElementText(login.emptyInputLoginError);
		//System.out.println("actualErrorForWrongPassword"+actualError);
		
		//assertEquals(expectedErrorMessage,actualError,"Login error text does not match");
	}
	
	}
	//@Then("user sees error to enter username and password")
	//public void nullValueLogin() {
		//steps.waitForElementToBeVisible(login.emptyInputLoginError);		
		//String actualErrorForNullValue=steps.getElementText(login.emptyInputLoginError);		
		//System.out.println("actualError for nullvalue from website:"+actualErrorForNullValue);
		
		//assertTrue(!actualErrorForNullValue.isBlank() || actualErrorForNullValue.isEmpty());
		
		//assertEquals(expectedErrorForNullValue,actualErrorForNullValue,"Login error text does not match");
//	}

	
