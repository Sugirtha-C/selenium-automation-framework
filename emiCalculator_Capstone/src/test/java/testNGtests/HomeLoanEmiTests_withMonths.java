package testNGtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import config.Browser;
import listeners.TestListeners;
import pages.HomeLoanCalc;
import steps.CommonSteps;
import steps.HomeLoanCalcSteps;
import utils.ScreenshotUtility;
import utils.DataProviderUtility;

/**
 * Test class for verifying EMI and total payment values for home loan calculations with tenure specified in months.
 * 
 * This class uses TestNG to run tests that validate EMI and total payment calculations based on input data provided
 * by DataProviderUtility. It includes setup and teardown methods for initializing and closing the WebDriver,
 * and it captures screenshots for validation and error handling.
 * 
 */
@Listeners(TestListeners.class)
public class HomeLoanEmiTests_withMonths {
    
    private WebDriver driver;
    private HomeLoanCalcSteps homeLoanCalcSteps;
    private HomeLoanCalc homeLoanCalc;
    private ScreenshotUtility screenshotUtility;
    private CommonSteps commonSteps;
    private String actualEMI, actualTotalPayment;
    
    /**
     * Sets up the test environment by initializing WebDriver, page objects, and utilities.
     * This method is called before any test method in the class is executed.
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
     * Tests the EMI and total payment calculations with loan tenure specified in months.
     * 
     * This test performs the following steps:
     * - Opens the home loan calculator website.
     * - Enters loan amount, interest rate, and tenure in months.
     * - Retrieves EMI and total payment values.
     * - Validates the retrieved values against expected results.
     * - Takes screenshots at various stages for validation and error handling.
     * 
     *
     * @param loanAmount the amount of the loan
     * @param interestRate the interest rate for the loan
     * @param termInMonths the tenure of the loan in months
     * @param expectedLoanEMI the expected EMI value for validation
     * @param expectedTotalPayment the expected total payment value for validation
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
    @Test(dataProvider="CalcEmiWithTenureAsMonths", dataProviderClass=DataProviderUtility.class)
    public void verifyEmiValuesWithYearsTenureInMonths(String loanAmount, String interestRate, String termInMonths, String expectedLoanEMI, String expectedTotalPayment) throws InterruptedException {
        
        try {
            // Open the website
            commonSteps.openSite();
            
            try {
                // Enter Loan Details
                homeLoanCalcSteps.enterLoanAmount(loanAmount);
                homeLoanCalcSteps.enterInterestRate(interestRate);
                Thread.sleep(1000); // Wait for UI updates
                commonSteps.clickFieldUsingJavaScript(homeLoanCalc.homeLoanTenureInMonths);
                Thread.sleep(1000); // Wait for UI updates
                homeLoanCalcSteps.enterLoanTenure(termInMonths);
                
            } catch (Exception e) {
                // Take a screenshot after entering the details
                screenshotUtility.takeScreenshot("HomeLoanDetails", "LoanDetails_" + loanAmount + "_" + termInMonths);
                Assert.fail("Failed to enter loan details: " + e.getMessage());
            }
            
            try {
                // Retrieve EMI and Total Payment Values
                actualEMI = homeLoanCalcSteps.getLoanEMIValue();
                actualTotalPayment = homeLoanCalcSteps.getTotalPaymentValue();
                
            } catch (Exception e) {
                // Capture screenshot if retrieval fails
                screenshotUtility.takeScreenshot("Error Screenshots", "RetrievedValuesErrors_" + loanAmount + "_" + termInMonths);
                Assert.fail("Failed to retrieve output values: " + e.getMessage());
            }
            
            try {
                // Assert EMI and Total Payment Values
                Assert.assertEquals(actualEMI, expectedLoanEMI, "EMI value does not match the expected value.");
                Assert.assertEquals(actualTotalPayment, expectedTotalPayment, "Total Payment value does not match the expected value.");
                
            } catch (Exception e) {
                // Capture screenshot if assertion fails
                screenshotUtility.takeScreenshot("Error Screenshots", "AssertionErrors_" + loanAmount + "_" + termInMonths);
                throw e;
            }
            
            try {
                // Take a screenshot after validation
                screenshotUtility.takeScreenshot("HomeLoanResults", "Results_" + loanAmount + "_" + termInMonths);
                
            } catch (Exception e) {
                Assert.fail("Failed to take a screenshot after validations: " + e.getMessage());
            }
        } catch (Exception e) {
            // Capture screenshot for any unexpected error
            screenshotUtility.takeScreenshot("Error Screenshots", "GeneralErrors_" + loanAmount + "_" + termInMonths);
            Assert.fail("Unexpected error occurred: " + e.getMessage());
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
