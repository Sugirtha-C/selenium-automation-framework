package stepdefinitions;

import org.json.JSONObject;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import utils.JsonUtil;
import config.ConfigReader;


/*
 * LoginSteps defines step definitions for login scenarios.
 * It connects feature steps with page actions and performs
 * validations for login success and failure.
 */

public class RegistrationSteps {
	
	RegistrationPage registrationPage = new RegistrationPage();
	HomePage homePage= new HomePage();
	LoginSteps loginSteps=new LoginSteps();

	@When("user registers with {string}")
	public void user_registers_with_type(String type) {

	    JsonUtil json = new JsonUtil("src/test/resources/testdata/registration.json");
	    JSONObject user = json.getUserByType(type);

	    // Page 1
	    registrationPage.enterName(user.getString("name"));
	    registrationPage.enterEmail(user.getString("email"));
	    registrationPage.clickSignupButton();

	    // Case 1: invalid email → stop here
	    if (type.equalsIgnoreCase("invalid_email")) {
	        return;
	    }

	    // Page 2
	    registrationPage.enterPassword(user.getString("password"));
	    registrationPage.enterfirstName(user.getString("firstName"));
	    registrationPage.enterLastName(user.getString("lastName"));
	    registrationPage.enteraddr1(user.getString("address"));
	    registrationPage.enterCity(user.getString("city"));
	    registrationPage.enterState(user.getString("state"));
	    registrationPage.enterZipCode(user.getString("zip"));
	    registrationPage.enterMobileNumber(user.getString("mobile"));

	    registrationPage.clickCreateAccountBtn();
	}


@Then("registration should be successful")
public void checkSuccessfulRegister() {
	
	 Assert.assertTrue(registrationPage.isAccountCreated());
  
}


@Then("registration should fail")
public void validateRegistrationError() {
	
	    String message = registrationPage.getGeneralValidationMessage();

	    Assert.assertTrue(message.length() > 0, "Mandatory field validation not shown");
}

@Then("email validation message should be shown")
public void validateEmailError() {
	
	String message = registrationPage.getEmailValidationMessage();

    Assert.assertTrue(message.length() > 0, "No validation message displayed");
  
}
	
}
