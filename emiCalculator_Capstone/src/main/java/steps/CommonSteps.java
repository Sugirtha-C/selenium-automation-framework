package steps;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.Browser;
import config.ConfigReader;
import utils.ScreenshotUtility;

/**
 * Provides common steps and utilities for interacting with web elements in Selenium tests.
 * 
 * This class includes methods for interacting with web elements, performing common actions,
 * and managing timeouts and screenshots.
 * 
 */
public class CommonSteps {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private ScreenshotUtility screenshots;
    private Actions actions;
    
    /**
     * Constructor for the CommonSteps class.
     * Initializes the WebDriver instance, WebDriverWait, ScreenshotUtility, and Actions
     * required for common actions in the tests.
     *
     * @param driver the WebDriver instance used for browser interactions
     */
    public CommonSteps(WebDriver driver) {
        this.driver = Browser.getDriver();
        this.screenshots = new ScreenshotUtility(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.actions = new Actions(driver);
    }
    
    /**
     * Returns the ScreenshotUtility instance used for capturing screenshots.
     *
     * @return the ScreenshotUtility instance
     */
    public ScreenshotUtility getScreenshots() {
        return this.screenshots;
    }
    
    /**
     * Performs a double-click action on the specified web element.
     *
     * @param element the WebElement to double-click
     */
    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }
    
    /**
     * Opens the URL specified in the configuration file.
     */
    public void openSite() {
        driver.get(ConfigReader.getProperty("url"));
    }
    
    /**
     * Clears the text from the specified web element.
     *
     * @param element the WebElement to clear
     */
    public void clearField(WebElement element) {
        element.clear();
    }
    
    /**
     * Clears the text from the specified web element using JavaScript.
     *
     * @param element the WebElement to clear
     */
    public void clearFieldUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", element);
    }
    
    /**
     * Clicks on the specified web element using JavaScript.
     *
     * @param element the WebElement to click
     */
    public void clickFieldUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    /**
     * Submits the form or field associated with the specified web element by sending the ENTER key.
     *
     * @param element the WebElement to submit
     */
    public void submit(WebElement element) {
        actions.sendKeys(element, org.openqa.selenium.Keys.ENTER).perform();
    }
    
    /**
     * Retrieves the text content of the specified web element.
     *
     * @param element the WebElement from which to retrieve text
     * @return the text content of the WebElement
     */
    public String getElementText(WebElement element) {
        return element.getText();
    }
    
    /**
     * Clicks on the specified web element.
     *
     * @param element the WebElement to click
     */
    public void click(WebElement element) {
        element.click();
    }
    
    /**
     * Checks if the specified web element is present and visible on the page.
     *
     * @param element the WebElement to check
     * @return true if the WebElement is displayed, false otherwise
     */
    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }
    
    /**
     * Waits until the specified web element is visible on the page.
     *
     * @param element the WebElement to wait for
     */
    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * Waits until the specified web element is clickable.
     *
     * @param element the WebElement to wait for
     */
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * Takes a screenshot and saves it to the specified folder with the given file name.
     *
     * @param folderName the name of the folder where the screenshot will be saved
     * @param fileName the name of the file to save the screenshot as (without extension)
     */
    public void takeScreenshot(String folderName, String fileName) {
        screenshots.takeScreenshot(folderName, fileName);
    }
}
