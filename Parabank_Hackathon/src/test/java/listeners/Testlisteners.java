package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import config.Browser;
import utils.ExcelUtils;
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

	
	public class Testlisteners implements ITestListener{

		private String excelpath="/home/zadmin/Documents/Java_HandsOn/Parabank_Hackathon/src/test/resources/TestResult/results.xlsx";
		ExcelUtils excelutils;
		 private ScreenshotUtility screenshotUtility;
		
		public Testlisteners(){
			excelutils=new ExcelUtils();
		}
//		public void onStart(ITestResult result) {
//			
//		}
		//result.getMethod().getMethodName()-->it will give the method name
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
