package step_definitions;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import config.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import steps.Steps;
import steps.Steps;

public class VerifyDemoMessage {

	//private WebDriver driver=Browser.getDriver();
	//private Steps steps=new Steps(driver);
	//private HomePage homepage= new HomePage(driver);
	
	private String demoMessageText;
	private Steps steps;
	private HomePage homepage;
	
	public VerifyDemoMessage() {
		
		this.steps=new Steps(Browser.getDriver());
		this.homepage=steps.getHomePage();
	}
	  @Given("url {string} is launched")
	    public void url_is_launched(String url) {
	        steps.openSite();
	    }

	    @When("page is loaded")
	    public void page_is_loaded() {
	    	
	    	steps.waitForElementToBeVisible(homepage.showDemoMessage);
	    	demoMessageText=steps.getElementText(homepage.showDemoMessage);
	      
	    }

	    @Then("Demo message {string} is visible")
	    public void demo_message_is_visible(String expectedMessage) {
	       
	    	
			String expectedDemoMessage="This is a demo store to test your test automaiton scripts. No orders will be fulfilled. If you are facing any issue, email us at hello@softwaretestingboard.com.";
			assertEquals(demoMessageText,expectedDemoMessage,"Demo message is not as expected");
	    	
	    }
	    
	    }

