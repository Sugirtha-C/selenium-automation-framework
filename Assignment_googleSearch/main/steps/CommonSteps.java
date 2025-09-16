package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;

import config.Browser;
import pages.GooglePage;

public class CommonSteps {


	public static void clickAboutLink() {
        GooglePage.clickAboutPageLink();
    }
    
    public static String getAboutPageText() {
        CommonSteps.clickAboutLink();
        return GooglePage.getAboutPageText().getText();
    }
    
	public static void navigateToGoogle() {
        Browser.getBrowser();
        Browser.redirect("http://www.google.co.uk");
    }

	 public static void performSearch(String searchText) {
	        GooglePage.enterSearchText(searchText);
	        GooglePage.clickSearchButton();
	    }

	  public static String getSearchResultText() {
	        return GooglePage.getSearchResultsText();
	    }

	  public static String getResultStats() {
		  return GooglePage.getResultStats();
	  }
	    }
