package step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import config.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignInPage;
import steps.Steps;

public class SignInSignOut{

	private Steps steps;
	private HomePage homepage;
	private SignInPage signinpage;
	private WebDriver driver;
	String welcomeText;
	
	
	public SignInSignOut() {
		
		this.steps=new Steps(Browser.getDriver());
		this.homepage=steps.getHomePage();
		this.signinpage=steps.getSignInPage();
		driver=Browser.getDriver();
	}

@When("sign in is clicked")
public void sign_in_is_clicked() {
    
	steps.waitForElementToBeVisible(homepage.signInLink);
	homepage.signInLink.click();
}

@When("User Input {string} as username and {string} as password")
public void user_input_as_username_and_as_password(String username, String password) {
	steps.waitForElementToBeClickable(signinpage.registeredEmailID);
	signinpage.registeredEmailID.sendKeys(username);	
	
	steps.waitForElementToBeClickable(signinpage.registeredPassword);
	signinpage.registeredPassword.sendKeys(password);
	
}

@When("login is clicked")
public void clickLogin() {
	steps.waitForElementToBeClickable(signinpage.loginButton);
	signinpage.loginButton.click();
	
}
@When("Signout is clicked")
public void clickSignOut() {
	steps.waitForElementToBeVisible(signinpage.signOutArrowLink);
	signinpage.signOutArrowLink.click();  
   	steps.waitForElementToBeVisible(signinpage.signOutButton);
	signinpage.signOutButton.click();
	}

@Then("user signedout successfully.")
public void user_signedout_successfully() {
	String currentURl=driver.getCurrentUrl();
	System.out.println("Url navigated after sign out to: "+currentURl);
}


}
