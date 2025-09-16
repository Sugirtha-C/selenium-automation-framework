package steps;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Browser;
import config.ConfigReader;
import pages.Swagpage;

public class CommonSteps {
	
	private WebDriver driver=Browser.getDriver();
	private Swagpage swagpage;
	
	public CommonSteps(WebDriver driver) {
		this.driver=driver;
		swagpage=new Swagpage(driver);
	}
	
public Swagpage getSwagpage() {
		
		return swagpage;
	}
	
	public void openLabs() {
		driver.get(ConfigReader.getProperty("url"));
	}
	
	public void sendLoginValue(String query) {
		swagpage.login.sendKeys(query);
		
	}

	public void sendPasswordValue(String query) {
		swagpage.password.sendKeys(query);
		//swagpage.loginButton.click();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	  public int getNumberOfItemsInCart() {
	        return swagpage.itemsListInCart.size();
	    }
	


}
