package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * ConfigReader reads configuration values from the properties file.
 * It is used to externalize environment-specific data such as URL and browser.
 * This helps avoid hardcoding and improves maintainability.
 */

public class ConfigReader {

	static Properties prop;
	
	static {
		try {
			FileInputStream fis= new FileInputStream ("src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
