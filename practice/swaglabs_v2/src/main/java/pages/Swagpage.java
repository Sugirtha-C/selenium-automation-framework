package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swagpage {
	

    public static WebDriver webDriver;

	
	public Swagpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	public WebElement login;    //webelement searchbox=driver.findElement(By.name("q"));
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement loginButton;
	
	@FindBy(css="button[id='add-to-cart-sauce-labs-bolt-t-shirt']")
	public WebElement productToAdd_1;
	
	@FindBy(css="button[id='add-to-cart-sauce-labs-backpack']")
	public WebElement productToAdd_2;
	
	@FindBy(css="button[id='add-to-cart-sauce-labs-bike-light']")
	public WebElement productToAdd_3;
	
	@FindBy(css="button[id='add-to-cart-sauce-labs-fleece-jacket']")
	public WebElement productToAdd_4;
	
	@FindBy(id="inventory_container")
	public WebElement resultStats;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement shoppingCartIcon;
	
	@FindBy(css=".cart_item")
	public List<WebElement> itemsListInCart;
	
	@FindBy(xpath="//button[@class='error-button']")
	public WebElement loginError;
	
	@FindBy(xpath="//div[@class='error-message-container error']/h3")
	public WebElement loginErrorText;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement itemsCountInCart;
	
		


}
