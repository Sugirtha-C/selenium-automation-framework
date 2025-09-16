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

/*
 * The ValidRegistration class handles the valid registration process:
 * 
 * - Enters valid registration data into the form fields.
 * - Verifies successful registration by checking the success message displayed on the page.
 * 
 * Utilizes the Steps class for actions and the RegisterAccount page object for form elements.
 */

public class ValidRegistration {

     private Steps steps;
	 private RegisterAccount registerAccount;
	 private WebDriver driver;
	 private ExcelUtils excelUtils;
	 private Map<String, String> registrationData;

		
	public ValidRegistration() {
			
		this.steps=new Steps(Browser.getDriver());
		this.registerAccount=steps.getregisterAccount();			
		driver=Browser.getDriver();
		excelUtils = new ExcelUtils();
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

  

    @Then("user registered successfully")
    public void user_registered_successfully() {
       String actualRegistrationText=steps.getElementText(registerAccount.registrationSuccessText);
       String expectedRegistrationText = ConfigReader.getProperty("success_registration_text");
       System.out.println("expectedRegistrationText");
       assertTrue(actualRegistrationText.contains(expectedRegistrationText));
       
    }

    
   }
