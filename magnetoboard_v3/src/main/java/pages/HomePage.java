package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Home page elements
	
	@FindBy(xpath="//div[@class='message global demo']//p")
	public WebElement showDemoMessage;	
	
	@FindBy(xpath="//ul[@class='header links']//li[3]//a")
	public WebElement signUpLink;
	
	@FindBy(xpath="//ul[@class='header links']//li[2]//a[contains(text(),'Sign In')]")
	public WebElement signInLink;
	
	@FindBy(id="search")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[@class='action search']")
	public WebElement searchMagnifier;
	
	@FindBy(xpath="//ul//li[@id='qs-option-3']")
	public WebElement AutoCompleteSearchOption;
	
	@FindBy(xpath="//ol[@class='products list items product-items']")
	public WebElement searchResultsPage;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li")
	public List<WebElement> searchResultsCount;
	
	@FindBy(css="a[class='logo']")
	public WebElement storeLogo;
	
	@FindBy(xpath="//span[@class='counter-number']")
	public WebElement cartBadgeNumber;
	
	@FindBy(xpath="//a[@class='action showcart active']")
	public WebElement showCartLink;
	
	@FindBy(xpath="//a[@id='ui-id-4']")
	public WebElement womenLink;
	
	@FindBy(xpath="//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
	public WebElement womenLinkDropListArrow;
	
	@FindBy(xpath="//a[@id='ui-id-5']")
	public WebElement menLink;
	
	@FindBy(xpath="//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
	public WebElement menLinkDropListArrow;
	
	@FindBy(xpath="//a[@id='ui-id-6']")
	public WebElement gearLink;
	////ul[contains(@class, 'level0 submenu ui-menu')]/li
	@FindBy(xpath="//a[@id='ui-id-6']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
	public WebElement gearLinkDropListArrow;
	
	@FindBy(xpath="//a[@id='ui-id-7']")
	public WebElement trainingLink;
	
	@FindBy(xpath="//a[@id='ui-id-7']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
	public WebElement trainingLinkDropListArrow;
	
	@FindBy(xpath="//a[@id='ui-id-8']")
	public WebElement saleLink;
	
	@FindBy(xpath="//ol[@class='product-items widget-product-grid']")
	public WebElement productGrid;
	
	@FindBy(xpath="//li[@class='product-item']")
	public WebElement productItem;	
	
	@FindBy(xpath="//a[@id='ui-id-10']")
	public WebElement nestedFirstLevel;
	
	@FindBy(xpath="//a[@id='ui-id-16']")
	public WebElement nestedSecondLevel;
	
	@FindBy(xpath="//a[@id='ui-id-6']/following-sibling::ul[contains(@class, 'level0 submenu ui-menu')]/li")
	public List<WebElement> nestedFirstLevel_Gear;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
}


	