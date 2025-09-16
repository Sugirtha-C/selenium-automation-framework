package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;


/*
 * The ScreenshotUtility class handles capturing and saving screenshots:
 * 
 * - Takes a screenshot and saves it to a specified folder and file name with error handling.
 * - Retrieves a screenshot as a byte array.
 * 
 * Uses Selenium's TakesScreenshot and Apache Commons IO for file management.
 */

public class ScreenshotUtility {
	
	
	   private WebDriver driver;

	    public ScreenshotUtility(WebDriver driver) {
	        this.driver = driver;
	    }  
	
	    public void takeScreenshot(String folderName, String fileName) {
	    	
	        System.out.println("Taking screenshot: " + fileName);

	        if (driver == null) {
	            System.err.println("WebDriver is null. Cannot take screenshot.");
	            return;
	        }

	        try {
	            File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            
	            String filepath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + folderName + "/" + fileName + ".png";
	            File destinationPath = new File(filepath);
	            
	            FileUtils.forceMkdirParent(destinationPath);
	            FileUtils.copyFile(pic, destinationPath);
	            
	            System.out.println("Screenshot saved: " + filepath); 
	        } catch (IOException e) {
	            System.err.println("Error saving screenshot: " + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.err.println("Unexpected error: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    public byte[] getScreenshotAsBytes() {
	    	if (driver == null) {
	            System.err.println("WebDriver is null. Cannot take screenshot.");
	            return new byte[0];
	        }
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	    
	    
	}

