package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import config.Browser;
import utils.ExcelUtility;
import utils.ScreenshotUtility;

/*
 * The Testlisteners class implements ITestListener to manage test execution events:
 * 
 * - Records test results (passed, failed, skipped) in an Excel file.
 * - Takes a screenshot on test success or failure.
 * - Saves the results to an Excel file upon test completion.
 * 
 * Utilizes ExcelUtils for result recording and ScreenshotUtility for capturing screenshots.
 */

public class TestListeners implements ITestListener{
	
	//private String excelpath="/home/zadmin/Documents/Java_HandsOn/emiCalculator/src/test/resources/TestResult/results.xlsx";
	private String excelpath=System.getProperty("user.dir")+"/src/test/resources/TestResult/results.xlsx";
	ExcelUtility excelutils;
	private ScreenshotUtility screenshotUtility;
	
	public TestListeners(){
		excelutils=new ExcelUtility();
	}
	
		public void onTestSuccess(ITestResult result) {
			excelutils.recordTestResult(result.getMethod().getMethodName(),"passed");
			captureScreenshot(result);
		}
		
		public void onTestFailure(ITestResult result) {
			excelutils.recordTestResult(result.getMethod().getMethodName(),"failed");
			captureScreenshot(result);
		}
		public void onTestSkipped(ITestResult result) {
			excelutils.recordTestResult(result.getMethod().getMethodName(),"skipped");
		}
		
		public void onFinish(ITestContext context) {
			try{
				excelutils.writeTestResultsToExcel(excelpath);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		private void captureScreenshot(ITestResult testresult) {
			
			WebDriver driver=Browser.getDriver();
			if(driver==null) {
				System.out.println("Driver is null. Cannot take a screenshot");
			}
			
			screenshotUtility=new ScreenshotUtility(driver);
			String folderName="TestNG_Tests";
			String fileName=testresult.getMethod().getMethodName()+"_";
			screenshotUtility.takeScreenshot(folderName, fileName);
			
					
		}

}
