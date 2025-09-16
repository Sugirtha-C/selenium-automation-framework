package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	//Page Elements of Sign-in Page
	
	@FindBy(xpath="//h1[@class='page-title']")
	public WebElement pageTitleText;
	
	@FindBy(xpath="//div[@class='block block-customer-login']//div//strong[@id='block-customer-login-heading' and contains(text(),'Registered Customers')]")
	public WebElement registeredCustomersBlockText;
	
	@FindBy(xpath="//div[@class='field email required']//div//input[@id='email']")
	public WebElement registeredEmailID;
	
	@FindBy(xpath="//div[@class='field password required']//div[@class='control']//input[@id='pass']")
	public WebElement registeredPassword;
	
	@FindBy(xpath="//button[@class='action login primary'][@name='send']")
	public WebElement loginButton;
	
	@FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, test2 test2!']")
	public WebElement welcomeuserText;
	
	@FindBy(xpath="//div[@class='box box-information'][@class='box box-information']//p")
	public WebElement accountInformation;
	
	@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	//cssSelector("button.action.switch")
	public WebElement signOutArrowLink;
	
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	public WebElement signOutButton;
	
	//Error messages
	
	@FindBy (xpath="//div[@class='field email required']//div[@class='control']//div[@id='email-error']")
	public WebElement loginEmailErrorMessage;
	
	@FindBy (id="pass-error")
	public WebElement loginPasswordErrorMessage;
	
	@FindBy(xpath="//a[@class='action remind']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//div[@class='page messages']//div[@role='alert']//div[@data-ui-id='message-error']")
	public WebElement incorrectLoginMessage;
	
	@FindBy(xpath="//a[@class='action create primary']")
	public WebElement createAccountLink_SignInPage;
	
	@FindBy(xpath="//div[@class='product details product-item-details']//strong[@class='product name product-item-name']//a[@class='product-item-link'][contains(text(),'Didi Sport Watch')]")
	public WebElement productToBuy;
	
	@FindBy(xpath="//form[@data-product-sku='24-WG02']//div[@class='actions']//button[@id='product-addtocart-button']")
	public WebElement addToCart;
	
	//@FindBy(xpath="//span[@class='counter-number']")
	@FindBy(xpath="//a[@class='action showcart active']")
	public WebElement showCartCounterLink;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	public WebElement checkOutButton;
	
	@FindBy(xpath="//tr[@class='row']//td[@class='col col-method']//input[@value='tablerate_bestway']")
	public WebElement shippingMethodOption;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//button[@class='button action continue primary']")
	public WebElement nextButton;
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	public WebElement placeOrderButton;
	
	@FindBy(xpath="//span[@class='base']")
	public WebElement orderConfirmationPage;
	
	public SignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}

}
