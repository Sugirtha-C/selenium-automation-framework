package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterAdvancedSearch {

	//AdvanceSearch in Footer link
	
	@FindBy(xpath="//ul[@class='footer links']//a[@data-action='advanced-search']")
	public WebElement advancedSearchLink;
	
	@FindBy(id="name")
	public WebElement productName;
	
	@FindBy(xpath="//input[@name='price[from]']")
	public WebElement minPriceRange;
	
	@FindBy(xpath="//input[@name='price[to]']")
	public WebElement maxPriceRange;
	
	@FindBy(xpath="//button[@class='action search primary']")
	public WebElement searchButton;
	
}
