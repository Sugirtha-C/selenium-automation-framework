package step_definitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.Browser;
import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterAccount;
import steps.Steps;
import utils.ExcelUtils;

/*
 * The InvalidRegistrations class handles invalid registration scenarios by:
 * 
 * - Entering data with an empty last name and verifying the error message.
 * - Entering incorrect confirm password data and checking the error message.
 * 
 * Uses the Steps class for common actions and interacts with the RegisterAccount page object for form elements.
 */

public class InvalidRegistrations {

	private Steps steps;
	private RegisterAccount registerAccount;
	private WebDriver driver;
	//private ExcelUtils excelUtils;
	private Map<String, String> registrationData;

			
		public InvalidRegistrations() {
			
			this.driver=Browser.getDriver();	
			this.steps=new Steps(driver);
			this.registerAccount=steps.getregisterAccount();		
			
			
			}
		
		  @Given("User already opened the webpage")
		    public void url_is_launched() throws IOException {
		    	 steps.openSite();
		    	
		    }
		    
		    @When("RegisterLink is clicked")
		    public void register_link_is_clicked() {
		        steps.click(registerAccount.clickToRegisterLink);
		         }
		
		
		@When("user enters data with lastName empty")
	    public void user_enters_valid_data(io.cucumber.datatable.DataTable dataTable) {
	        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	        for (Map<String, String> row : data) {
	        	registerAccount.firstName.sendKeys(row.get("First Name"));
	           // registerAccount.lastName.sendKeys(row.get("Last Name"));
	            String lastName = row.get("Last Name");
	            if (lastName == null || lastName.isEmpty()) {
	               registerAccount.lastName.sendKeys("");
	            
	            }
	            
	           // String lastName = row.getOrDefault("Last Name", "");
	            //registerAccount.lastName.sendKeys(lastName);
	            
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
		 @Then("the user should see an error message for empty last name")
		 public void userShouldSeeErrorMessage() {
			 String expectedError = ConfigReader.getProperty("lastName_error");
	          String actualError = registerAccount.emptyLastNameError.getText();
	            assertEquals(expectedError, actualError);
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
		    public void the_user_should_see_an_error_message() {
		        	        
		          String expectedError = ConfigReader.getProperty("confirm_password_error");
		          String actualError = registerAccount.ConfirmPasswordError.getText();
		            assertEquals(expectedError, actualError);
		        }
		    }
