package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	//Create An Account-page elements
	
		@FindBy(xpath="//form[@id='form-validate']")
		public WebElement signUpForm;
		
		@FindBy(id="firstname")
		public WebElement firstNameTextBox;
		
		@FindBy(id="lastname")
		public WebElement lastNameTextBox;
		
		@FindBy(id="email_address")
		public WebElement emailTextBox;
		
		@FindBy(id="password")
		public WebElement passwordTextBox;
		
		@FindBy(xpath="//div[@id='password-strength-meter']")
		public WebElement passwordStrengthMeter;
		
		@FindBy(xpath="//div//input[@id='password-confirmation']")
		public WebElement passwordConfirmationTextBox;
		
		@FindBy(xpath="//fieldset[contains(@data-hasrequired, '* Required Fields')]")
		public WebElement requiredFieldsText;
		
		@FindBy(css="div.control div.mage-error#password-error")
		public WebElement passwordRequiredError;
		
		@FindBy(css="div.control div.mage-error#email_address-error")
		public WebElement emailRequiredError;	

		@FindBy(id="password-strength-meter-label")
		public WebElement passwordStrengthMeterLabel;
		
		@FindBy(xpath="//button[@class='action submit primary']")
		public WebElement createAccountButton;
		
		@FindBy(xpath="div.control div.mage-error#password-confirmation-error")
		public WebElement confirmPasswordError;

		@FindBy(xpath="//div[@role='alert']//div[@data-ui-id='message-success']")
		public WebElement successResponseMessage;
		
		//@FindBy(xpath="//li[@class='customer-welcome active']//button[@class='action switch']")
		//public WebElement signOutArrowLink;
		
		//@FindBy(xpath="//div[@class='customer-menu']//ul[@class='header links']//li[@class='authorization-link']/a")
		//public WebElement signOutLink2;
		
		public SignUpPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			
			PageFactory.initElements(driver, this);
		}
}
