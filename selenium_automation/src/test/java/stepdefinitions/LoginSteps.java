package stepdefinitions;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonUtil;
import base.DriverFactory;

/*
 * LoginSteps defines step definitions for login scenarios.
 * It connects feature steps with page actions and performs
 * validations for login success and failure.
 */

public class LoginSteps {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@When("user logs in with {string} and {string}")
	public void login(String email, String password) {

	    loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
	    loginPage.clickLoginbutton();
	}
	
	
		@Then("login should be {string}")
		public void validateLogin(String type) {

		    if (type.equals("valid")) {
		        Assert.assertTrue(homePage.isUserLoggedIn());
		    } else {
		        Assert.assertTrue(loginPage.isErrorDisplayed());
		    }
		}
	
	}