package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFunds {
	
	
	/*
	 Initializes the web elements for the TransferFunds page 
	 using the provided WebDriver instance.
	 */
	
	public TransferFunds(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * WebElements representing various fields in the Transfer Funds page.
	 */
	
	@FindBy(xpath="//a[normalize-space()='Transfer Funds']")
	public WebElement transferFundsLink;
	
	@FindBy(xpath="//input[@id='amount']")
	public WebElement amount;
	
	@FindBy (xpath="//select[@id='toAccountId']")
	public WebElement toAccount;

	@FindBy(xpath="//input[@value='Transfer']")
	public WebElement transferButton;
	
	@FindBy(xpath="//h1[normalize-space()='Transfer Complete!']")
	public WebElement transferCompleteText;
}
