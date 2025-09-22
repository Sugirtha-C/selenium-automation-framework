package step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import config.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Swagpage;
import steps.CommonSteps;

public class LoginWithValidData {
	
	private CommonSteps steps;
	private Swagpage swagpage;
	
	public LoginWithValidData() {
		
		this.steps=new CommonSteps(Browser.getDriver());
		this.swagpage=steps.getSwagpage();
	}
	
	@Given("User already opened the webpage")
	public void user_already_opened_the_webpage() {
	   
		steps.openLabs();
	}

	@When("User input {string} as username {string} as password")
	public void user_input_as_username_as_password(String username, String password) {
		steps.sendLoginValue(username);
		steps.sendPasswordValue(password);
		steps.click(swagpage.loginButton);
		//swagpage.loginButton.click();
	}

	@Then("User already on homepage")
	public void user_already_on_homepage() {
	    assertTrue(steps.isElementPresent(swagpage.resultStats),"Login was not successful for user");
	    
	}

}
