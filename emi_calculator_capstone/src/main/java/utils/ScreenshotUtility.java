package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for handling screenshots in Selenium tests.
 * Provides methods for capturing screenshots and saving them to a specified location,
 * as well as retrieving screenshots as byte arrays.
 * 
 * Utilizes Selenium's TakeScreenshot for capturing screenshots and Apache Commons IO
 * for file management.
 * 
 */
public class ScreenshotUtility {
    
    private WebDriver driver;

    /**
     * Constructor for ScreenshotUtility class.
     * Initializes the ScreenshotUtility with the given WebDriver instance.
     *
     * @param driver the WebDriver instance used to capture screenshots
     */
    public ScreenshotUtility(WebDriver driver) {
        this.driver = driver;
    }  

    /**
     * Captures a screenshot and saves it to the specified folder with the given file name.
     * 
     * The screenshot is saved as a PNG file in the folder specified by folderName
     * and with the file name specified by fileName. The folder structure is created
     * if it does not exist.
     * 
     *
     * @param folderName the name of the folder where the screenshot will be saved
     * @param fileName the name of the file to save the screenshot as (without extension)
     */
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
    
    /**
     * Captures a screenshot and returns it as a byte array.
     * 
     * This method can be used to obtain the screenshot data in byte form, which can be useful
     * for embedding images in reports or sending images over the network.
     * 
     *
     * @return a byte array containing the screenshot data
     */
    public byte[] getScreenshotAsBytes() {
        if (driver == null) {
            System.err.println("WebDriver is null. Cannot take screenshot.");
            return new byte[0];
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
