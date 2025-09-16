package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class OpenNewAccount {

	/*
	 * This constructor initializes the web elements for the CustomerLoginLogOut page 
	 * 	using the PageFactory class.
	 */
	
	public OpenNewAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * WebElements representing various fields in the open new account page.
	 */

	@FindBy(xpath="//a[normalize-space()='Open New Account']")
	public WebElement openNewAccountLink;

	@FindBy(xpath="//select[@id='type']")
	public WebElement accountType;
	
	@FindBy(xpath="//select[@id='fromAccountId']")
	public WebElement accountId;
	//15009
	
	@FindBy(xpath="//input[@value='Open New Account']")
	public WebElement createAccountButton;
	
	@FindBy(xpath="//h1[normalize-space()='Account Opened!']")
	public WebElement successText;
}
