package stepdefinitions;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

/*
 * Hooks class manages setup and teardown of test execution.
 * It initializes WebDriver before each scenario and quits it after execution.
 * It also integrates reporting and captures screenshots on failure.
 */

public class CommonSteps {
	
	HomePage homePage = new HomePage();
	
	@Given("user is on home page")
	public void onUserLoginPage(){
		
		DriverFactory.getDriver().get(ConfigReader.get("url"));
		
	}
	
	@When("user clicks on signup login button")
	public void clickLoginLink() {
		
		homePage.clickSignupLogin();
		
	}

}
