package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Browser;
import pages.HomeLoanCalc;
import utils.ScreenshotUtility;


public class HomeLoanCalcSteps {
	
    private CommonSteps commonSteps;
    private HomeLoanCalc homeLoanCalc;
    private WebDriver driver;
    private WebDriverWait wait;
    private ScreenshotUtility screenshots;
    private Actions actions;
    
    
    /**
     * Constructor for the HomeLoanCalcSteps class.
     * Initializes the CommonSteps and HomeLoanCalc page object.
     *
     * @param driver the WebDriver instance to be used for interacting with web elements
     */
    
    
    public HomeLoanCalcSteps(WebDriver driver) {
    	this.driver = Browser.getDriver();    	
        this.screenshots = new ScreenshotUtility(driver);
        this.homeLoanCalc = new HomeLoanCalc(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        this.actions=new Actions(driver);
        this.commonSteps=new CommonSteps(driver);
    }
    
    /**
     * Gets the HomeLoanCalc page object.
     *
     * @return the HomeLoanCalc page object
     */
    
        public HomeLoanCalc getHomeLoanCalc() {
        return this.homeLoanCalc;
    }
        
    /**
     * Enters the loan amount into the appropriate input field.
     *
     * @param loanAmount the loan amount to be entered
     */
    public void enterLoanAmount(String loanAmount) {
        commonSteps.waitForElementToBeVisible(homeLoanCalc.homeLoanAmount);
        commonSteps.doubleClick(homeLoanCalc.homeLoanAmount);
        commonSteps.clearField(homeLoanCalc.homeLoanAmount);
        homeLoanCalc.homeLoanAmount.sendKeys(loanAmount);
    }
    /**
     * Enters the interest rate into the appropriate input field.
     *
     * @param interestRate the interest rate to be entered
     */
    public void enterInterestRate(String interestRate) {
        commonSteps.waitForElementToBeVisible(homeLoanCalc.homeLoanInterestRate);
        commonSteps.doubleClick(homeLoanCalc.homeLoanInterestRate);
        commonSteps.clearFieldUsingJavaScript(homeLoanCalc.homeLoanInterestRate);
        homeLoanCalc.homeLoanInterestRate.sendKeys(interestRate);
    }
    /**
     * Enters the loan tenure into the appropriate input field.
     *
     * @param tenure the loan tenure to be entered
     */
    public void enterLoanTenure(String tenure) {
        commonSteps.waitForElementToBeVisible(homeLoanCalc.homeLoanTermInput);
        commonSteps.clearFieldUsingJavaScript(homeLoanCalc.homeLoanTermInput);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        homeLoanCalc.homeLoanTermInput.sendKeys(tenure);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}       
        commonSteps.submit(homeLoanCalc.homeLoanTermInput);
    }
    
    /**
     * Takes a screenshot with the specified name, saved under the "HomeLoanCalcTests" folder.
     *
     * @param screenshotName the name for the screenshot file
     */
    public void takeScreenshot(String screenshotName) {
        commonSteps.takeScreenshot("HomeLoanCalcTests", screenshotName);
    }
    /**
     * Retrieves the EMI value from the output field.
     *
     * @return the EMI value as a string
     */
    public String getLoanEMIValue() {
        commonSteps.waitForElementToBeVisible(homeLoanCalc.loanEMiOutputValue);
        return commonSteps.getElementText(homeLoanCalc.loanEMiOutputValue);
    }
    /**
     * Retrieves the total payment value from the output field.
     *
     * @return the total payment value as a string
     */
    public String getTotalPaymentValue() {
        commonSteps.waitForElementToBeVisible(homeLoanCalc.totalPaymentOutputValue);
        return commonSteps.getElementText(homeLoanCalc.totalPaymentOutputValue);
    }
}