package config;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * Load and provides access to configuration properties from a properties file
 *  located at 'src/main/resources/config.properties' 
 *   The properties can then be retrieved using the getProperty method by providing the key of the desired property.
 */

public class ConfigReader {

	private static Properties properties=new Properties();
	
		static {	
		try(FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties"))
		{
			properties.load(fis);
			//System.out.println(fis);
			
			}catch(Exception e) {
			 e.printStackTrace(); 
		}
		
}	
		
	/*
	 *  Retrieves the value of a property from the loaded configuration properties.
	 *  Returns the value of property associated with the key value provided. 
	 */
	 public static String getProperty(String key) {
		        return properties.getProperty(key);
		    }
		
}
	


  
	 
	 
