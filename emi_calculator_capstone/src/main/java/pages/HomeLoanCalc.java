package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Home Loan Calculator page in the web application.
 * This class uses Selenium Page Factory to initialize and locate 
 * web elements on the Home Loan Calculator page.
 */
public class HomeLoanCalc {
    
    /**
     * Constructor for HomeLoanCalc class.
     * Initializes the web elements using Selenium Page Factory.
     *
     * @param driver the WebDriver instance used to interact with the web elements
     */
    public HomeLoanCalc(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    /**
     * WebElement representing the input field for the home loan amount.
     */
    @FindBy(id="loanamount")
    public WebElement homeLoanAmount;
    
    /**
     * WebElement representing the input field for the home loan interest rate.
     */
    @FindBy(xpath="//input[@id='loaninterest']")
    public WebElement homeLoanInterestRate;
    
    /**
     * WebElement representing the input field for the home loan term in months or years.
     */
    @FindBy(id="loanterm")
    public WebElement homeLoanTermInput;
    
    /**
     * WebElement representing the checkbox or input field for the home loan tenure in years.
     */
    @FindBy(xpath="//label//input[@id='loanyears']")
    public WebElement homeLoanTenureInYears;
    
    /**
     * WebElement representing the checkbox or input field for the home loan tenure in months.
     */
    @FindBy(xpath="//label[input[@id='loanmonths']]")
    public WebElement homeLoanTenureInMonths;
        
    /**
     * WebElement representing the output value of the calculated EMI amount.
     */
    @FindBy(xpath="//div[@id='emiamount']/p/span")
    public WebElement loanEMiOutputValue;
    
    /**
     * WebElement representing the output value of the total payment amount.
     */
    @FindBy(xpath="//div[@id='emitotalamount']/p/span")
    public WebElement totalPaymentOutputValue;
}
