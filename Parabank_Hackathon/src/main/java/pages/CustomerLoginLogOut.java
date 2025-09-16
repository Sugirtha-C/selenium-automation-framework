package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginLogOut {

	/*
	 * This constructor initializes the web elements for the CustomerLoginLogOut page 
	 * 	using the PageFactory class.
	 */
	
	public CustomerLoginLogOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	/*
	 * WebElements representing various fields in the login logout page.
	 */
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement loginTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;
	
	@FindBy(xpath="//h1[normalize-space()='Accounts Overview']")
	public WebElement accountOverview;
	
	@FindBy(xpath="//p[@class='error']")
	public WebElement emptyInputLoginError;
	
	@FindBy(xpath="//a[normalize-space()='Log Out']")
	public WebElement logOutLink;
}
