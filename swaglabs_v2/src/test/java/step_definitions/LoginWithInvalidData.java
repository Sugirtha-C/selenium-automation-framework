package step_definitions;

import static org.testng.Assert.assertEquals;

import config.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Swagpage;
import steps.CommonSteps;

public class LoginWithInvalidData {
	
	private CommonSteps steps;
	private Swagpage swagpage;
	
	public LoginWithInvalidData() {
		
		this.steps=new CommonSteps(Browser.getDriver());
		this.swagpage=steps.getSwagpage();
	}


	@Then("User get {string} as error message")
		public void verifyErrorMessage(String errMessage){
    assertEquals(errMessage,steps.getElementText(swagpage.loginErrorText));
    
}




}
