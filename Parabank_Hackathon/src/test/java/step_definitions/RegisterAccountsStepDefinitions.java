package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.RegisterAccount;
import steps.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Browser;
import config.ConfigReader;
import utils.ExcelUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class RegisterAccountsStepDefinitions {

     private Steps steps;
	private RegisterAccount registerAccount;
	private WebDriver driver;
	 private ExcelUtils excelUtils;
	 private Map<String, String> registrationData;

		
	public RegisterAccountsStepDefinitions() {
			
		this.steps=new Steps(Browser.getDriver());
		this.registerAccount=steps.getregisterAccount();			
		driver=Browser.getDriver();
		excelUtils = new ExcelUtils();
		}
	
    @Given("url {string} is launched")
    public void url_is_launched(String url) throws IOException {
    	 steps.openSite();
    	
    }
    
    @When("RegisterLink is clicked")
    public void register_link_is_clicked() {
        steps.click(registerAccount.clickToRegisterLink);
         }

    @When("user enters valid data")
    public void user_enters_valid_data(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
        	registerAccount.firstName.sendKeys(row.get("First Name"));
            registerAccount.lastName.sendKeys(row.get("Last Name"));
            registerAccount.address.sendKeys(row.get("Address"));
            registerAccount.city.sendKeys(row.get("City"));
            registerAccount.state.sendKeys(row.get("State"));
            registerAccount.zipCode.sendKeys(row.get("Zip Code"));
            registerAccount.phoneNumber.sendKeys(row.get("Phone"));
            registerAccount.customerSSN.sendKeys(row.get("SSN"));
            registerAccount.userName.sendKeys(row.get("Username"));
            registerAccount.password.sendKeys(row.get("Password"));
            registerAccount.confirmPassword.sendKeys(row.get("Confirm"));
        }
    }

    @When("user clicks the register button")
    public void user_clicks_the_register_button() {
       
        steps.click(registerAccount.registerButton);
    }

    @Then("user registered successfully")
    public void user_registered_successfully() {
       String actualRegistrationText=steps.getElementText(registerAccount.registrationSuccessText);
       String expectedRegistrationText = ConfigReader.getProperty("success_registration_text");
       System.out.println("expectedRegistrationText");
       assertTrue(actualRegistrationText.contains(expectedRegistrationText));
       
    }

    @When("Register is clicked")
    public void register_is_clicked() {
       
    	  steps.click(registerAccount.clickToRegisterLink);
    }

    @When("the user enters wrong confirm password")
    public void user_enters_wrong_confirm_password(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            registerAccount.firstName.sendKeys(row.get("First Name"));
            registerAccount.lastName.sendKeys(row.get("Last Name"));
            registerAccount.address.sendKeys(row.get("Address"));
            registerAccount.city.sendKeys(row.get("City"));
            registerAccount.state.sendKeys(row.get("State"));
            registerAccount.zipCode.sendKeys(row.get("Zip Code"));
            registerAccount.phoneNumber.sendKeys(row.get("Phone"));
            registerAccount.customerSSN.sendKeys(row.get("SSN"));
            registerAccount.userName.sendKeys(row.get("Username"));
            registerAccount.password.sendKeys(row.get("Password"));
            registerAccount.confirmPassword.sendKeys(row.get("Confirm"));
        }
    }


   
    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> errors = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : errors) {
            String expectedError = row.get("error");
            String actualError = driver.findElement(By.cssSelector(".error")).getText();
            assertEquals(expectedError, actualError);
        }
    }
    
       
   }
