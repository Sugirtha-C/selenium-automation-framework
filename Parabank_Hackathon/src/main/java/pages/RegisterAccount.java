package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccount {
	
	
	/*
	 * This constructor initializes the web elements for the CustomerLoginLogOut page 
	 * 	using the PageFactory class.
	 */
	
	public RegisterAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*
	 * WebElements representing various fields in the Register account page.
	 */
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	public WebElement clickToRegisterLink;
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	public WebElement address;
	
	@FindBy(xpath="//input[@id='customer.address.city']")
	public WebElement city;
		
	@FindBy(xpath="//input[@id='customer.address.state']")
	public WebElement state;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	public WebElement zipCode;
		
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	public WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']")
	public WebElement customerSSN;	
	
	@FindBy(id="customer.username")
	public WebElement userName;	
	
	@FindBy(id="customer.password")
	public WebElement password;	
	
	@FindBy(id="repeatedPassword")
	public WebElement confirmPassword;
		
	@FindBy(xpath="//input[@value='Register']")
	public WebElement registerButton;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]")
	public WebElement registrationSuccessText;
	
	//Elements for error messages
	
	@FindBy(xpath="//span[@id='customer.firstName.errors']")
	public WebElement emptyFirstNameError;
	
	@FindBy(xpath="//span[@id='customer.lastName.errors']")
	public WebElement emptyLastNameError;
	
	@FindBy(xpath="//span[@id='customer.address.street.errors']")	
	public WebElement emptyAddressError;
	
	@FindBy(xpath="//span[@id='customer.address.city.errors']")
	public WebElement emptyCityError;
	
	@FindBy(xpath="//span[@id='customer.address.state.errors']")
	public WebElement emptyStateError;
	
	@FindBy(xpath="//span[@id='customer.address.zipCode.errors']")
	public WebElement emptyZipCodeError;
	
	@FindBy(xpath="//span[@id='customer.ssn.errors']")
	public WebElement emptySSNError;
	
	@FindBy(xpath="//span[@id='customer.username.errors']")
	public WebElement emptyUserNameError;
	
	@FindBy(xpath="//span[@id='customer.password.errors']")
	public WebElement PasswordError;
	
	@FindBy(xpath="//span[@id='repeatedPassword.errors']")
	public WebElement ConfirmPasswordError;
		

}
