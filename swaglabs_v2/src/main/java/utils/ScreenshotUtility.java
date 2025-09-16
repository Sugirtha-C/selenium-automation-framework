package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;


public class ScreenshotUtility {
	
	
	   private WebDriver driver;
	   

	    public ScreenshotUtility(WebDriver driver) {
	        this.driver = driver;
	    }

	    /*public void takeScreenshot(String fileName) {
	        File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String filepath=System.getProperty("user.dir") + "/src/test/resources/screenshots/" + fileName + ".png";
	        File destinationPath=new File(filepath);
	        try {
	            
	        	 FileUtils.forceMkdirParent(destinationPath);
	        	FileUtils.copyFile(pic,destinationPath );
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/
	    
	    public void takeScreenshot(String fileName) {
	        System.out.println("Taking screenshot: " + fileName); 

	        if (driver == null) {
	            System.err.println("WebDriver is null. Cannot take screenshot.");
	            return;
	        }

	        try {
	            File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String filepath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + fileName + ".png";
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

