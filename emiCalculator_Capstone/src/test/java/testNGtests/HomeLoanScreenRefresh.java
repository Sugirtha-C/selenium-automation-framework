package testNGtests;

import pages.HomeLoanCalc;

import steps.CommonSteps;
import steps.HomeLoanCalcSteps;
import utils.ScreenshotUtility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.Browser;
import config.ConfigReader;
import listeners.TestListeners;
@Listeners(TestListeners.class)

/**
 * This class contains TestNG test methods for verifying the behavior of the 
 * Home Loan Calculator page after refreshing the browser.
 * It includes setup methods, test methods, and utilities for capturing 
 * screenshots and handling browser actions.
 */
public class HomeLoanScreenRefresh {

    private WebDriver driver;
    private HomeLoanCalcSteps homeLoanCalcSteps;
    private HomeLoanCalc homeLoanCalc;
    private ScreenshotUtility screenshotUtility;
    private CommonSteps commonSteps;

    /**
     * This method sets up the necessary components for the test, including
     * initializing WebDriver, Page Objects, and utility classes.
     * It is annotated with @BeforeClass to run before any test methods.
     */
    @BeforeClass
    public void setUp() {
        driver = Browser.getDriver();
        homeLoanCalcSteps = new HomeLoanCalcSteps(driver);
        homeLoanCalc = homeLoanCalcSteps.getHomeLoanCalc();
        screenshotUtility = new ScreenshotUtility(driver);
        commonSteps = new CommonSteps(driver);
    }

    /**
     * This test verifies that the calculated EMI and total payment values
     * remain consistent after refreshing the browser.
     * It sets input values, triggers calculations, and checks that the
     * results do not change after a browser refresh.
     */
    @Test
    public void verifyValuesAfterBrowserRefresh() {
        try {
            // Open the site and enter loan details
            commonSteps.openSite();
            homeLoanCalcSteps.enterLoanAmount("45000");
            homeLoanCalcSteps.enterInterestRate("5");

            // Wait for a few seconds to ensure calculations are done
            Thread.sleep(3000);

            // Refresh the browser
            Browser.refreshBrowser();

            // Wait for the EMI output value to be visible
            commonSteps.waitForElementToBeVisible(homeLoanCalc.loanEMiOutputValue);

            // Capture the values after the refresh
            String postRefreshEMIValue = homeLoanCalcSteps.getLoanEMIValue();
            String postRefreshTotalPayment = homeLoanCalcSteps.getTotalPaymentValue();

            // Take a screenshot of the state after the refresh
            screenshotUtility.takeScreenshot("HomeLoanCalcTests", "After_Refresh");

            // Retrieve expected values from the config
            String expectedEMIValue = ConfigReader.getProperty("Default_Loan_EMI_value");
            String expectedTotalPayment = ConfigReader.getProperty("Default_Total_Payment");

            // Validate that the values before and after refresh are the same
            assertEquals(postRefreshEMIValue, expectedEMIValue, "EMI value did not match after refresh");
            assertEquals(postRefreshTotalPayment, expectedTotalPayment, "Total payment value did not match after refresh");

        } catch (InterruptedException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Optionally fail the test in case of an interruption
            throw new RuntimeException("Test interrupted during sleep", e);
        } catch (Exception e) {
            // Catch any other exceptions that may occur
            e.printStackTrace();
            throw new RuntimeException("An unexpected error occurred during the test", e);
        }
    }
    
    /**
     * Closes the browser and cleans up resources after all tests in the class have been executed.
     * This method is called after all test methods in the class have been executed.
     */
    @AfterClass
    public void closeBrowser() {
        Browser.closeBrowser();
    }
}
