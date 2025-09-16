package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoan {

	/*
	 * This constructor initializes the web elements for the CustomerLoginLogOut page 
	 * 	using the PageFactory class.
	 */
	
	public RequestLoan(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * WebElements representing various fields in the loan request page.
	 */
	
	@FindBy(xpath="a[normalize-space()='Request Loan']")
	public WebElement clickRequestLoanLink;
	
	@FindBy(xpath="//input[@id='amount']")
	public WebElement loanAmount;
	
	@FindBy(xpath="//input[@id='downPayment']")
	public WebElement downPayment;
	
	@FindBy(xpath="//input[@value='Apply Now']")
	public WebElement applyNowButton;
	
	@FindBy(xpath="//h1[normalize-space()='Loan Request Processed']")
	public WebElement loanRequestSuccess;
}



